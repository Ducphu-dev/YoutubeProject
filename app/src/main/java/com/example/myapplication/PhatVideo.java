package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
public class PhatVideo extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {

    String id="";
    String name="";
    protected void onCreate(Bundle savedInstanceState){

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_phat_video);
    loadFragment();
}
    private void loadFragment(){
    Bundle bundle= new Bundle();
    Intent intent= getIntent();
    if (intent != null){
      id=  intent.getStringExtra("IDVideoYT");
        name=  intent.getStringExtra("NameYT");

        bundle.putString("IDVideoYT",id);
bundle.putString("NameYT",name);
    }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        TopFragment top = new TopFragment();

        top.setArguments(bundle);
        fragmentTransaction.replace(R.id.frameLayout_top,top);

        BottomFragment bottom = new BottomFragment();
        fragmentTransaction.replace(R.id.frameLayout_bootom,bottom);

        YouTubePlayerFragment  youtubeplayer_fragment =
                (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtubeplayer_fragment);
        youtubeplayer_fragment.initialize(SubribeFragment.Key, this);

        fragmentTransaction.commit();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        Log.d("youtube", id);
        youTubePlayer.loadVideo(id);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,0);
        }else {
            Toast.makeText(this, "Loi!!!!", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.business_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

}