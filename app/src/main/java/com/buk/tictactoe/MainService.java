package com.buk.tictactoe;
//import android.widget.GridLayout;

import androidx.gridlayout.widget.GridLayout;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class MainService
{
   //Check game status. Return Color.NONE if no one wins. Otherwise- return color of winner (e.g. Color.RED if Red player wins)
   static Color checkGame(String positionTag, Color[] scoreArray, boolean red)
   {
      //Set position to scoreArray
      int position = Integer.parseInt(positionTag);
      if (red)
      {
         scoreArray[position] = Color.RED;
      } else
      {
         scoreArray[position] = Color.GREEN;
      }

      //Check if someone wins
      //Just remind:
      //Fields are name like:
      //0 1 2
      //3 4 5
      //6 7 8

      //Check if any line has got the same color except Color.NONE.
      if
      ((scoreArray[0] == scoreArray[1]) && (scoreArray[1] == scoreArray[2]) && (scoreArray[0] != Color.NONE)
              || (scoreArray[3] == scoreArray[4]) && (scoreArray[4] == scoreArray[5]) && (scoreArray[3] != Color.NONE)
              || (scoreArray[6] == scoreArray[7]) && (scoreArray[7] == scoreArray[8]) && (scoreArray[6] != Color.NONE)
              || (scoreArray[0] == scoreArray[3]) && (scoreArray[3] == scoreArray[6]) && (scoreArray[0] != Color.NONE)
              || (scoreArray[1] == scoreArray[4]) && (scoreArray[4] == scoreArray[7]) && (scoreArray[1] != Color.NONE)
              || (scoreArray[2] == scoreArray[5]) && (scoreArray[5] == scoreArray[8]) && (scoreArray[2] != Color.NONE)
              || (scoreArray[0] == scoreArray[4]) && (scoreArray[4] == scoreArray[8]) && (scoreArray[0] != Color.NONE)
              || (scoreArray[2] == scoreArray[4]) && (scoreArray[4] == scoreArray[6]) && (scoreArray[2] != Color.NONE))
      {
         if (red)
         {
            return Color.RED;
         } else
         {
            return Color.GREEN;
         }
      }
      return Color.NONE;
   }


   //Disable all ImageViews in GridLayout
   static void disableGrid(GridLayout gridLayout)
   {
      for (int i = 0; i < gridLayout.getChildCount(); i++)
      {
         ((ImageView) gridLayout.getChildAt(i)).setClickable(false);
      }
   }

   //Enable all ImageViews in GridLayout
   static void enableGrid(GridLayout gridLayout)
   {
      for (int i = 0; i < gridLayout.getChildCount(); i++)
      {
         ((ImageView) gridLayout.getChildAt(i)).setClickable(true);
      }
   }

   //Reset game board to blank by deleting resources of all images.
   static void resetImages(GridLayout gridLayout)
   {
      for (int i = 0; i < gridLayout.getChildCount(); i++)
      {
         ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
      }
   }
}
