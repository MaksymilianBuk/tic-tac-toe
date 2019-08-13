package com.buk.tictactoe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public abstract class MainService {
    static Color checkGame(String positionTag,Color [] scoreArray, boolean red)
    {
        //Set position to scoreArray
        int position=Integer.parseInt(positionTag);
        if(red)
        {
            scoreArray[position]=Color.RED;
        }
        else
        {
            scoreArray[position]=Color.GREEN;
        }

        //Check if someone wins
        //Just remind:
        //Fields are name like:
        //0 1 2
        //3 4 5
        //6 7 8
        if
        ((scoreArray[0] == scoreArray[1]) && (scoreArray[1] == scoreArray[2]) && (scoreArray[0]!=Color.NONE)
                || (scoreArray[3] == scoreArray[4]) && (scoreArray[4] == scoreArray[5]) && (scoreArray[3]!=Color.NONE)
                || (scoreArray[6] == scoreArray[7]) && (scoreArray[7] == scoreArray[8]) && (scoreArray[6]!=Color.NONE)
                || (scoreArray[0] == scoreArray[3]) && (scoreArray[3] == scoreArray[6]) && (scoreArray[0]!=Color.NONE)
                || (scoreArray[1] == scoreArray[4]) && (scoreArray[4] == scoreArray[7]) && (scoreArray[1]!=Color.NONE)
                || (scoreArray[2] == scoreArray[5]) && (scoreArray[5] == scoreArray[8]) && (scoreArray[2]!=Color.NONE)
                || (scoreArray[0] == scoreArray[4]) && (scoreArray[4] == scoreArray[8]) && (scoreArray[0]!=Color.NONE)
                || (scoreArray[2] == scoreArray[4]) && (scoreArray[4] == scoreArray[6]) && (scoreArray[2]!=Color.NONE)
        )  {
            if (red) {
                return Color.RED;
            } else {
                return Color.GREEN;
            }
        }
        return Color.NONE;
    }

    static void showToasterAndStopGame(Context context,View view, Color winPlayer)
    {
        if(winPlayer==Color.RED)
        {
            Toast toast= Toast.makeText(context, "RED PLAYER WINS!\nFLAWLESS VICTORY!", Toast.LENGTH_LONG);

//            view=toast.getView();
//            view.setBackgroundColor(android.graphics.Color.parseColor("9c0505"));
//            TextView text = (TextView) view.findViewById(android.R.id.message);
//            text.setTextColor(android.graphics.Color.parseColor("#ebe6e6"));
//            text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            toast.show();
        }
        if(winPlayer==Color.GREEN)
        {
            Toast toast= Toast.makeText(context, "GREEN PLAYER WINS!\nFLAWLESS VICTORY!", Toast.LENGTH_SHORT);
//            View view=toast.getView();
//           view.setBackgroundColor(android.graphics.Color.parseColor("9c0505"));
//            TextView text = (TextView) view.findViewById(android.R.id.message);
//            text.setTextColor(android.graphics.Color.parseColor("#ebe6e6"));
//            //text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            toast.show();
        }

        //Need to find how to stop game and block rest of clicks... Disable all buttons? Thread stop?

    }
}
