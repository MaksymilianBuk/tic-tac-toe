package com.buk.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Fields are name like:
    //0 1 2
    //3 4 5
    //6 7 8
    static Color[] scoreArray=new Color[9];
    static boolean redDrop=true;
    static int clickCount;
    LinearLayout linearLayout;
    TextView resultNotification;


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

        if(clicked.getTag().toString().equals("0")||clicked.getTag().toString().equals("1")||clicked.getTag().toString().equals("2"))
        {
            clicked.setTranslationY(1000f);
            clicked.animate().translationYBy(-1000f).rotationBy(360f).setDuration(1000);
            clicked.setClickable(false);
        }
        else
        {
            clicked.setTranslationY(-1000f);
            clicked.animate().translationYBy(1000f).rotationBy(360f).setDuration(1000);
            clicked.setClickable(false);
        }


        clickCount++;
        if (MainService.checkGame(clicked.getTag().toString(), scoreArray, redDrop)==Color.GREEN)
        {
            linearLayout=(LinearLayout) findViewById(R.id.linearLayout);
            resultNotification =(TextView) findViewById(R.id.resultNotafication);
            resultNotification.setText("Green player wins");
            linearLayout.setBackgroundColor(android.graphics.Color.parseColor("#0d6134"));
            //linearLayout.setBackgroundColor(0x0d6134);
            linearLayout.animate().alpha(1f).setDuration(1000);
            linearLayout.setVisibility(View.VISIBLE);
        }
        if (MainService.checkGame(clicked.getTag().toString(), scoreArray, redDrop)==Color.RED)
        {
            linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
            resultNotification = (TextView) findViewById(R.id.resultNotafication);
            resultNotification.setText("Red player wins");
            linearLayout.setBackgroundColor(android.graphics.Color.parseColor("#730707"));
            //linearLayout.setBackgroundColor(0x730707);
            linearLayout.animate().alpha(1f).setDuration(1000);
            linearLayout.setVisibility(View.VISIBLE);
        }
        if(clickCount>=9)
        {
            linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
            resultNotification = (TextView) findViewById(R.id.resultNotafication);
            resultNotification.setText("It's a draw! Try again!");
            resultNotification.setTextColor(android.graphics.Color.parseColor("#000000"));
            //resultNotification.setTextColor(0x00000);
            linearLayout.setBackgroundColor(android.graphics.Color.parseColor("#7b8087"));
            //linearLayout.setBackgroundColor(0x7b8087);
            linearLayout.animate().alpha(1f).setDuration(1000);
            linearLayout.setVisibility(View.VISIBLE);
        }

        //MainService.showToasterAndStopGame(getApplicationContext(),view,MainService.checkGame(clicked.getTag().toString(),scoreArray,redDrop));

        redDrop=!redDrop;
    }

    public void playAgain(View view)
    {
        for(int i=0;i<9;i++)
        {
            scoreArray[i]=Color.NONE;
        }
        setContentView(R.layout.activity_main);
        clickCount=0;
        findViewById(R.id.linearLayout).setVisibility(View.INVISIBLE);
        linearLayout.setAlpha(0f);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickCount=0;
        findViewById(R.id.linearLayout).setVisibility(View.INVISIBLE);
//        for(Color value:scoreArray)
//        {
//            value=Color.NONE;
//        }
        for(int i=0;i<9;i++)
        {
            scoreArray[i]=Color.NONE;
        }
    }
}
