package com.baekcedar.android.basiclist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class ExpandableActivity extends AppCompatActivity {
    ExpandData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.expandableListView);

        // 아답터에 넘겨줄 데이터 정의

        ArrayList<ExpandData> datas = new ArrayList<>();

        data = new ExpandData();

        data.cityName = "서울";
        data.guNames.add("강동");
        data.guNames.add("강서");
        data.guNames.add("서초");
        data.guNames.add("마포");
        data.guNames.add("동작");
        datas.add(data);

        data = new ExpandData();

        data.cityName = "광주";
        data.guNames.add("광산");
        data.guNames.add("중구");
        data.guNames.add("북구");
        datas.add(data);

        data = new ExpandData();
        data.cityName = "대전";
        data.guNames.add("유성구");
        data.guNames.add("대덕구");
        data.guNames.add("서구");
        data.guNames.add("중구");
        data.guNames.add("동구");
        datas.add(data);

        ExpandableAdapter ea = new ExpandableAdapter(
                this,
                R.layout.expand_parent_item,
                R.layout.expand_child_item,
                datas);
        listView.setAdapter(ea);


    }
}
