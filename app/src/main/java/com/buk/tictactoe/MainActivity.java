package com.buk.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //Fields are name like:
    //0 1 2
    //3 4 5
    //6 7 8
    static Color[] scoreArray=new Color[9];
    static boolean redDrop=true;

    public void dropIn(View view)
    {

        ImageView clicked= (ImageView) view;
        if(redDrop)
        {
            clicked.setImageResource(R.drawable.red);
        }
        else
        {
            clicked.setImageResource(R.drawable.green);
        }
        clicked.setTranslationY(-1000f);
        clicked.animate().translationYBy(1000f).rotationBy(360f).setDuration(1000);
        clicked.setClickable(false);

        MainService.showToasterAndStopGame(getApplicationContext(),MainService.checkGame(clicked.getTag().toString(),scoreArray,redDrop));

        redDrop=!redDrop;
        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(Color value:scoreArray)
        {
            value=Color.NONE;
        }
        setContentView(R.layout.activity_main);
    }
}