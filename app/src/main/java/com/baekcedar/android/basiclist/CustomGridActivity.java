package com.baekcedar.android.basiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class CustomGridActivity extends AppCompatActivity {


    ArrayList<GridItem> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid);

        for(int i =0 ; i < 100000 ; i ++){
            GridItem item = new GridItem();
            item.title = "BANG!";
            item.num = i;
            datas.add(item);
        }

        GridView gridView = (GridView) findViewById(R.id.gridView2);

        CustomGridAdapter cga = new CustomGridAdapter(
                this, datas, R.layout.activity_custom_grid_item);

        gridView.setAdapter(cga);
    }
}
class GridItem{
    String title;
    int    num;
}