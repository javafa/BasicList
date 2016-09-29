package com.baekcedar.android.basiclist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BasicList1Activity extends AppCompatActivity{
    String datas[] = {"Google","Naver","Nate","Facebook","Github","Daum","Bing",
    "Tistory"};

    // 데이터를 담을 객체
    ArrayAdapter<String> adapter;
    // 데이터를 담는 adapter 를 받는 리스트 뷰
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list1);


        adapter = new ArrayAdapter<String>(         // 인자 전달
                this,                               // 컨택스트
                android.R.layout.simple_list_item_multiple_choice,// 아이템 레이아웃
                datas                               // 데이터
        );

        /*
            2. 아이템 레이아웃 종류
            simple_list_item_2              텍스트뷰 두개로 구성
            simple_list_item_checked        끝에 체크박스가 생성
            simple_list_item_single_choice  끝에 라디오버튼 생성
            simple_list_item_multiple_choice 끝에 체크박스가 생성

         */


        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }
}
