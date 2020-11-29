package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class LibraryFragment extends Fragment {

    FragmentManager fragmentManager;
    Library[] lst = new Library[]{
            new Library(R.drawable.history,"Lịch sử",""),
            new Library(R.drawable.download,"Video tải xuống","20 đề xuất"),
            new Library(R.drawable.yours,"Video của bạn",""),
            new Library(R.drawable.clock,"Xem sau",""),

    };

    ListView lv_library;
    public LibraryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_library, container, false);
        lv_library =view.findViewById(R.id.lv_library);
        BusinessAdapter adapter= new BusinessAdapter(getActivity().getApplication(),lst);
        lv_library.setAdapter(adapter);

        fragmentManager =  this.getFragmentManager();
        lv_library.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                HistoryFragment historyFragment = new HistoryFragment();
                FragmentTransaction  fragmentTransaction = fragmentManager.beginTransaction();
                        //findFragmentById(R.id.fragment_main);

                fragmentTransaction.replace(R.id.fragment_main,historyFragment);
                fragmentTransaction.commit();
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