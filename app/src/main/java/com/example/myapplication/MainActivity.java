package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.business_menu,menu);

        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getGroupId();
        switch (id){
            case R.id.menu_subribe:
                //codde here
                Toast.makeText(MainActivity.this,"Kênh đăng kí", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_email:
                Toast.makeText(MainActivity.this,"Hộp thư đến", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_library:
                Toast.makeText(MainActivity.this,"Thư viện", Toast.LENGTH_LONG).show();
                break;
        }
        return  super.onOptionsItemSelected(item);
    }
}

