package com.sunil.bottomnavigationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    TextFragment fragment;

    @BindView(R.id.navigation_view)
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment();

        navigationView.setOnNavigationItemSelectedListener(this);
    }

    private void initFragment(){

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = new TextFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        @StringRes int text;
        switch (item.getItemId()) {
            case R.id.camera:
                text = R.string.camera;
                break;
            case R.id.dashboard:
                text = R.string.dashboard;
                break;
            case R.id.language:
                text = R.string.language;
                break;
            default:
                return false;
        }
        switchFragmentText(text);
        return true;
    }

    private void switchFragmentText(@StringRes int text) {
        fragment.setText(text);
    }
}
