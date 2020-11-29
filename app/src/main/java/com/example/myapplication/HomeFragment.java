package com.example.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
//    Home[] lst = new Home[]{
//            new Home(R.drawable.aircooler, R.drawable.home,"Hướng dẫn lắp đặt tản khí",R.drawable.menu,"GearVN","7B lượt xem","1 phút"),
//            new Home(R.drawable.aiocooler, R.drawable.home,"Hướng dẫn lắp đặt tản khí",R.drawable.menu,"GearVN","7B lượt xem","1 phút"),
//            new Home(R.drawable.setup, R.drawable.home,"Hướng dẫn lắp đặt tản khí",R.drawable.menu,"GearVN","7B lượt xem","1 phút"),
//            new Home(R.drawable.pc, R.drawable.home,"Hướng dẫn lắp đặt tản khí",R.drawable.menu,"GearVN","7B lượt xem","1 phút"),
//            new Home(R.drawable.watercoolercustom, R.drawable.home,"Hướng dẫn lắp đặt tản khí",R.drawable.menu,"GearVN","7B lượt xem","1 phút"),
//    };
//    ListView lv_home;
//    public HomeFragment() {
//        // Required empty publ ic constructor
//    }
//
//
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        lv_home=view.findViewById(R.id.lv_home);
//        HomeAdapter adapter = new HomeAdapter(getActivity().getApplication(),lst);
//        lv_home.setAdapter(adapter);
//
//
//        return  view;
//    }
//
//
//    class HomeAdapter extends BaseAdapter {
//
//        private Home[] items;
//        private LayoutInflater layoutInflater;
//
//        public HomeAdapter(Context ctx, Home[] items) {
//            this.items = items;
//            layoutInflater = LayoutInflater.from(ctx);
//
//        }
//
//
//        @Override
//        public int getCount() {
//            return items.length;
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return items[i];
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            view = layoutInflater.inflate(R.layout.home_items, null);
//            ImageView img = view.findViewById(R.id.lv_img);
//            ImageView logo = view.findViewById(R.id.img_logo);
//            TextView tv_titles = view.findViewById(R.id.tv_titles);
//            ImageView menu = view.findViewById(R.id.img_menu);
//            TextView tv_channels = view.findViewById(R.id.tv_channels);
//            TextView tv_view = view.findViewById(R.id.tv_view);
//            TextView tv_date = view.findViewById(R.id.tv_date);
//
//
//
//            img.setImageResource(items[i].getImg());
//            logo.setImageResource(items[i].getLogo());
//            tv_titles.setText(items[i].getTitles());
//            menu.setImageResource(items[i].getMenu());
//            tv_channels.setText(items[i].getChannels());
//            tv_view.setText(items[i].getView());
//            tv_date.setText(items[i].getDate());
//            img.setScaleType(ImageView.ScaleType.FIT_XY);
//            return view;
//        }
//    }
//
//    class Home {
//        private int img;
//        private int logo;
//        private String titles;
//        private int menu;
//        private String channels;
//        private String view;
//        private String date;
//
//
//        public Home(int img, int logo, String titles, int menu, String channels, String view, String date) {
//            this.img = img;
//            this.logo = logo;
//            this.titles = titles;
//            this.channels = channels;
//            this.view = view;
//            this.date = date;
//            this.menu = menu;
//        }
//
//        public int getMenu() {
//            return menu;
//        }
//
//        public void setMenu(int menu) {
//            this.menu = menu;
//        }
//
//        public int getImg() {
//            return img;
//        }
//
//        public void setImg(int img) {
//            this.img = img;
//        }
//
//        public int getLogo() {
//            return logo;
//        }
//
//        public void setLogo(int logo) {
//            this.logo = logo;
//        }
//
//        public String getTitles() {
//            return titles;
//        }
//
//        public void setTitles(String titles) {
//            this.titles = titles;
//        }
//
//        public String getChannels() {
//            return channels;
//        }
//
//        public void setChannels(String channels) {
//            this.channels = channels;
//        }
//
//        public String getView() {
//            return view;
//        }
//
//        public void setView(String view) {
//            this.view = view;
//        }
//
//        public String getDate() {
//            return date;
//        }
//
//        public void setDate(String date) {
//            this.date = date;
//        }
//    }
//
//}



    public static String Key = "AIzaSyCHrmRJcOBNmTnFdiXV606jrN2TJYRTs6Y";
    String ID_listnhac = "PLiaWrX4zmrTlCFT21Rw-XKiZDdOf0slmE";
    String urljson = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="+ ID_listnhac +"&key="+ Key +"&maxResults=50";
    ListView lv_danhsachnhac;
    ArrayList<ListNhac> arrayListnhac;
    ListNhacAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        arrayListnhac = new ArrayList<>();
        adapter= new ListNhacAdapter(getContext(),R.layout.dong_list_nhac, arrayListnhac);

        lv_danhsachnhac= view.findViewById(R.id.lv_danhsachnhac);
        lv_danhsachnhac.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                showConfirmDelete();
                return false;
            }


        });

        lv_danhsachnhac.setAdapter(adapter);
        lv_danhsachnhac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

