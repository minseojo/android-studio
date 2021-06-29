package org.techtown.minmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnGame = (ImageButton) findViewById(R.id.imageButton);
        btnGame.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), game.class);
                startActivity(intent);
            }
        });

        ImageButton btnMovie = (ImageButton) findViewById(R.id.imageButton2);
        btnMovie.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), movie.class);
                startActivity(intent);
            }
        });
    }
}