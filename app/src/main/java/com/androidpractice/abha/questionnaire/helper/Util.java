package com.androidpractice.abha.questionnaire.helper;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ABHA on 14-08-2017.
 */

public class Util {
    Context context;

    public Util(Context context) {
        this.context = context;
    }

    public void displayToast(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
