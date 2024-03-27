package kiwu.android.studentmgmt.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;

import kiwu.android.studentmgmt.CreateFragment;
import kiwu.android.studentmgmt.ListFragment;
import kiwu.android.studentmgmt.R;
import kiwu.android.studentmgmt.controller.StudentFileController;

public class MainActivity extends AppCompatActivity {
    private ListFragment lFragment;
    private CreateFragment cFragment;

    BottomNavigationView bNavigation;
    StudentFileController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test22

        lFragment = new ListFragment();
        cFragment = new CreateFragment();

        bNavigation = findViewById(R.id.btmNavigation);
        bNavigation.setOnNavigationItemSelectedListener(new BottomNavigationItemSelectedListener());

        try {
            controller = new StudentFileController(getApplicationContext().getFilesDir().getPath());
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        changeFragment(LIST_FRAGMENT);

    }

    private class BottomNavigationItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int selectedItemId = item.getItemId();

            if(selectedItemId == R.id.btm_navi_item_list) {
                changeFragment(LIST_FRAGMENT);
            } else if(selectedItemId == R.id.btm_navi_item_create) {
                changeFragment(CREATE_FRAGMENT);
            }

            return true;
        }
    }

    public static final int LIST_FRAGMENT = 0;
    public static final int CREATE_FRAGMENT = 1;

    public void changeFragment(int fragmentNum) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch(fragmentNum) {
            case LIST_FRAGMENT:
                ft = ft.replace(R.id.frmMain, lFragment);
                ft.commitNow();
                break;
            case CREATE_FRAGMENT:
                ft = ft.replace(R.id.frmMain, cFragment);
                ft.commitNow();
                break;
        }

    }

}