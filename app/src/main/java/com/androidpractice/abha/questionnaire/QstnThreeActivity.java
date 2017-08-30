package com.androidpractice.abha.questionnaire;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QstnThreeActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private CheckBox cbRed, cbGreen, cbBlue, cbNone, cbOther;
    private Button btnSelResult;
    private TextView tvSelResult;
    ArrayList<String> colorSelection = new ArrayList<>();
    private String favColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qstn_three);

        cbRed = (CheckBox) findViewById(R.id.cbRed);
        cbGreen = (CheckBox) findViewById(R.id.cbGreen);
        cbBlue = (CheckBox) findViewById(R.id.cbBlue);
        cbNone = (CheckBox) findViewById(R.id.cbNone);
        cbOther = (CheckBox) findViewById(R.id.cbOther);
        btnSelResult = (Button) findViewById(R.id.btnSelResult);
        tvSelResult = (TextView) findViewById(R.id.tvSelResult);

        cbRed.setOnCheckedChangeListener(this);
        cbGreen.setOnCheckedChangeListener(this);
        cbBlue.setOnCheckedChangeListener(this);
        cbNone.setOnCheckedChangeListener(this);
        cbOther.setOnCheckedChangeListener(this);

        btnSelResult.setOnClickListener(this);
    }

    public void displayToast(String checkBoxName){
        Toast.makeText(this, checkBoxName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.cbRed:
                if(isChecked){
                    cbNone.setChecked(false);
                    cbOther.setChecked(false);

                    colorSelection.add(cbRed.getText().toString());
                }else {
                    colorSelection.remove(cbRed.getText().toString());
                }
                break;
            case R.id.cbGreen:
                if(isChecked){
                    cbNone.setChecked(false);
                    cbOther.setChecked(false);

                    colorSelection.add(cbGreen.getText().toString());
                }else {
                    colorSelection.remove(cbGreen.getText().toString());
                }
                break;
            case R.id.cbBlue:
                if(isChecked){
                    cbNone.setChecked(false);
                    cbOther.setChecked(false);

                    colorSelection.add(cbBlue.getText().toString());
                }else {
                    colorSelection.remove(cbBlue.getText().toString());
                }
                break;
            case R.id.cbNone:
                if(isChecked){
                    cbRed.setChecked(false);
                    cbGreen.setChecked(false);
                    cbBlue.setChecked(false);
                    cbOther.setChecked(false);

//                    colorSelection.remove(cbRed.getText().toString());
//                    colorSelection.remove(cbGreen.getText().toString());
//                    colorSelection.remove(cbBlue.getText().toString());

                    colorSelection.clear();
                }else {

                }
                break;
            case R.id.cbOther:
                if(isChecked){
                    cbNone.setChecked(false);
                    otherInputOption();
                }else {
                    colorSelection.remove(favColor);
                }
                break;
            default:
                break;
        }
    }

    public void finalSelection(){
        String allSelectedColors = "";

        for(String finalColorSel : colorSelection){
            allSelectedColors = allSelectedColors + finalColorSel + "\n";
        }

        tvSelResult.setText(allSelectedColors);
    }

    @Override
    public void onClick(View v) {
        finalSelection();
    }

    public void otherInputOption(){
        // Creating alert Dialog with one Button
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // Setting Dialog Title
        alertDialog.setTitle("Favourite color");

        // Setting Dialog Message
        alertDialog.setMessage("Which color do you like?");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.mipmap.ic_launcher_round);

        final EditText input = new EditText(this);
        input.setSingleLine(true);
        alertDialog.setView(input);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("Save",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        // Write your code here to execute after dialog
                        favColor = input.getText().toString();
                        colorSelection.add(favColor);
                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("Discard",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        dialog.cancel();
                    }
                });

        // Showing Alert Message
        alertDialog.show();

    }
}
