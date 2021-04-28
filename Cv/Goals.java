package org.techtown.cv;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Goals extends AppCompatActivity {
    ImageView image1, image2,image3, image4;
    boolean flag[] = new boolean[5];
    TextView text1, text2, text3, text4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goals);

        image1 = findViewById(R.id.imageView1); image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView3); image4 = findViewById(R.id.imageView4);
        ImageView image[] = {null, image1, image2, image3, image4}; // 이미지뷰 넣어놓기

        text1 = findViewById(R.id.textView1); text2 = findViewById(R.id.textView2);
        text3 = findViewById(R.id.textView3); text4 = findViewById(R.id.textView4);
        TextView text[] = {null, text1, text2, text3, text4};
        for(int i=1; i<=4; i++) {
            text[i].setVisibility(View.INVISIBLE);
        }
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=1; i<=4; i++) {
                    if(!flag[i]) {
                        image[i].setImageResource(R.drawable.on);
                        text[i].setVisibility(View.VISIBLE);
                        flag[i]=true;
                        if(i==4) button.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }) ;
    }
}