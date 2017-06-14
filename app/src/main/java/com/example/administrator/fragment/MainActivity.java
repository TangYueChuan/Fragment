package com.example.administrator.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);
        textView = (TextView)findViewById(R.id.text);
    }
    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction =fm.beginTransaction();
        switch (v.getId()){
            case R.id.button2:
                if (firstFragment==null) {
                    firstFragment = new FirstFragment();
                }
                fragmentTransaction.replace(R.id.framelayout,firstFragment);
                break;
            case R.id.button:
                if (secondFragment==null){
                    secondFragment = new SecondFragment();
                }
                fragmentTransaction.replace(R.id.framelayout,secondFragment);
                break;
        }
        textView.setVisibility(View.INVISIBLE);
        fragmentTransaction.commit();
    }
}
