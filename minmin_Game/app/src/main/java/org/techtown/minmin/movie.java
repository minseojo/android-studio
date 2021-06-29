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

public class movie extends AppCompatActivity {
    Button[] movieBtn = new Button[5];
    Button result; //모든 종목 보기
    Button back;

    final private int movieBtnId[] = {R.id.movieButton, R.id.movieButton2, R.id.movieButton3, R.id.movieBack, R.id.movieAllBack};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);
        TextView page = findViewById(R.id.moviePage); // 현재 페이지 출력
        page.setText(1 + "/" + movieVar.movieTotalPage);
        TextView text = findViewById(R.id.movieTextView);

        for(int i=0; i<5; i++) {
            movieBtn[i] = (Button) findViewById(movieBtnId[i]);
        }

        result = (Button) findViewById(R.id.movieResult);

        //page.setText(movieVar.movieCurrentPage + "/" + (movieVar.movieTotalPage-1));
        movieBtn[2].setVisibility(View.INVISIBLE);
        text.setText("1. 내가 영화를 보는 장소는?");
        movieBtn[0].setText("영화관에서 대형스크린으로 본다. ");
        movieBtn[1].setText("집에서 다운받아서 본다.");

        result.setVisibility(View.INVISIBLE);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), movieList.class);
                startActivity(intent);
            }
        });

        for(int i=0; i<movieBtn.length; i++) {
            final int index; //(*중요) final 안하면 안됌. 버튼 인덱스
            index = i;
            movieBtn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //어떤 버튼을 누르면 페이지 증가 (전체페이지 전까지만)
                    if(movieVar.movieCurrentPage <= movieVar.movieTotalPage+1 && (v.getId() == movieBtnId[0] ||  v.getId() == movieBtnId[1] || v.getId() == movieBtnId[2]) ) {
                        movieVar.movieCurrentPage++;
                    }
                    //뒤로가기
                    if(v.getId() == movieBtnId[3]) {
                        if(movieVar.movieCurrentPage==1) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                        for(int i=0; i<5; i++) {
                            movieVar.movieList[i]+= -1*movieVar.moviePreList[movieVar.movieCurrentPage][i];;
                            movieVar.moviePreList[movieVar.movieCurrentPage][i]=0;
                        }
                        if(movieVar.movieCurrentPage>1) {
                            movieVar.movieCurrentPage--;
                        }
                    }
                    //처음부터
                    else if(v.getId() == movieBtnId[4]) {
                        movieVar.movieCurrentPage=1;
                        for(int i=0; i<5; i++) {
                            movieVar.movieList[i]=0;
                            movieVar.moviePreList[movieVar.movieCurrentPage][i]=0;
                            movieVar.maxValue=-99; // movieList 장르 최대 값
                            movieVar.index=-1; // 장르
                        }
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }

                    if (movieVar.movieCurrentPage == 1) {
                        movieBtn[2].setVisibility(View.INVISIBLE);
                        text.setText("1. 내가 영화를 보는 장소는??");
                        movieBtn[0].setText("영화관에서 대형스크린으로 본다.");
                        movieBtn[1].setText("집에서 다운받아서 본다.");
                    }
                    if (movieVar.movieCurrentPage == 2) {
                        movieBtn[2].setVisibility(View.INVISIBLE);
                        text.setText("2. 내가 영화를 보는 목적은?");
                        movieBtn[0].setText("가볍게 시간을 보내기 위해");
                        movieBtn[1].setText("영화를 진지하게 즐기고싶어서");
                    } else if (movieVar.movieCurrentPage == 3) {
                        movieBtn[2].setVisibility(View.VISIBLE);
                        text.setText("3. 내가 원하는 영화의 결말은?");
                        movieBtn[0].setText("감동적인 결말");
                        movieBtn[1].setText("시원한 결말");
                        movieBtn[2].setText("찝찝한 결말");
                    } else if (movieVar.movieCurrentPage == 4) {
                        movieBtn[2].setVisibility(View.INVISIBLE);
                        text.setText("4. 내가 원하는 영화의 분위기는?");
                        movieBtn[0].setText("긴장되는 분위기");
                        movieBtn[1].setText("편한 분위기");
                    } else if (movieVar.movieCurrentPage == 5) {
                        movieBtn[2].setVisibility(View.INVISIBLE);
                        text.setText("5. 내가 선호하는 영화의 종류는?");
                        movieBtn[0].setText("허구적인 영화");
                        movieBtn[1].setText("사실감 있는 영화");
                    } else if (movieVar.movieCurrentPage == 6) {
                        movieBtn[2].setVisibility(View.VISIBLE);
                        text.setText("6. 내가 좋아하는 영화의 자극 정도는?");
                        movieBtn[0].setText("강한 자극");
                        movieBtn[1].setText("보통 자극");
                        movieBtn[2].setText("약한 자극");
                    } else if (movieVar.movieCurrentPage == 7) {
                        movieBtn[2].setVisibility(View.VISIBLE);
                        text.setText("7. 내가 영화를 볼 때 더 중요하게 여기는 요소는?");
                        movieBtn[0].setText("영화의 스토리 ");
                        movieBtn[1].setText("배우의 연기");
                        movieBtn[1].setText("영화의 소재");
                    } else if (movieVar.movieCurrentPage == 8) {
                        movieBtn[2].setVisibility(View.VISIBLE);
                        text.setText("8. 나는 보통 영화를 볼 때 누구랑 같이 보는가?");
                        movieBtn[0].setText("혼자서 본다.");
                        movieBtn[1].setText("가족과 본다.");
                        movieBtn[2].setText("친구와 본다.");
                    }
                    if(movieVar.movieCurrentPage == 3) {
                        if(v.getId() == movieBtnId[0]) {
                            movieVar.movieList[1]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][1]=1;
                            movieVar.movieList[3]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][3]=1;
                            movieVar.movieList[4]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][4]=1;
                        } else if(v.getId() == movieBtnId[1]) {
                            movieVar.movieList[0]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][0]=1;
                            movieVar.movieList[2]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][2]=1;
                            movieVar.movieList[5]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][5]=1;
                        }
                    } else if (movieVar.movieCurrentPage == 4) {
                        if(v.getId() == movieBtnId[0]) {
                            movieVar.movieList[1]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][1]=1;
                            movieVar.movieList[3]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][3]=1;
                            movieVar.movieList[4]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][4]=1;
                            movieVar.movieList[5]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][5]=1;
                        } else if(v.getId() == movieBtnId[1]) {
                            movieVar.movieList[0]++;
                            movieVar.movieList[0]++;
                        } else {
                            movieVar.movieList[2]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][2]=1;
                        }
                    } else if (movieVar.movieCurrentPage == 5) {
                        if(v.getId() == movieBtnId[0]) {
                            movieVar.movieList[0]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][0]=1;
                            movieVar.movieList[2]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][2]=1;
                            movieVar.movieList[5]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][5]=1;
                        } else if(v.getId() == movieBtnId[1]) {
                            movieVar.movieList[1]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][1]=1;
                            movieVar.movieList[3]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][3]=1;
                            movieVar.movieList[4]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][4]=1;
                        }
                    } else if (movieVar.movieCurrentPage == 6) {
                        if(v.getId() == movieBtnId[0]) {
                            movieVar.movieList[0]++;
                            movieVar.movieList[2]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][0]=1;
                            movieVar.moviePreList[movieVar.movieCurrentPage][2]=1;
                        } else if(v.getId() == movieBtnId[1]) {
                            movieVar.movieList[3]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][3]=1;
                            movieVar.movieList[5]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][5]=1;
                        } else {
                            movieVar.movieList[1]++;
                            movieVar.movieList[4]++;
                            movieVar.moviePreList[movieVar.movieCurrentPage][1]=1;
                            movieVar.moviePreList[movieVar.movieCurrentPage][4]=1;
                        }
                    } else if (movieVar.movieCurrentPage == 8) {
                        if(v.getId() == movieBtnId[0] || v.getId() == movieBtnId[1] ||  v.getId() == movieBtnId[2] ) {
                            for(int i=0; i<6; i++) {
                                if(movieVar.movieList[i]>movieVar.maxValue) {
                                    movieVar.maxValue=movieVar.movieList[i];
                                    movieVar.index = i;
                                }
                            }
                        }
                    } else if (movieVar.movieCurrentPage == 9) {
                        //결과 인텐트 출력
                        Intent intent = new Intent(getApplicationContext(), movieResult.class);
                        startActivity(intent);
                    }
                    //rpg casual fps aos sports
                    page.setText(movieVar.movieCurrentPage + "/" + (movieVar.movieTotalPage));

                    System.out.println(movieVar.movieCurrentPage);
                    for(int j=0; j<5; j++) {
                        System.out.println(String.valueOf(j) + ": " + movieVar.movieList[j]);
                    }
                }
            });
        }
    }
}