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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class LibraryListFragment extends Fragment {

  Library[] lst = new Library[]{
          new Library(R.drawable.like,"Video đã thích","166 video"),
          new Library(R.drawable.pc,"Like","3 video"),
          new Library(R.drawable.aiocooler,"Dev","2 video"),


  };

    ListView lv_list;
    public LibraryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_library_list, container, false);
        lv_list =view.findViewById(R.id.lv_list);

        final Button btn = view.findViewById(R.id.add);
        BusinessAdapter adapter= new BusinessAdapter(getActivity().getApplication(),lst);
        lv_list.setAdapter(adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu= new PopupMenu(getContext(), btn);
                popupMenu.getMenuInflater().inflate(R.menu.popup_add,popupMenu.getMenu());
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

    private void nextActivity(){
        HistoryFragment historyFragment = new HistoryFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.recyclerView,historyFragment);
        fragmentTransaction.commit();
    }

    class BusinessAdapter extends BaseAdapter {

        private Library[] items;
        private LayoutInflater layoutInflater;

        public BusinessAdapter(Context ctx, Library[] items ){
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
            view = layoutInflater.inflate(R.layout.library_items,null);
            ImageView img = view.findViewById(R.id.img);
            TextView tv_content = view.findViewById(R.id.tv_content);
            TextView tv_sug = view.findViewById(R.id.tv_sug);


            img.setImageResource(items[i].getImage());
            tv_content.setText(items[i].getContent());
            tv_sug.setText(items[i].getSug());


            return view;
        }
    }

    class Library {
        private int image;
        private String content;
        private String sug;

        public Library(int image, String content, String sug) {
            this.image = image;
            this.content = content;
            this.sug = sug;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSug() {
            return sug;
        }

        public void setSug(String sug) {
            this.sug = sug;
        }
    }

}