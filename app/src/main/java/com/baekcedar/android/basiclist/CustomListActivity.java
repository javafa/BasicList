package com.baekcedar.android.basiclist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {

    ListView listView;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        ArrayList<String> datas = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView2);
        for(int i = 0 ; i < 30; i++)
        {
            datas.add("data"+i);
        }

        adapter = new CustomAdapter(this, datas);
        listView.setAdapter(adapter);
    }
}
class CustomAdapter extends BaseAdapter{

    Context context;            // 컨텍스트
    ArrayList datas;            // 데이터 배열
    LayoutInflater inflater;    // xml 파일을 instance 화 해서 메모리에 올려준다.

    CustomAdapter(Context context, ArrayList datas){ //생성자
        this.context = context;
        this.datas = datas;
        //시스템에서 xml을 개체화 시켜주는 인플레이터를 가진다.
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { // 자식 뷰들의 개수를 리턴해준다.
        return datas.size();
    }

    @Override
    public Object getItem(int position) {   // 자식 뷰를 리턴해준다.
        // 자식 뷰의 순서
        // 1부터 시작한다.
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {   // 자식 뷰의 ID 값을 리턴해준다.
        return position;
    }

    @Override //
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("GETVIEW","----------------position"+position);
        Log.i("ViewGroup","----------------parent"+parent.getId());

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.activity_custom_list_item, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textView);

        textView.setText(datas.get(position).toString());

        return convertView;
    }
}