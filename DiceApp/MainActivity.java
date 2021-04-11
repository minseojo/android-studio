package org.techtown.diceapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioGroup choiceDice; // 라디오 버튼(1,2,3,4,5,6) 그룹 한번에 묶어서 버튼 리스너 생성
    RadioButton dice_one, dice_two, dice_three, dice_four, dice_five, dice_six; // 라디오버튼 객체
    int radioButtonId[] = {0, R.id.dice_one, R.id.dice_two, R.id.dice_three, R.id.dice_four, R.id.dice_five, R.id.dice_six}; // 주사위 선택 갯수 버튼 id저장
    Button throwDice; // 주사위 던지기 버튼
    int whichRadioButton = 1; // 주사위 선택 갯수
    ImageView diceimage1, diceimage2, diceimage3, diceimage4, diceimage5,diceimage6 ; // xml이미지 뷰
    int iamgeResource[] = {-1, R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6}; // 폴더에 저장된 이미지
    Random random = new Random(); // 난수 설정

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 주사위 선택 버튼
       // choiceDice1 = findViewById(R.id.choicedice1); choiceDice2 = findViewById(R.id.choicedice2);
        choiceDice = findViewById(R.id.choicedice3);

        // 주사위 던지기 버튼
        throwDice = findViewById(R.id.throwdice);

        // 주사위 갯수 라디오버튼
        dice_one = findViewById(R.id.dice_one); dice_two = findViewById(R.id.dice_two); dice_three = findViewById(R.id.dice_three);
        dice_four = findViewById(R.id.dice_four); dice_five = findViewById(R.id.dice_five); dice_six = findViewById(R.id.dice_six);

        // 주사위 이미지
        diceimage1 = findViewById(R.id.diceimage1); diceimage2 = findViewById(R.id.diceimage2);
        diceimage3 = findViewById(R.id.diceimage3); diceimage4 = findViewById(R.id.diceimage4);
        diceimage5 = findViewById(R.id.diceimage5); diceimage6 = findViewById(R.id.diceimage6);
        ImageView dice[] = {null , diceimage1, diceimage2, diceimage3, diceimage4, diceimage5, diceimage6};

        choiceDice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i=1; i<=6; i++) {
                    if(checkedId == radioButtonId[i]) {
                        whichRadioButton = i;
                        for(int j=1; j<=6; j++) {
                            if(j > whichRadioButton)  // 굴린 주사위의 갯수보다 인덱스가 많으면 안보이게 설정.
                                dice[j].setVisibility(View.INVISIBLE);
                            else // 굴린 주사위보다 인덱스가 적거나 같으면 보이게 설정.
                                dice[j].setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });

        throwDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x;
                int numberOfDice[] = {-1, 1, 1, 1, 1, 1, 1}; // 주사위 선택 갯수 배열에 난수를 설정
                for(int i=1; i<=whichRadioButton; i++) {
                    x = random.nextInt(6)+1; // 난수 가져오기
                    numberOfDice[i] = x; // 각각의 주사위 배열에 난수 설정 ex) 첫번째 주사위 = 5, 두번째 주사위 = 2
                }
                for(int i=1; i<=whichRadioButton; i++) {
                        dice[i].setImageResource(iamgeResource[numberOfDice[i]]); // dice는 이미지 뷰 배열, imageResource는 폴더에 저장된 이미지 배열
                    // numberOfDice는 각각의 주사위 갯수에 따른 난수 값들 -> 각각의 이미지뷰에 폴더에 저장된 랜덤 주사위 갯수가 띄어짐.
                }
            }
        });
    }
}