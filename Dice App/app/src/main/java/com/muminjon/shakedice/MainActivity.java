package com.muminjon.shakedice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRoll = findViewById(R.id.btnRollTheDice);
        final ImageView diceImage1 = findViewById(R.id.imgDice1);
        final ImageView diceImage2 = findViewById(R.id.imgDice2);

        final int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3
                                   , R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Shake)
                        .duration(700)
                        .repeat(2)
                        .playOn(findViewById(R.id.imgDice1));

                YoYo.with(Techniques.Shake)
                        .duration(700)
                        .repeat(2)
                        .playOn(findViewById(R.id.imgDice2));

                Random rndOb = new Random();

                int myRnd = rndOb.nextInt(6);   // between 0 & 5
                diceImage1.setImageResource(diceImages[myRnd]);

                int myRnd2 = rndOb.nextInt(6);
                diceImage2.setImageResource(diceImages[myRnd2]);

                mp.start();
            }
        });
    }
}
