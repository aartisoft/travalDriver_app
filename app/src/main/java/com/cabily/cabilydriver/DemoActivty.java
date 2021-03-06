package com.cabily.cabilydriver;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import com.cabily.cabilydriver.Pojo.UserPojo;
import com.cabily.cabilydriver.Utils.HorizontalListView;
import com.cabily.cabilydriver.adapter.UserListAdapter;

import java.util.ArrayList;

/**
 * Created by user88 on 7/5/2017.
 */

public class DemoActivty extends Activity {

    private HorizontalListView listview;
    UserListAdapter adapter;
    ArrayList<UserPojo> user_list;
    UserPojo pojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        setContentView(R.layout.trip_layout_final);
        listview = (HorizontalListView) findViewById(R.id.user_listview);
        user_list = new ArrayList<UserPojo>();
        pojo=new UserPojo();

        user_list.add(pojo);
        adapter = new UserListAdapter(this, user_list);
        listview.setAdapter(adapter);


    }
}
