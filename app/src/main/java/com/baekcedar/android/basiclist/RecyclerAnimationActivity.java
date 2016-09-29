package com.baekcedar.android.basiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAnimationActivity extends AppCompatActivity {

    public static ArrayList<RecyclerData> datas = null;

    // 1. 리사이클러뷰를 현재액티비티의 메인레이아웃에 만든다
    // *-- 들어갈 데이터는 정의되어 있고
    // 2. 정의된 데이터에 맞춰서 리사이클러뷰에 들어갈 아이템레이아웃을 만든다
    // 3. Adapter를 만든다
    //   3.1 레이아웃에 맞춰서 ViewHolder를 먼저 만든다
    // 4. 리사이클러뷰에 아답터를 세팅한다
    // 5. 리사이클러뷰에 레이아웃매니저를 지정한다

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_animation);

        datas = new ArrayList<>();

        for( int i = 1 ; i <= 100 ; i ++ ) {
            RecyclerData data = new RecyclerData();
            data.title = i+" "+"기억상실";
            data.name = "거미";
            data.image = R.mipmap.gummi;
            datas.add(data);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        RecyclerAnimationAdapter adapter = new RecyclerAnimationAdapter(datas, R.layout.recycler_item, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
