package com.cbitcodeclub.vsnick.cbitcodeclub;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    private Switch notificationsToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        notificationsToggle = (Switch) findViewById(R.id.notifications_toggle);

        final SharedPreferences sharedPreferences = getSharedPreferences("Settings",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        notificationsToggle.setChecked(sharedPreferences.getBoolean("notifications",true));
        notificationsToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putBoolean("notifications",true);
                }
                else{
                    editor.putBoolean("notifications",false);
                }
                editor.commit();
            }
        });
    }

}
