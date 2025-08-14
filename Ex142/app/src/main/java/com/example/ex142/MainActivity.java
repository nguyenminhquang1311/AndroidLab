package com.example.ex142;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ex142.myarrayAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity {

    EditText edit1;
    ListView lv1, lv2, lv3;
    TabHost tab;
    ArrayList<Item> list1, list2, list3;
    myarrayAdapter myarray1, myarray2, myarray3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        tab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equalsIgnoreCase("t1")) {
                    list1.clear();
                    list1.add(new Item("52208", "Em là ai Tôi là ai", 0));
                    list1.add(new Item("55209", "Chênh Bênh", 1));
                    myarray1.notifyDataSetChanged();
                }

                if (tabId.equalsIgnoreCase("t2")) {
                    list2.clear();
                    list2.add(new Item("57326", "Gửi em ở cuối sông hồng", 0));
                    list2.add(new Item("51543", "Say tình", 0));
                    myarray2.notifyDataSetChanged();
                }

                if (tabId.equalsIgnoreCase("t3")) {
                    list3.clear();
                    list3.add(new Item("57608", "Hát với dòng sông", 1));
                    list3.add(new Item("58715", "Say tình - Remix", 0));
                    myarray3.notifyDataSetChanged();
                }
            }
        });
    }

    private void addControl() {
        tab = (TabHost) findViewById(android.R.id.tabhost);
        tab.setup();

        TabHost.TabSpec tab1 = tab.newTabSpec("t1");
        tab1.setIndicator("T1", getResources().getDrawable(R.drawable.search));
        tab1.setContent(R.id.tab1);

        TabHost.TabSpec tab2 = tab.newTabSpec("t2");
        tab2.setIndicator("T2", getResources().getDrawable(R.drawable.list));
        tab2.setContent(R.id.tab2);

        TabHost.TabSpec tab3 = tab.newTabSpec("t3");
        tab3.setIndicator("T3", getResources().getDrawable(R.drawable.favourite));
        tab3.setContent(R.id.tab3);

        tab.addTab(tab1);
        tab.addTab(tab2);
        tab.addTab(tab3);

        edit1 = (EditText) findViewById(R.id.edtSearch);
        lv1 = (ListView) findViewById(R.id.listView1);
        lv2 = (ListView) findViewById(R.id.listView2);
        lv3 = (ListView) findViewById(R.id.listView3);

        list1 = new ArrayList<Item>();
        list2 = new ArrayList<Item>();
        list3 = new ArrayList<Item>();

        myarray1 = new myarrayAdapter(MainActivity.this, R.layout.list_item, list1);
        myarray2 = new myarrayAdapter(MainActivity.this, R.layout.list_item, list2);
        myarray3 = new myarrayAdapter(MainActivity.this, R.layout.list_item, list3);

        lv1.setAdapter(myarray1);
        lv2.setAdapter(myarray2);
        lv3.setAdapter(myarray3);
    }
}