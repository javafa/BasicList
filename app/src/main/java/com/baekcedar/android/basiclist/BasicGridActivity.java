package com.baekcedar.android.basiclist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class BasicGridActivity extends AppCompatActivity {
    String datas[] = {"Google","Naver","Nate","Facebook","Github","Daum","Bing",
            "Tistory"};
    ArrayAdapter<String> adapter;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_grid);

        adapter = new ArrayAdapter<String>(         // 인자 전달
                this,                               // 컨택스트
                android.R.layout.simple_list_item_1,// 아이템 레이아웃
                datas                               // 데이터
        );

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
    }
}
