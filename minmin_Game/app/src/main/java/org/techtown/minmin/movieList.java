package org.techtown.minmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class movieList extends AppCompatActivity {

    Button allBack;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movielist);

        allBack = (Button) findViewById(R.id.movieAllBack);
        allBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.movie);
                movieVar.movieCurrentPage=1;
                for(int i=0; i<6; i++) {
                    movieVar.movieList[i]=0;
                    movieVar.moviePreList[movieVar.movieCurrentPage][i]=0;
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}