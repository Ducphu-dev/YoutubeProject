package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;

import com.squareup.picasso.Picasso;



import java.util.List;

public class ListNhacAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<ListNhac> nhacList;

    public ListNhacAdapter(Context context, int layout, List<ListNhac> nhacList) {
        this.context = context;
        this.layout = layout;
        this.nhacList = nhacList;
    }

    @Override
    public int getCount() {
        return nhacList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        ImageView imghinh;
        TextView tv_tenbaihat;
        ImageView img_menu;


    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.imghinh = view.findViewById(R.id.imghinh);
            holder.tv_tenbaihat = view.findViewById(R.id.tv_tenbaihat);
            holder.img_menu = view.findViewById(R.id.img_menu);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        ListNhac listNhac = nhacList.get(i);
        holder.tv_tenbaihat.setText(listNhac.getTen());
        holder.img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu= new PopupMenu(context, holder.img_menu);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                       Toast.makeText(context,menuItem.getTitle()+"",Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        Picasso.with(context).load(listNhac.getHinh()).into(holder.imghinh);

        return view;
    }
//    private void showMenu(){
////        Log.d("showMenu", "This is processing Menu");
//        AlertDialog.Builder builder= new AlertDialog.Builder(context);
//
//        builder.setMessage("do you want to delete this item");
//
////        Toast.makeText( context,builder+" ",Toast.LENGTH_SHORT);
//
//
//
//
//
//        Dialog dl = builder.create();
//        dl.show();
//    }
}
