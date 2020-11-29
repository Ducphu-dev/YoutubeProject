package com.example.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class HistoryFragment extends Fragment {


    public static String Key = "AIzaSyCHrmRJcOBNmTnFdiXV606jrN2TJYRTs6Y";
    String ID_listnhac = "PLiaWrX4zmrTkLFjNHh0h9xRG4ArtjqGHb";
    String urljson = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="+ ID_listnhac +"&key="+ Key +"&maxResults=30";
    ListView lv_history;
    ArrayList<ListNhac> arrayListnhac;
    ListNhacAdapter adapter;



    public HistoryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_history, container, false);

        arrayListnhac = new ArrayList<>();
        adapter= new ListNhacAdapter(getContext(),R.layout.history_items, arrayListnhac);

        ImageView img_menu = (ImageView) view.findViewById(R.id.img_menu);
        lv_history= view.findViewById(R.id.lv_history);
        lv_history.setAdapter(adapter);


        lv_history.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                showConfirmDelete();
                return false;
            }


        });

        lv_history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),PhatVideo.class);
                intent.putExtra("IDVideoYT",arrayListnhac.get(i).getIdvideo());
                intent.putExtra("NameYT",arrayListnhac.get(i).getTen());
                startActivity(intent);
            }
        });
        displayVideos();
        return view;


    }

    private void displayVideos() {

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urljson, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonitems = response.getJSONArray("items");
                    String jsontitle =""; String jsonurl = ""; String jsonvideoId = "";
                    for (int i = 0 ; i < jsonitems.length(); i++){
                        JSONObject jsonitem = jsonitems.getJSONObject(i);
                        JSONObject jsonSnippet = jsonitem.getJSONObject("snippet");
                        jsontitle = jsonSnippet.getString("title");

                        JSONObject jsonthumbnails = jsonSnippet.getJSONObject("thumbnails");
                        JSONObject jsonmedium = jsonthumbnails.getJSONObject("medium");

                        jsonurl = jsonmedium.getString("url");
                        JSONObject jsonresourceId = jsonSnippet.getJSONObject("resourceId");
                        jsonvideoId = jsonresourceId.getString("videoId");
                        arrayListnhac.add(new ListNhac(jsontitle,jsonurl,jsonvideoId));


                    }
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }

    private void showConfirmDelete(){
        AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
        builder.setTitle("Thông báo");
        builder.setMessage("bạn có muốn thêm vào danh sách phát");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //remove
                Toast.makeText(getContext(),"Đã thêm thành công", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(),"Thêm thất bại", Toast.LENGTH_LONG).show();

            }
        });
        Dialog dl = builder.create();
        dl.show();
    }

}