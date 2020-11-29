package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class SubcribeChannelFragment extends Fragment {
    Channel[] lst = new Channel[]{
            new Channel(R.drawable.cris,"CrisDevilGamer",R.drawable.greendot),
            new Channel(R.drawable.linus,"LinusTEchTips",R.drawable.greendot),
            new Channel(R.drawable.techsoruce,"Techsource",R.drawable.greendot),
            new Channel(R.drawable.unboxtheraphy,"Unboxtheraphy",R.drawable.greendot),
            new Channel(R.drawable.phu,"Chu Dang Phu",R.drawable.greendot),
            new Channel(R.drawable.vfact,"Vfact",R.drawable.greendot),
            new Channel(R.drawable.vatvo,"VatvoStudio",R.drawable.greendot),

    };


    ListView lv_channel;
    public SubcribeChannelFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subcribe_channel, container, false);
        lv_channel = view.findViewById(R.id.lv_channel);
        final Button manage = view.findViewById(R.id.manage);
        ChannelAdapter adapter = new ChannelAdapter(getActivity().getApplication(), lst);
        lv_channel.setAdapter(adapter);

        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu= new PopupMenu(getContext(), manage);
                popupMenu.getMenuInflater().inflate(R.menu.popup_channel,popupMenu.getMenu());
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

        return view;

    }



    class ChannelAdapter extends BaseAdapter {

        private Channel[] items;
        private LayoutInflater layoutInflater;

        public ChannelAdapter(Context ctx,  Channel[] items ){
            this.items = items;
            layoutInflater = LayoutInflater.from(ctx);

        }

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int i) {
            return items[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = layoutInflater.inflate(R.layout.subcribe_channel_items,null);
            ImageView img = view.findViewById(R.id.img);
            TextView tv_name = view.findViewById(R.id.tv_name);
            ImageView dot = view.findViewById(R.id.img_dot);


            img.setImageResource(items[i].getImage());
            tv_name.setText(items[i].getName());
            dot.setImageResource(items[i].getDot());


            return view;
        }
    }

    class Channel {
        private int image;
        private String name;
        private int dot;

        public Channel(int image, String name, int dot) {
            this.image = image;
            this.name = name;
            this.dot = dot;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDot() {
            return dot;
        }

        public void setDot(int dot) {
            this.dot = dot;
        }
    }
}