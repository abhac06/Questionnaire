package com.androidpractice.abha.questionnaire;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.androidpractice.abha.questionnaire.helper.Util;

import java.util.ArrayList;
import java.util.List;

public class QstnTwoActivity extends AppCompatActivity {

    private Toolbar toolbarQstnTwo;
    private Util util;
    private ListView lvAnsTwoOptions;
    String[] ansTwoOptions = {"Red", "Green", "Blue"};
    ArrayList<String> selectedOptions = new ArrayList<>();
    private Button btnShowAnsTwo;
    private RadioGroup rgColor;
    private RadioButton rbOneOrMore, rbNone, rbOther;
    private String selectedOption;
    private CheckedTextView chkTvQstnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qstn_two);

        util = new Util(this);

        toolbarQstnTwo = (Toolbar) findViewById(R.id.toolbarQstnTwo);
        lvAnsTwoOptions = (ListView) findViewById(R.id.lvAnsTwoOptions);
        btnShowAnsTwo = (Button) findViewById(R.id.btnShowAnsTwo);
        rgColor = (RadioGroup) findViewById(R.id.rgColor);
        rbOneOrMore = (RadioButton) findViewById(R.id.rbOneOrMore);
        rbNone = (RadioButton) findViewById(R.id.rbNone);
        rbOther = (RadioButton) findViewById(R.id.rbOther);


        setSupportActionBar(toolbarQstnTwo);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvAnsTwoOptions.setEnabled(false);
        lvAnsTwoOptions.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ansTwoOptions);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.qstn_two_row_layout, ansTwoOptions);
//        chkTvQstnTwo = (CheckedTextView) findViewById(R.id.chkTvQstnTwo);

        lvAnsTwoOptions.setAdapter(adapter);


        lvAnsTwoOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedOption = ((TextView)view).getText().toString();
                if(selectedOptions.contains(selectedOption)){
                    selectedOptions.remove(selectedOption); // uncheck item
                } else {
                    selectedOptions.add(selectedOption);
                }
            }
        });

        btnShowAnsTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedOptions.isEmpty()){
                    showSelectedItems();
                }else {
                    util.displayToast("Please select your answer");
                }
            }
        });

        rgColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId){
                    case R.id.rbOneOrMore:
                        util.displayToast(getString(R.string.one_or_more_of_these));
                        lvAnsTwoOptions.setEnabled(true);
                        break;
                    case R.id.rbNone:
                        util.displayToast(getString(R.string.none_of_the_above));
//                        lvAnsTwoOptions.clearChoices();
                        selectedOptions.clear();
//                        selectedOption = "";
//                        chkTvQstnTwo.setText("");
//                        chkTvQstnTwo.setChecked(false);
                        lvAnsTwoOptions.setEnabled(false);
                        lvAnsTwoOptions.setEnabled(false);
                        break;
                    case R.id.rbOther:
                        util.displayToast(getString(R.string.other));
//                        lvAnsTwoOptions.clearChoices();
                        selectedOptions.clear();
//                        selectedOption = "";
//                        chkTvQstnTwo.setText("");
//                        chkTvQstnTwo.setChecked(false);
                        lvAnsTwoOptions.setEnabled(false);
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void showSelectedItems(){
        String items = "";
        for(String item:selectedOptions){
            items = items + "- " + item + "\n";
        }

        util.displayToast(items);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app_bar, menu);
        MenuItem menuItem1 = menu.findItem(android.R.id.home);
        MenuItem menuItem2 = menu.findItem(R.id.action_next);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                startActivity(new Intent(this, QstnOneActivity.class));
                break;
            case R.id.action_next:
                startActivity(new Intent(this, QstnThreeActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
