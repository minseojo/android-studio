package org.techtown.minmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class gameResult extends AppCompatActivity {
    ImageView[] imageView = new ImageView[4];
    final private int imageId[] = {R.id.gamefalse0, R.id.gamefalse1, R.id.gamefalse2, R.id.gamefalse3};
    final private int rpg[] = {R.drawable.rpg1, R.drawable.rpg2, R.drawable.rpg3, R.drawable.rpg4};
    final private int casual[] = {R.drawable.casual1, R.drawable.casual2, R.drawable.casual3, R.drawable.casual4};
    final private int fps[] = {R.drawable.fps1, R.drawable.fps2, R.drawable.fps3, R.drawable.fps4};
    final private int aos[] = {R.drawable.aos1, R.drawable.aos2, R.drawable.aos3, R.drawable.aos4};
    final private int sports[] = {R.drawable.sports1, R.drawable.sports2, R.drawable.sports3, R.drawable.sports4};
    Button result; //모든 종목 보기
    Button allBack;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameresult);

        result = (Button) findViewById(R.id.gameResult);
        allBack = (Button) findViewById(R.id.gameAllBack);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), gameList.class);
                startActivity(intent);
            }
        });

        allBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.game);
                gameVar.gameCurrentPage=1;
                for(int i=0; i<5; i++) {
                    gameVar.gameList[i]=0;
                    gameVar.gamePreList[gameVar.gameCurrentPage][i]=0;
                    gameVar.maxValue=-99; // gameList 장르 최대 값
                    gameVar.index=-1; // 장르
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        for(int i=0; i<4; i++) {
            imageView[i] = (ImageView) findViewById(imageId[i]);
        }
        TextView resultPageText = findViewById(R.id.gameResultTextView);

        if(gameVar.index==0) {
            resultPageText.setText("게임에 투자할 자본이 있고 캐릭터가 점점 성장하는것을 즐기는 당신! RPG 게임을 추천드립니다!");
            for(int i=0; i<4; i++) {
                imageView[i].setImageResource(rpg[i]);
            }
        } else if(gameVar.index==1) {
            resultPageText.setText("조작 난이도가 쉽고 E-SPORTS 리그를 즐기는 당신! CASUAL 게임은 어떠신가요?");
            for(int i=0; i<4; i++) {
                imageView[i].setImageResource(casual[i]);
            }
        } else if(gameVar.index==2) {
            resultPageText.setText("총기를 들고 다른 유저와 싸우는걸 좋아하는 당신! FPS가 제격입니다!");
            for(int i=0; i<4; i++) {
                imageView[i].setImageResource(fps[i]);
            }
        } else if(gameVar.index==3) {
            resultPageText.setText("게임은 돈보단 실력! 다른 유저와 실력으로 겨루는걸 좋아하는 당신 AOS 게임을 추천드립니다");
            for(int i=0; i<4; i++) {
                imageView[i].setImageResource(aos[i]);
            }
        } else if(gameVar.index==4) {
            resultPageText.setText("평소 스포츠에도 관심이 있고 게임도 좋아하는 당신에게는 SPORTS 게임이 좋겠군요");
            for(int i=0; i<4; i++) {
                imageView[i].setImageResource(sports[i]);
            }
        }
    }
}