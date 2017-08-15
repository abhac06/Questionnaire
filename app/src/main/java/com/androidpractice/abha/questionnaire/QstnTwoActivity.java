package com.androidpractice.abha.questionnaire;

import android.content.Intent;
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
import android.widget.ListView;
import android.widget.TextView;

import com.androidpractice.abha.questionnaire.helper.Util;

import java.util.ArrayList;
import java.util.List;

public class QstnTwoActivity extends AppCompatActivity {

    private Toolbar toolbarQstnTwo;
    private Util util;
    private ListView lvAnsTwoOptions;
    String[] ansTwoOptions = {"Red", "Green", "None of the above", "Other"};
    ArrayList<String> selectedOptions = new ArrayList<>();
    private Button btnShowAnsTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qstn_two);

        util = new Util(this);

        toolbarQstnTwo = (Toolbar) findViewById(R.id.toolbarQstnTwo);
        lvAnsTwoOptions = (ListView) findViewById(R.id.lvAnsTwoOptions);
        btnShowAnsTwo = (Button) findViewById(R.id.btnShowAnsTwo);

        setSupportActionBar(toolbarQstnTwo);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvAnsTwoOptions.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ansTwoOptions);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.qstn_two_row_layout, ansTwoOptions);
        lvAnsTwoOptions.setAdapter(adapter);

        lvAnsTwoOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = ((TextView)view).getText().toString();
                if(selectedOptions.contains(selectedOption)){
                    selectedOptions.remove(selectedOption); // uncheck item
                }else {
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
                startActivity(new Intent(this, UserSummaryActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
