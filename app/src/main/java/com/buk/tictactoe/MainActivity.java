package com.buk.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
//import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
   //Fields are name like:
   //0 1 2
   //3 4 5
   //6 7 8
   static Color[] scoreArray = new Color[9];
   static boolean redTurn = true;
   static int clickCount;
   LinearLayout linearLayout;
   GridLayout gridLayout;
   TextView resultNotification;

   //Handle player's choice
   public void dropIn(View view)
   {
      ImageView clicked = (ImageView) view;
      //Check whose turn right now and set proper image.
      if (redTurn)
      {
         clicked.setImageResource(R.drawable.red);
      } else
      {
         clicked.setImageResource(R.drawable.green);
      }

      //Animation block of dropping down item. If clicked on the highest line- item will climb up from bottom.
      if (clicked.getTag().toString().equals("0") || clicked.getTag().toString().equals("1") || clicked.getTag().toString().equals("2"))
      {
         clicked.setTranslationY(1000f);
         clicked.animate().translationYBy(-1000f).rotationBy(360f).setDuration(1000);
         clicked.setClickable(false);
      } else
      {
         clicked.setTranslationY(-1000f);
         clicked.animate().translationYBy(1000f).rotationBy(360f).setDuration(1000);
         clicked.setClickable(false);
      }

      //Increment total number of turns.
      clickCount++;

      //Check if someone wins by validating return value. Show proper notification with animation.

      //Green wins.
      if (MainService.checkGame(clicked.getTag().toString(), scoreArray, redTurn) == Color.GREEN)
      {
         MainService.endGameAndShowInfo(linearLayout, gridLayout, resultNotification, Color.GREEN);
      }

      //Red wins.
      if (MainService.checkGame(clicked.getTag().toString(), scoreArray, redTurn) == Color.RED)
      {
         MainService.endGameAndShowInfo(linearLayout, gridLayout, resultNotification, Color.RED);
      }

      //Check if it is a draw by validating total number of turns and show notification.
      if (clickCount >= 9)
      {
         MainService.endGameAndShowInfo(linearLayout, gridLayout, resultNotification, Color.NONE);
      }

      //Change player1 into player2 (Red into Green or vice versa)
      redTurn = !redTurn;
   }

   //Start new game.
   public void playAgain(View view)
   {
      for (int i = 0; i < scoreArray.length; i++)
      {
         scoreArray[i] = Color.NONE;
      }
      clickCount = 0;
      findViewById(R.id.linearLayout).setVisibility(View.INVISIBLE);
      linearLayout.setAlpha(0f);
      //gridLayout = (GridLayout) findViewById(R.id.gridLayout);
      MainService.enableGrid(gridLayout);
      MainService.resetImages(gridLayout);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      clickCount = 0;
      findViewById(R.id.linearLayout).setVisibility(View.INVISIBLE);

      linearLayout=(LinearLayout)findViewById(R.id.linearLayout);
      gridLayout=(GridLayout) findViewById(R.id.gridLayout);
      resultNotification=(TextView) findViewById(R.id.resultNotafication);

      for (int i = 0; i < 9; i++)
      {
         scoreArray[i] = Color.NONE;
      }
   }
}
