package com.androidpractice.abha.questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.androidpractice.abha.questionnaire.helper.Util;

public class QstnTwoActivity extends AppCompatActivity {

    private Toolbar toolbarQstnTwo;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qstn_two);

        util = new Util(this);

        toolbarQstnTwo = (Toolbar) findViewById(R.id.toolbarQstnTwo);

        setSupportActionBar(toolbarQstnTwo);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                return true;
            case R.id.action_next:
                startActivity(new Intent(this, UserSummaryActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
