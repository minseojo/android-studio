package org.techtown.minmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class gameList extends AppCompatActivity {

    Button allBack;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelist);

        allBack = (Button) findViewById(R.id.gameAllBack);
        allBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.game);
                gameVar.gameCurrentPage=1;
                for(int i=0; i<5; i++) {
                    gameVar.gameList[i]=0;
                    gameVar.gamePreList[gameVar.gameCurrentPage][i]=0;
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
