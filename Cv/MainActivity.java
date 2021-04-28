package org.techtown.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonGOLAS = (Button) findViewById(R.id.button1);
        buttonGOLAS.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Goals.class);
                startActivity(intent);
            }
        }) ;

        Button buttonCONTACT = (Button) findViewById(R.id.button2);
        buttonCONTACT.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Contact.class);
                startActivity(intent);
            }
        }) ;

        Button buttonSKILL = (Button) findViewById(R.id.button3);
        buttonSKILL.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Skills.class);
                startActivity(intent);
            }
        }) ;

        Button buttonPERSONALSKILL = (Button) findViewById(R.id.button4);
        buttonPERSONALSKILL.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PersonalSkill.class);
                startActivity(intent);
            }
        }) ;

        Button buttonEDUCATION = (Button) findViewById(R.id.button5);
        buttonEDUCATION.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Education.class);
                startActivity(intent);
            }
        }) ;

        Button buttonPROJECT = (Button) findViewById(R.id.button6);
        buttonPROJECT.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Project.class);
                startActivity(intent);
            }
        }) ;
    }


}