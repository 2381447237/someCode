package com.youli.testrecyclerview;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView rv;
    private MyRecyclerViewAdapter adapter;
    private List<String> data=new ArrayList<String>();
    private List<View> vpData=new ArrayList<>();
    private String colors[]={"#ff0000","#00ff00","#0000ff"};
   // private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ll= (LinearLayout) findViewById(R.id.item_ll);

        rv= (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        for(int i=1;i<50;i++){
            data.add(i+"");
        }

        for(int i=0;i<colors.length;i++){

            ImageView iv=new ImageView(this);

            iv.setBackgroundColor(Color.parseColor(colors[i]));

            vpData.add(iv);

//            ImageView point=new ImageView(this);
//
//            point.setImageResource(R.drawable.shape_point_unselected);
//
//            ll.addView(point);
        }


        adapter=new MyRecyclerViewAdapter(data,this,vpData);
        rv.setAdapter(adapter);
    }
}
