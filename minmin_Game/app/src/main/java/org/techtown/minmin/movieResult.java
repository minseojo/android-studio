package org.techtown.minmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class movieResult extends AppCompatActivity {
    ImageView[] movieImageView = new ImageView[4];
    final private int movieImageId[] = {R.id.moviefalse0, R.id.moviefalse1, R.id.moviefalse2, R.id.moviefalse3};
    final private int action[] = {R.drawable.action1, R.drawable.action2, R.drawable.action3, R.drawable.action4};
    final private int romance[] = {R.drawable.romance1, R.drawable.romance2, R.drawable.romance3, R.drawable.romance4};
    final private int fear[] = {R.drawable.fear1, R.drawable.fear2, R.drawable.fear3, R.drawable.fear4};
    final private int fantasy[] = {R.drawable.fantasy1, R.drawable.fantasy2, R.drawable.fantasy3, R.drawable.fantasy4};
    final private int comedy[] = {R.drawable.comedy1, R.drawable.comedy2, R.drawable.comedy3, R.drawable.comedy4};
    final private int document[] = {R.drawable.document1, R.drawable.document2, R.drawable.document3, R.drawable.document4};


    Button result; //모든 종목 보기
    Button allBack;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movieresult);

        result = (Button) findViewById(R.id.movieResult);
        allBack = (Button) findViewById(R.id.movieAllBack);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), movieList.class);
                startActivity(intent);
            }
        });

        allBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.movie);
                movieVar.movieCurrentPage=1;
                for(int i=0; i<5; i++) {
                    movieVar.movieList[i]=0;
                    movieVar.moviePreList[movieVar.movieCurrentPage][i]=0;
                    movieVar.maxValue=-99;
                    movieVar.index=-1;
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        for(int i=0; i<4; i++) {
            movieImageView[i] = (ImageView) findViewById(movieImageId[i]);
        }
        TextView resultPageText = findViewById(R.id.movieResultTextView);

        if(movieVar.index==0) {
            resultPageText.setText("폭력적이고 잔인할 순 있지만 시원시원한 액션을 좋아하는 당신! 액션,범죄 영화를 추천드립니다");
            for(int i=0; i<4; i++) {
                movieImageView[i].setImageResource(action[i]);
            }
        } else if(movieVar.index==1) {
            resultPageText.setText("편안하게 영화를 보며 연애세포를 깨우고싶은 당신에게는 로맨스 영화가 제격!");
            for(int i=0; i<4; i++) {
                movieImageView[i].setImageResource(romance[i]);
            }
        } else if(movieVar.index==2) {
            resultPageText.setText("무섭고 오싹한 장르를 즐기는 당신에게는 공포,스릴 영화말곤 없죠!");
            for(int i=0; i<4; i++) {
                movieImageView[i].setImageResource(fear[i]);
            }
        } else if(movieVar.index==3) {
            resultPageText.setText("현실에서 벗어나 상상 속의 장면들을 원하는 당신! 오늘 판타지 영화는 어떠신가요?");
            for(int i=0; i<4; i++) {
                movieImageView[i].setImageResource(fantasy[i]);
            }
        } else if(movieVar.index==4) {
            resultPageText.setText("가벼운 마음으로 한바탕 웃고싶을때는 아래의 코미디 영화들을 봐보세요!");
            for(int i=0; i<4; i++) {
                movieImageView[i].setImageResource(comedy[i]);
            }
        } else if(movieVar.index==5) {
            resultPageText.setText("평소에 다큐랑 영화 둘 다 즐겨본다면? 현실적인 긴장감을 선사하는 다큐영화를 추천합니다!");
            for (int i = 0; i < 4; i++) {
                movieImageView[i].setImageResource(document[i]);
            }
        }
    }
}