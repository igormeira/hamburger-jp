package com.meira.igor.hamburgerjp.hamburguerias;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.meira.igor.hamburgerjp.R;

import java.io.File;
import java.util.Locale;

public class BangBangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_bang);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Intent intentCall = new Intent(Intent.ACTION_CALL);
        intentCall.setData(Uri.parse("tel:35086008"));
        FloatingActionButton fab_call = (FloatingActionButton) findViewById(R.id.fab_call_bangbang);
        fab_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ligação realizada sem DDD.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(intentCall);
            }
        });

        FloatingActionButton fab_menu = (FloatingActionButton) findViewById(R.id.fab_menu_bangbang);
        fab_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File("res/raw/bangbangmenu.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.fromFile(file), "application/pdf");
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", -7.098211, -34.842094);
        final Intent intentMap = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        FloatingActionButton fab_map = (FloatingActionButton) findViewById(R.id.fab_map_bangbang);
        fab_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentMap);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
