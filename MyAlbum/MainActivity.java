package com.example.myalbum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button[] btn = new Button[11]; // 버튼 배열
    ImageView imageView; // xml파일 이미지 뷰
    // 버튼 Id
    final private int btnId[] = {0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10};
    // 폴더에 저장된 이미지
    int imageResources[] = {-1, R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4, R.drawable.photo5, R.drawable.photo6, R.drawable.photo7, R.drawable.photo8, R.drawable.photo9, R.drawable.photo10};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);

        for(int i=1; i<imageResources.length; i++) {
            final int index; //(*중요) final 안하면 안됌.
            index = i;
            btn[index] = (Button) findViewById(btnId[index]);
            btn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageView.setImageResource(imageResources[index]); // 누른  버튼 이미지로 변경
                    btn[index].setAlpha(1.0f); // 누른 버튼 진하게
                    for(int i=1; i<=10; i++) { // 누른 버튼 제외하고 연하게
                        if(i!=index) btn[i].setAlpha(0.3f);
                    }
                }
            });
        }

        //시작시 처음버튼 제외한 모든버튼 뿌옇게
        for (int i = 2; i <= 10; i++) {
            btn[i].setAlpha(0.3f);
        }
    }
}