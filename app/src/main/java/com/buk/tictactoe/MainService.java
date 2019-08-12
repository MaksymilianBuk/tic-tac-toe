package com.buk.tictactoe;

import android.content.Context;
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
        if((scoreArray[0]==Color.RED)&&scoreArray[1]==Color.RED&&scoreArray[2]==Color.RED)
        {
            return Color.RED;
        }
        if((scoreArray[3]==Color.RED)&&scoreArray[4]==Color.RED&&scoreArray[5]==Color.RED)
        {
            return Color.RED;
        }
        if((scoreArray[6]==Color.RED)&&scoreArray[7]==Color.RED&&scoreArray[8]==Color.RED)
        {
            return Color.RED;
        }
        if((scoreArray[0]==Color.RED)&&scoreArray[3]==Color.RED&&scoreArray[6]==Color.RED)
        {
            return Color.RED;
        }
        if((scoreArray[1]==Color.RED)&&scoreArray[4]==Color.RED&&scoreArray[7]==Color.RED)
        {
            return Color.RED;
        }
        if((scoreArray[2]==Color.RED)&&scoreArray[5]==Color.RED&&scoreArray[8]==Color.RED)
        {
            return Color.RED;
        }
        if((scoreArray[0]==Color.RED)&&scoreArray[4]==Color.RED&&scoreArray[8]==Color.RED)
        {
            return Color.RED;
        }
        if((scoreArray[2]==Color.RED)&&scoreArray[4]==Color.RED&&scoreArray[6]==Color.RED)
        {
            return Color.RED;
        }
        if((scoreArray[0]==Color.GREEN)&&scoreArray[1]==Color.GREEN&&scoreArray[2]==Color.GREEN)
        {
            return Color.GREEN;
        }
        if((scoreArray[3]==Color.GREEN)&&scoreArray[4]==Color.GREEN&&scoreArray[5]==Color.GREEN)
        {
            return Color.GREEN;
        }
        if((scoreArray[6]==Color.GREEN)&&scoreArray[7]==Color.GREEN&&scoreArray[8]==Color.GREEN)
        {
            return Color.GREEN;
        }
        if((scoreArray[0]==Color.GREEN)&&scoreArray[3]==Color.GREEN&&scoreArray[6]==Color.GREEN)
        {
            return Color.GREEN;
        }
        if((scoreArray[1]==Color.GREEN)&&scoreArray[4]==Color.GREEN&&scoreArray[7]==Color.GREEN)
        {
            return Color.GREEN;
        }
        if((scoreArray[2]==Color.GREEN)&&scoreArray[5]==Color.GREEN&&scoreArray[8]==Color.GREEN)
        {
            return Color.GREEN;
        }
        if((scoreArray[0]==Color.GREEN)&&scoreArray[4]==Color.GREEN&&scoreArray[8]==Color.GREEN)
        {
            return Color.GREEN;
        }
        if((scoreArray[2]==Color.GREEN)&&scoreArray[4]==Color.GREEN&&scoreArray[6]==Color.GREEN)
        {
            return Color.GREEN;
        }
        return Color.NONE;
    }

    static void showToasterAndStopGame(Context context, Color winPlayer)
    {
        if(winPlayer==Color.RED)
        {
            Toast.makeText(context, "RED PLAYER WINS!\n\nFLAWLESS VICTORY!", Toast.LENGTH_SHORT).show();
        }
        if(winPlayer==Color.GREEN)
        {
            Toast.makeText(context, "GREEN PLAYER WINS!\n\nFLAWLESS VICTORY!", Toast.LENGTH_SHORT).show();
        }


        //Need to find how to stop game and block rest of clicks... Disable all buttons? Thread stop?
        
    }
}
