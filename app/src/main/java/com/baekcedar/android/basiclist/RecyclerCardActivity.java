package com.baekcedar.android.basiclist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class RecyclerCardActivity extends AppCompatActivity {

    public static ArrayList<RecyclerData> datas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_card);

        datas = new ArrayList<>();

        for( int i = 1 ; i <= 100 ; i ++ ) {
            RecyclerData data = new RecyclerData();
            data.title = i+" "+"기억상실";
            data.name = "거미";
            if(i%3 == 0) {
                data.image = R.mipmap.adele;
            }else{
                data.image = R.mipmap.gummi;
            }
            datas.add(data);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylerCardView);
        RecyclerCardAdapter adapter = new RecyclerCardAdapter(datas, R.layout.activity_recycler_card_item, this);
        recyclerView.setAdapter(adapter);

        // 수직 수평 스크롤이 가능
        //RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        // 그리드 타입
        //RecyclerView.LayoutManager manager = new GridLayoutManager(this, 3);
        // StaggerdGrid 타입
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

    }
}
