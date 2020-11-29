package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;


public class TopFragment extends Fragment implements YouTubePlayer.OnInitializedListener{

    private YouTubePlayer youTubePlayer;
    private YouTubePlayerFragment youTubePlayerFragment;
    YouTubePlayerView youTubePlayerView;
    String id= "";
    int khoitao;
    String tenvideo;
    TextView tv_tenvideo;
    Button btn_dangky;


    public TopFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        tv_tenvideo= view.findViewById(R.id.tv_tenvideo);
        btn_dangky= view.findViewById(R.id.btn_dangky);

        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu= new PopupMenu(getContext(), btn_dangky);
                popupMenu.getMenuInflater().inflate(R.menu.popup_dangky,popupMenu.getMenu());
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

        Bundle bd= getArguments();
        id = bd.getString("IDVideoYT");
        tenvideo=bd.getString("NameYT");
        tv_tenvideo.setText(tenvideo);
        return view;
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        Log.d("youtube", id);
        youTubePlayer.loadVideo(id);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(getActivity(),khoitao);
        }else {
            Toast.makeText(getContext(), "Loi!!!!", Toast.LENGTH_SHORT).show();
        }
    }





}