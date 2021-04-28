package org.techtown.cv;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Contact extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        Intent intent = new Intent(Intent.ACTION_VIEW);

        Button buttonEMAIL= (Button) findViewById(R.id.button1);
        buttonEMAIL.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setData(Uri.parse("https://www.naver.com/"));
                startActivity(intent);
            }
        }) ;

        Button buttonPHONE= (Button) findViewById(R.id.button);
        buttonPHONE.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tt = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01050239977"));
                startActivity(tt);
            }
        }) ;

        Button buttonGITHUB= (Button) findViewById(R.id.button2);
        buttonGITHUB.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setData(Uri.parse("https://github.com/minseojo"));
                startActivity(intent);
            }
        }) ;

        Button buttonBLOG= (Button) findViewById(R.id.button3);
        buttonBLOG.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setData(Uri.parse("https://jominseo.tistory.com"));
                startActivity(intent);
            }
        }) ;
    }
}