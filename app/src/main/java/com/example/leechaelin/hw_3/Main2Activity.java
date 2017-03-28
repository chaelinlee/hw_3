package com.example.leechaelin.hw_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TabHost th;
    EditText e1,e2,e3;
    TextView t1,t2;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("각종 계산기");

        th=(TabHost)findViewById(R.id.tabhost);
        e1 = (EditText)findViewById(R.id.edittext);
        e2 = (EditText)findViewById(R.id.edittext2);
        e3 = (EditText)findViewById(R.id.edittext3);

        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);

        th.setup();

        TabHost.TabSpec tab1 =th.newTabSpec("A").setIndicator("BMI 계산기 ").setContent(new TabHost.TabContentFactory(){
            public View createTabContent(String tag){
                View v = View.inflate(Main2Activity.this,R.layout.activity_bmi,null);
                return v;
            }
        });
        th.addTab(tab1);

        TabHost.TabSpec tab2 = th.newTabSpec("B").setIndicator("면적 계산기").setContent(new TabHost.TabContentFactory(){

            public View createTabContent(String tag){
                View view = View.inflate(Main2Activity.this,R.layout.activity_area,null);
                return view;
            }
        });
        th.addTab(tab2);
    }

    void myClick(View v){
        if(v.getId()==R.id.button){
            health();
            Log.d("bmi","첫번쨰 버튼 눌렀음 ");
        }else if(v.getId()==R.id.button2){
            area();
        }else if(v.getId()==R.id.button3){
            area2();
        }

    }

    void health(){
        String h = e1.getText().toString();
        String w = e2.getText().toString();

        if(h.equals("")|| w.equals("")){
            //e3.setText(String.format(String.valueOf("키와 몸무게를 입력하세요. ")));
            t1.setText(String.format(String.valueOf("키와 몸무게를 입력하세요. ")));
        }else{
            Double height = (Double)((Integer.parseInt(h))/100.0);
            Double ans = Double.parseDouble(w)/(height*height);

            Log.d("bmi","height"+height);
            Log.d("bmi","ans"+ans);

            if(ans<18.5){
              //  e3.setText(String.format(String.valueOf("체중부족")));
                t1.setText(String.format(String.valueOf("체중부족")));
            }else if(ans>=18.5 && ans<22.9){
                //e3.setText(String.format(String.valueOf("정상 ")));
                t1.setText(String.format(String.valueOf("정상 ")));
            }else if(ans>=22.9 && ans<24.9){
                //e3.setText(String.format(String.valueOf("과체중 ")));
                t1.setText(String.format(String.valueOf("과체중 ")));

            }else if(ans>=24.9){
                //e3.setText(String.format(String.valueOf("비만입니다. ")));
                t1.setText(String.format(String.valueOf("비만입니다 .")));
            }
        }
    }

    void area(){
        String a = e3.getText().toString();
        if(a.equals("")){
            //e5.setText(String.format(String.valueOf("값을 입력하세요.")));
            t2.setText(String.format(String.valueOf("값을 입력하세요.")));
        }else{
            Double area1 = Double.parseDouble(a)*3.305785;
            //e5.setText(String.format(String.valueOf(area1)+"제곱미터 "));
            t2.setText(String.format(String.valueOf(area1)+"제곱미터 "));
        }
    }
    void area2(){
        String a = e3.getText().toString();
        if(a.equals("")){
            //e5.setText(String.format(String.valueOf("값을 입력하세요.")));
            t2.setText(String.format(String.valueOf("값을 입력하세요 ")));
        }else{
            Double area1 = Double.parseDouble(a)/3.305785;
            //e5.setText(String.format(String.valueOf(area1)+"평  "));
            t2.setText(String.format(String.valueOf(area1)+"평  "));
        }
    }

}
