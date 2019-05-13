package com.eventsReminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView mTextMessage2;
    private TextView mTextMessage3;
    private TextView mTextMessage4;
    private TextView mTextMessage5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // レイアウト読み込み
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.message);
        mTextMessage2 = findViewById(R.id.message2);
        mTextMessage3 = findViewById(R.id.message3);
        mTextMessage4 = findViewById(R.id.message4);
        mTextMessage5 = findViewById(R.id.message5);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // テキストフィールドに値設定
        // TODO: PythonでDB接続・文字列組み立て等
        mTextMessage.setText(R.string.title_home);
        mTextMessage2.setText(R.string.title_list);
        mTextMessage3.setText("test3");
        mTextMessage4.setText("test4");
        mTextMessage5.setText("test5");
        // navigation.setSelectedItemId(R.id.navigation_home);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Intent intent;

            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    mTextMessage.setText(R.string.title_list);
                    return true;
                case R.id.navigation_edit:
                    intent = new Intent(getApplication(), EditActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_list:
                    intent = new Intent(getApplication(), ListActivity.class);
                    startActivity(intent);
                    return true;
//                    mTextMessage.setText(R.string.title_agenda);
//                    return true;
            }
            return false;
        }
    };

}
