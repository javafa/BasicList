package com.baekcedar.android.basiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerData data;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        ArrayList<RecyclerData> datas = new ArrayList<>();
        for( int i = 1 ; i <= 100 ; i ++ ) {
            data = new RecyclerData();

            data.title = i+" "+"기억상실";
            data.name = "거미";
            data.image = R.mipmap.gummi;

            datas.add(data);
        }

        recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        RecyclerAdapter adapter = new RecyclerAdapter(datas,R.layout.recycler_item);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
