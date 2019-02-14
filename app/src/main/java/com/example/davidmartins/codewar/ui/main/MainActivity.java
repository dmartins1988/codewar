package com.example.davidmartins.codewar.ui.main;

import com.example.davidmartins.codewar.R;
import com.example.davidmartins.codewar.base.BaseActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, new UserFragment()).commit();
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_main;
    }
}
