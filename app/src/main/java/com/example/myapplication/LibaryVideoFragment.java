package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class LibaryVideoFragment extends Fragment {

    LibraryVideo[] lst = new LibraryVideo[]{
            new LibraryVideo(R.drawable.pc,"PC budget 500$","Techsource",R.drawable.menu),
            new LibraryVideo(R.drawable.aircooler,"An Corsair AIRCOOLER","Techsource",R.drawable.menu),
            new LibraryVideo(R.drawable.aiocooler,"How to install an AIOCOOLER","LinusTechTips",R.drawable.menu),
            new LibraryVideo(R.drawable.setup,"Set Up War 198","Techsource",R.drawable.menu),

    };
    RecyclerView recyclerView;
    LibraryVideoAdapter adapter;
    public LibaryVideoFragment() {
        // Required empty publ ic constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_libary_video, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new LibraryVideoAdapter(view.getContext(),lst);
        recyclerView.setAdapter(adapter);

        return view;
    }

    class LibraryVideoViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView tv_content;
        public ImageButton imgbtn;
        public LibraryVideoViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            tv_content = itemView.findViewById(R.id.tv_tenbaihat);
            imgbtn = itemView.findViewById(R.id.imgbtn);

            imgbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu= new PopupMenu(getContext(), imgbtn);
                    popupMenu.getMenuInflater().inflate(R.menu.popup_libary,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            Toast.makeText(getContext(),menuItem.getTitle()+"",Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });
        }


    }

    class LibraryVideoAdapter extends RecyclerView.Adapter<LibraryVideoViewHolder> {

        private Context context;
        private LibraryVideo[] items;

        public LibraryVideoAdapter(Context context, LibraryVideo[] items) {
            this.items = lst;
            this.context = context;
        }

        @NonNull
        @Override
        public LibraryVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.libary_video_items,parent,false);
            LibraryVideoViewHolder viewHolder = new LibraryVideoViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull LibraryVideoViewHolder holder, int i) {
            holder.imageView.setImageResource(items[i].getImg());
            holder.tv_content.setText(items[i].getContent());
            holder.imgbtn.setImageResource(items[i].getMenu());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }

        @Override
        public int getItemCount() {
            return items.length;
        }
    }

//    private void displayVideos() {
//
//        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urljson, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray jsonitems = response.getJSONArray("items");
//                    String jsontitle = "";
//                    String jsonurl = "";
//                    String jsonvideoId = "";
//                    for (int i = 0; i < jsonitems.length(); i++) {
//                        JSONObject jsonitem = jsonitems.getJSONObject(i);
//                        JSONObject jsonSnippet = jsonitem.getJSONObject("snippet");
//                        jsontitle = jsonSnippet.getString("title");
//
//                        JSONObject jsonthumbnails = jsonSnippet.getJSONObject("thumbnails");
//                        JSONObject jsonmedium = jsonthumbnails.getJSONObject("medium");
//
//                        jsonurl = jsonmedium.getString("url");
//                        JSONObject jsonresourceId = jsonSnippet.getJSONObject("resourceId");
//                        jsonvideoId = jsonresourceId.getString("videoId");
//                        lst.add(new ListNhac(jsontitle, jsonurl, jsonvideoId));
//
//
//                    }
//                    adapter.notifyDataSetChanged();
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        },
//                new Response.ErrorListener(){
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                }
//        );
//        requestQueue.add(jsonObjectRequest);
//    }
    class LibraryVideo {
    private int img;
    private String content;
    private String channel;
    private int menu;

    public LibraryVideo(int img, String content, String channel, int menu) {
        this.img = img;
        this.content = content;
        this.channel = channel;
        this.menu = menu;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getMenu() {
        return menu;
    }

    public void setMsenu(int menu) {
        this.menu = menu;
    }
    }
}