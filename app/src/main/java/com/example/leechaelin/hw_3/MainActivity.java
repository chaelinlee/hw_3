package com.example.leechaelin.hw_3;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    ImageView i,i2;
    LinearLayout l;
    int degree = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView)findViewById(R.id.text);
        i = (ImageView)findViewById(R.id.image);
        i2 = (ImageView)findViewById(R.id.image2);
        l = (LinearLayout)findViewById(R.id.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
                case R.id.red:
                    l.setBackgroundColor(Color.RED);
                    break;
                case R.id.blue:
                    l.setBackgroundColor(Color.BLUE);
                    break;
                case R.id.yellow:
                    l.setBackgroundColor(Color.YELLOW);
                    break;
                case R.id.chicken:
                    i.setImageResource(R.drawable.chicken);
                    i2.setVisibility(View.INVISIBLE);
                    item.setChecked(true);
                    break;
                case R.id.spagetti:
                    i.setVisibility(View.INVISIBLE);
                    i2.setImageResource(R.drawable.spa);
                    item.setChecked(true);
                    break;
                case R.id.showtitle:
                    if(item.isChecked()){
                        t1.setVisibility(View.INVISIBLE);
                        item.setChecked(false);
                    } else if(item.isChecked()==false){
                        t1.setVisibility(View.VISIBLE);
                        if(i.getVisibility()==View.INVISIBLE){
                            t1.setText(String.format(String.valueOf("새콤한 스파게티 ")));
                        }else if(i2.getVisibility()==View.INVISIBLE){
                            t1.setText(String.format(String.valueOf("맛있는 치")));
                        }
                        item.setChecked(true);
                    }
                    break;
                case R.id.zoom:
                    if(item.isChecked()){
                        i.setScaleX(1);
                        i.setScaleY(1);
                        item.setChecked(false);
                        break;
                    }
                    else if(item.isChecked()==false){
                        i.setScaleX(2);
                        i.setScaleY(2);
                        item.setChecked(true);
                        break;
                    }

                 case R.id.move:
                     i.setRotation(degree+30);
                     break;

        }
        return super.onOptionsItemSelected(item);
    }



}