package com.baekcedar.android.basiclist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasicList2Activity extends AppCompatActivity {


    ArrayList<Map<String,String>> datas;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list2);

        listView = (ListView) findViewById(R.id.listView);
        setDatas();


    }
    private void setDatas(){
        datas = new ArrayList<>();
        char asc1=65;
        char asc2=97;
        for(int i =0 ; i < 26; i ++){
            Map<String, String> map = new HashMap();
            map.put("number1",(65+i)+"");
            map.put("number2",(97+i)+"");
            map.put("char1",(char)(asc1+i)+"");
            map.put("char2",(char)(asc2+i)+"");
            datas.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,   // 1. 컨텍스트
                datas,  // 2. 데이터
                R.layout.activity_basic_list2_item,   // 3. 레이아웃.
                                                      // datas에 들어가있는 맵의 key 값들.
                                                      // 커스텀 레이아웃의 view 아이디들
                new String[]{"number1","char1","number2","char2"}, // 4. datas에 들어가는 맵의 key 값들
                new int[]{R.id.text1, R.id.text2, R.id.text3, R.id.text4} // 5. 커스텀 레이아웃의 view 아이디들
        );

        listView.setAdapter(adapter);
    }

}
