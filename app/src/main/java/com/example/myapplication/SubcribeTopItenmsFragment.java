package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class SubcribeTopItenmsFragment extends Fragment {

    FragmentManager fragmentManager;
    Subcribe[] lst = new Subcribe[]{
            new Subcribe(R.drawable.cris,"CrisDevilGamer"),
            new Subcribe(R.drawable.vatvo,"VatvoStudio"),
            new Subcribe(R.drawable.vfact,"Vfact"),
            new Subcribe(R.drawable.unboxtheraphy,"Unboxtheraphy"),
            new Subcribe(R.drawable.techsoruce,"Techsource"),
            new Subcribe(R.drawable.linus,"LinusTechTips"),
            new Subcribe(R.drawable.phu,"Chu Đặng Phú"),
            new Subcribe(R.drawable.sontung,"Sơn Tùng MT-P"),

    };
    RecyclerView recyclerView;
    SubcribeTopItemsAdapter adapter;
    public SubcribeTopItenmsFragment() {
        // Required empty publ ic constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subcribe_top_itenms, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
//        Button all =  view.findViewById(R.id.btn_all);
        recyclerView.setHasFixedSize(true);
        adapter = new SubcribeTopItemsAdapter(view.getContext(),lst);
        recyclerView.setAdapter(adapter);

//        fragmentManager =  this.getFragmentManager();
//        all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//                FragmentTransaction  fragmentTransaction = fragmentManager.beginTransaction();
//                //findFragmentById(R.id.fragment_main);
//
//                fragmentTransaction.replace(R.id.fragment_main,new SubcribeChannelFragment());
//                fragmentTransaction.commit();
//            }
//        });

//        all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SubcribeChannelFragment subcribeChannelFragment = new SubcribeChannelFragment();
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.sub_frag,subcribeChannelFragment);
//                fragmentTransaction.commit();
//            }
//        });
        return view;
    }

    class SubcribeTopItemsViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView tv_content;

        public SubcribeTopItemsViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            tv_content = itemView.findViewById(R.id.tv_tenbaihat);

        }


    }

    class SubcribeTopItemsAdapter extends RecyclerView.Adapter<SubcribeTopItemsViewHolder> {

        private Context context;
        private Subcribe[] items;

        public SubcribeTopItemsAdapter(Context context, Subcribe[] items) {
            this.items = lst;
            this.context = context;
        }

        @NonNull
        @Override
        public SubcribeTopItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.subcribe_top_list,parent,false);
            SubcribeTopItemsViewHolder viewHolder = new SubcribeTopItemsViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull SubcribeTopItemsViewHolder holder, int i) {
            holder.imageView.setImageResource(items[i].getImg());
            holder.tv_content.setText(items[i].getName());
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


    class Subcribe {
        private int img;
        private String name;


        public Subcribe(int img, String name) {
            this.img = img;
            this.name = name;

        }

        public int getImg() {
            return img;
        }

        public void setImg(int img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setContent(String name) {
            this.name = name;
        }
    }

}