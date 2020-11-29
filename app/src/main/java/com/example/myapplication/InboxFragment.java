package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class InboxFragment extends Fragment {
    Inbox[] lst = new Inbox[]{
            new Inbox(R.drawable.photochudangphu,"Chu Đặng Phú đang phát trực tiếp: Q & A 28-7-2020",R.drawable.qa,R.drawable.menu),
            new Inbox(R.drawable.youtube_96in128dp," Ai đó đã thích bình luận của bạn: \"A tin ơii. Xe đii hay gặp mưa có cần tra thêm dầu bôi trơn vào xích tải của xe ko a\"",R.drawable.hqdefault,R.drawable.menu),
            new Inbox(R.drawable.dungkn,"Đề xuất: Công Phượng ghẹo con gái Sầm Ngọc Đức, Tiến Dũng ôm Thanh Thắng cười tươi với NHM sau trận đấu",R.drawable.chudangphu,R.drawable.menu),
            new Inbox(R.drawable.dungkn,"Đề xuất: CÔNG PHƯỢNG và PHI SƠN từng khiến hàng thủ của Hàn Quốc khổ sở như thế này?",R.drawable.congphuong,R.drawable.menu),
            new Inbox(R.drawable.xehay,"XE HAY đang phát trực tiếp: Ra mắt xe MG giá từ hơn 500 Triệu",R.drawable.toyota,R.drawable.menu),
            new Inbox(R.drawable.photoepl,"Premier League đang phát trực tiếp: LIVE: State of Play: Midfielders | The FPL Show | Gameweek 34+",R.drawable.hqdefault_live,R.drawable.menu),
            new Inbox(R.drawable.photoepl,"XPremier League đang phát trực tiếp: LIVE: State of Play: Defenders | The FPL Show | Gameweek 33+",R.drawable.priemierleague,R.drawable.menu),
            new Inbox(R.drawable.photochudangphu,"Chu Đặng Phú đang phát trực tiếp: Q&A 1/7/2020",R.drawable.sticker,R.drawable.menu),
    };
    ActionBar actionBar;
    ListView lv_inbox;


    public InboxFragment() {
        // Required empty publ ic constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inbox, container, false);
        lv_inbox=view.findViewById(R.id.lv_inbox);

        InboxAdapter adapter = new InboxAdapter(getActivity().getApplication(),lst);
        lv_inbox.setAdapter(adapter);



        return  view;
    }
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        img_thongbao.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PopupMenu popupMenu= new PopupMenu(getContext(),img_thongbao);
//                popupMenu.getMenuInflater().inflate(R.menu.popup_thongbao,popupMenu.getMenu());
//
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        Toast.makeText(getContext(),menuItem.getTitle()+"",Toast.LENGTH_SHORT).show();
//                        return false;
//                    }
//                });
//                popupMenu.show();
//            }
//        });
//
//    }

    class InboxAdapter extends BaseAdapter {

        private Inbox[] items;
        private LayoutInflater layoutInflater;

        public InboxAdapter(Context ctx, Inbox[] items) {
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
            view = layoutInflater.inflate(R.layout.inbox_items, null);
            ImageView img = view.findViewById(R.id.img_title);
            ImageView menu = view.findViewById(R.id.img_title2);
            TextView tv_titles = view.findViewById(R.id.txt_message);

            final ImageView thongbao=view.findViewById(R.id.img_thongbao);

            img.setImageResource(items[i].getImg());
            tv_titles.setText(items[i].getTitles());
            menu.setImageResource(items[i].getMenu());

            thongbao.setImageResource(items[i].getThongbao());
            thongbao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu= new PopupMenu(getContext(), thongbao);
                    popupMenu.getMenuInflater().inflate(R.menu.popup_thongbao,popupMenu.getMenu());
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
    }

    class Inbox {
        private int img;

        private String titles;
        private int menu;
        private  int thongbao;

        public int getThongbao() {
            return thongbao;
        }

        public void setThongbao(int thongbao) {
            this.thongbao = thongbao;
        }

        public Inbox(int img, String titles, int menu, int thongbao) {
            this.img = img;
            this.titles = titles;
            this.menu = menu;
            this.thongbao = thongbao;
        }

        public int getImg() {
            return img;
        }

        public void setImg(int img) {
            this.img = img;
        }

        public String getTitles() {
            return titles;
        }

        public void setTitles(String titles) {
            this.titles = titles;
        }

        public int getMenu() {
            return menu;
        }

        public void setMenu(int menu) {
            this.menu = menu;
        }
    }

}
