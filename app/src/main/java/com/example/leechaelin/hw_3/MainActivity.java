package com.example.leechaelin.hw_3;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    ImageView i,i2;
    LinearLayout l,l2;
    FrameLayout f;
    int degree = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = (LinearLayout)findViewById(R.id.linear);
        l2 = (LinearLayout)findViewById(R.id.linear2);
        f = (FrameLayout)findViewById(R.id.frame);
        t1 = (TextView)findViewById(R.id.text);
        t2 = (TextView)findViewById(R.id.text2);
        i = (ImageView)findViewById(R.id.image);
        i2 = (ImageView)findViewById(R.id.image2);
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
                    f.setBackgroundColor(Color.RED);
                    break;
                case R.id.blue:
                    f.setBackgroundColor(Color.BLUE);
                    break;
                case R.id.yellow:
                    f.setBackgroundColor(Color.YELLOW);
                    break;

                case R.id.chicken:
                    l2.setVisibility(View.INVISIBLE);
                    i.setImageResource(R.drawable.chicken);
                    l.setVisibility(View.VISIBLE);
                    item.setChecked(true);
                    break;
                case R.id.spagetti:
                    l.setVisibility(View.INVISIBLE);
                    i2.setImageResource(R.drawable.spa);
                    l2.setVisibility(View.VISIBLE);
                    item.setChecked(true);
                    break;

                case R.id.showtitle:
                    if(item.isChecked()){
                        t1.setVisibility(View.INVISIBLE);
                        t2.setVisibility(View.INVISIBLE);
                        item.setChecked(false);
                    }else if(item.isChecked()==false){
                        if(l.getVisibility()==View.VISIBLE){
                            t1.setText(String.format(String.valueOf("맛있는 치킨 ")));
                            t1.setVisibility(View.VISIBLE);
                            item.setChecked(true);
                        }else if(l2.getVisibility()==View.VISIBLE){
                            t2.setText(String.format(String.valueOf("상큼한 스파게티 ")));
                            t2.setVisibility(View.VISIBLE);
                        }
                        item.setChecked(true);
                    }

                    break;
                case R.id.zoom:
                    if(item.isChecked()){
                        if(l.getVisibility()==View.VISIBLE){
                            i.setScaleX(1);
                            i.setScaleY(1);
                        }else if(l2.getVisibility()==View.VISIBLE){
                            i2.setScaleX(1);
                            i2.setScaleY(1);
                        }
                        item.setChecked(false);

                    }
                    else if(item.isChecked()==false){
                        if(l.getVisibility()==View.VISIBLE){
                            i.setScaleX(2);
                            i.setScaleY(2);
                        }else if(l2.getVisibility()==View.VISIBLE){
                            i2.setScaleX(2);
                            i2.setScaleY(2);
                        }
                        item.setChecked(true);

                    }
                    break;

                 case R.id.move:
                     if(l.getVisibility()==View.VISIBLE){
                         i.setRotation(degree+30);
                     }
                     else if(l2.getVisibility()==View.VISIBLE){
                         i2.setRotation(degree+30);
                     }
                     break;

        }
        return super.onOptionsItemSelected(item);
    }



}