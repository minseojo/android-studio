package org.techtown.minmin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class game extends AppCompatActivity {
    Button[] gameBtn = new Button[5];
    Button result; //모든 종목 보기
    Button back;

    final private int gameBtnId[] = {R.id.gameButton, R.id.gameButton2, R.id.gameButton3, R.id.gameBack, R.id.gameAllBack};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        TextView page = findViewById(R.id.gamePage); // 현재 페이지 출력
        page.setText(1 + "/" + gameVar.gameTotalPage);
        TextView text = findViewById(R.id.gameTextView);

        for(int i=0; i<5; i++) {
            gameBtn[i] = (Button) findViewById(gameBtnId[i]);
        }

        result = (Button) findViewById(R.id.gameResult);

        //page.setText(gameVar.gameCurrentPage + "/" + (gameVar.gameTotalPage-1));
        gameBtn[2].setVisibility(View.INVISIBLE);
        text.setText("1. 내가 게임을 하는 장소는?");
        gameBtn[0].setText("PC방");
        gameBtn[1].setText("집");
        result.setVisibility(View.INVISIBLE);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), gameList.class);
                startActivity(intent);
            }
        });

        for(int i=0; i<gameBtn.length; i++) {
            final int index; //(*중요) final 안하면 안됌. 버튼 인덱스
            index = i;
            gameBtn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //어떤 버튼을 누르면 페이지 증가 (전체페이지 전까지만)
                    if(gameVar.gameCurrentPage <= gameVar.gameTotalPage+1 && (v.getId() == gameBtnId[0] ||  v.getId() == gameBtnId[1] || v.getId() == gameBtnId[2]) ) {
                        gameVar.gameCurrentPage++;
                    }
                    //뒤로가기
                    if(v.getId() == gameBtnId[3]) {
                        if(gameVar.gameCurrentPage==1) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                        for(int i=0; i<5; i++) {
                            gameVar.gameList[i]+= -1*gameVar.gamePreList[gameVar.gameCurrentPage][i];
                            gameVar.gamePreList[gameVar.gameCurrentPage][i]=0;
                        }
                        if(gameVar.gameCurrentPage>1) {
                            gameVar.gameCurrentPage--;
                        }
                    }
                    //처음부터
                    else if(v.getId() == gameBtnId[4]) {
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
                    if(gameVar.gameCurrentPage==1) {
                        gameBtn[2].setVisibility(View.INVISIBLE);
                        text.setText("1. 내가 게임을 하는 장소는?");
                        gameBtn[0].setText("PC방");
                        gameBtn[1].setText("집");
                    } if(gameVar.gameCurrentPage == 2) {
                        gameBtn[2].setVisibility(View.INVISIBLE);
                        text.setText("2. 내가 원하는 게임 내에서의 전투구도는?");
                        gameBtn[0].setText("유저vs몬스터");
                        gameBtn[1].setText("유저vs유저");
                    } else if(gameVar.gameCurrentPage == 3) {
                        gameBtn[2].setVisibility(View.VISIBLE);
                        text.setText("3. 내가 게임에 투자할 금액은?");
                        gameBtn[0].setText("무과금");
                        gameBtn[1].setText("1만원 ~ 10만원 이하");
                        gameBtn[2].setText("10만원 이상");
                    } else if(gameVar.gameCurrentPage == 4) {
                        gameBtn[2].setVisibility(View.VISIBLE);
                        text.setText("4. 나는 캐릭터 꾸미는것에 대해 어떻게 생각하는가?");
                        gameBtn[0].setText("관심없다.");
                        gameBtn[1].setText("좋아하지만 크게 상관은 없다.");
                        gameBtn[2].setText("캐릭터를 꾸미는것부터 시작한다.");
                    } else if(gameVar.gameCurrentPage == 5) {
                        gameBtn[2].setVisibility(View.VISIBLE);
                        text.setText("5. 나는 게임을 몇명이 같이 하는게 더 좋은가?");
                        gameBtn[0].setText("혼자서");
                        gameBtn[1].setText("2~3인");
                        gameBtn[2].setText("4인 이상");
                    } else if(gameVar.gameCurrentPage == 6) {
                        gameBtn[2].setVisibility(View.VISIBLE);
                        text.setText("6. 내가 원하는 게임의 조작 난이도는?");
                        gameBtn[0].setText("쉬움");
                        gameBtn[1].setText("보통");
                        gameBtn[2].setText("어려움");
                    } else if(gameVar.gameCurrentPage == 7) {
                        gameBtn[2].setVisibility(View.INVISIBLE);
                        text.setText("7. 나의 게임 플레이 스타일은?");
                        gameBtn[0].setText("팀을 이기게 하기 위한 헌신적인 플레이. ");
                        gameBtn[1].setText("내가 지휘하고 직접 캐리하는 플레이");
                    } else if(gameVar.gameCurrentPage == 8) {
                        gameBtn[2].setVisibility(View.INVISIBLE);
                        text.setText("8. 나는 eSports(리그 경기)보는 것을 좋아한다. ");
                        gameBtn[0].setText("그렇다.");
                        gameBtn[1].setText("그렇지 않다.");
                        result.setVisibility(View.VISIBLE);
                    }
                    if(gameVar.gameCurrentPage == 3) {
                        if(v.getId() == gameBtnId[0]) {
                            gameVar.gameList[0]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][0]=1;
                        } else if(v.getId() == gameBtnId[1]) {
                            gameVar.gameList[1]++;
                            gameVar.gameList[2]++;
                            gameVar.gameList[3]++;
                            gameVar.gameList[4]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][1]=1;
                            gameVar.gamePreList[gameVar.gameCurrentPage][2]=1;
                            gameVar.gamePreList[gameVar.gameCurrentPage][3]=1;
                            gameVar.gamePreList[gameVar.gameCurrentPage][4]=1;
                        }
                    } else if (gameVar.gameCurrentPage == 4) {
                        if(v.getId() == gameBtnId[0]) {
                            gameVar.gameList[0]--;
                            gameVar.gameList[2]++;
                            gameVar.gameList[3]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][0]=-1;
                            gameVar.gamePreList[gameVar.gameCurrentPage][2]=1;
                            gameVar.gamePreList[gameVar.gameCurrentPage][3]=1;
                        } else if(v.getId() == gameBtnId[1]) {
                            gameVar.gameList[1]++;
                            gameVar.gameList[4]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][1]=1;
                            gameVar.gamePreList[gameVar.gameCurrentPage][4]=1;
                        } else {
                            gameVar.gameList[0]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][0]=1;
                        }
                    } else if (gameVar.gameCurrentPage == 5) {
                        if(v.getId() == gameBtnId[0]) {
                            gameVar.gameList[2]++;
                            gameVar.gameList[4]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][2]=1;
                            gameVar.gamePreList[gameVar.gameCurrentPage][4]=1;
                        } else if(v.getId() == gameBtnId[1]) {
                            gameVar.gameList[3]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][3]=1;
                        } else {
                            gameVar.gameList[0]++;
                            gameVar.gameList[1]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][0]=1;
                            gameVar.gamePreList[gameVar.gameCurrentPage][1]=1;
                        }
                    } else if (gameVar.gameCurrentPage == 6) {
                        if(v.getId() == gameBtnId[0]) {
                            gameVar.gameList[0]++;
                            gameVar.gameList[1]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][0]=1;
                            gameVar.gamePreList[gameVar.gameCurrentPage][1]=1;
                        } else if(v.getId() == gameBtnId[1]) {
                            gameVar.gameList[4]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][4]=1;
                        } else {
                            gameVar.gameList[2]++;
                            gameVar.gameList[3]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][2]=1;
                            gameVar.gamePreList[gameVar.gameCurrentPage][3]=1;
                        }
                    } else if (gameVar.gameCurrentPage == 7) {
                        if(v.getId() == gameBtnId[0]) {
                            gameVar.gameList[0]++;
                            gameVar.gameList[1]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][0]=1;
                            gameVar.gamePreList[gameVar.gameCurrentPage][1]=1;
                        } else if(v.getId() == gameBtnId[1]) {
                            gameVar.gameList[4]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][4]=1;
                        } else {
                            gameVar.gameList[2]++;
                            gameVar.gameList[3]++;
                            gameVar.gamePreList[gameVar.gameCurrentPage][2]=1;
                            gameVar.gamePreList[gameVar.gameCurrentPage][3]=1;
                        }
                    } else if (gameVar.gameCurrentPage == 8) {
                        result.setVisibility(View.INVISIBLE);
                        if(v.getId() == gameBtnId[0] || v.getId() == gameBtnId[1] ||  v.getId() == gameBtnId[2] ) {
                            if (v.getId() == gameBtnId[0]) {
                                gameVar.gameList[1]++;
                                gameVar.gameList[2]++;
                                gameVar.gameList[3]++;
                                gameVar.gameList[4]++;
                                gameVar.gamePreList[gameVar.gameCurrentPage][1] = 1;
                                gameVar.gamePreList[gameVar.gameCurrentPage][2] = 1;
                                gameVar.gamePreList[gameVar.gameCurrentPage][3] = 1;
                                gameVar.gamePreList[gameVar.gameCurrentPage][4] = 1;
                            } else if (v.getId() == gameBtnId[1]) {
                                gameVar.gameList[0]++;
                                gameVar.gamePreList[gameVar.gameCurrentPage][0] = 1;

                            }
                            for(int i=0; i<5; i++) {
                                if(gameVar.gameList[i]>gameVar.maxValue) {
                                    gameVar.maxValue=gameVar.gameList[i];
                                    gameVar.index = i;
                                }
                            }
                        }
                    } else if (gameVar.gameCurrentPage == 9) {
                        //결과 인텐트 출력
                        Intent intent = new Intent(getApplicationContext(), gameResult.class);
                        startActivity(intent);
                    }
                    page.setText(gameVar.gameCurrentPage + "/" + (gameVar.gameTotalPage));
                }
            });
        }
    }
}