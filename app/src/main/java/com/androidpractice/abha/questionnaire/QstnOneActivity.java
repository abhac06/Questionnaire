package com.androidpractice.abha.questionnaire;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.androidpractice.abha.questionnaire.helper.Util;

public class QstnOneActivity extends AppCompatActivity {

    private Toolbar toolbarQstnOne;
    private Util util;
    private RadioGroup rgGender;
    private RadioButton rbMale, rbFemale, rbUnspecified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qstn_one);

        util = new Util(this);

        toolbarQstnOne = (Toolbar) findViewById(R.id.toolbarQstnOne);
        rgGender = (RadioGroup) findViewById(R.id.rgGender);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        rbUnspecified = (RadioButton) findViewById(R.id.rbUnspecified);

        setSupportActionBar(toolbarQstnOne);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rbMale:
                        util.displayToast(getString(R.string.male));
                        break;
                    case R.id.rbFemale:
                        util.displayToast(getString(R.string.female));
                        break;
                    case R.id.rbUnspecified:
                        util.displayToast(getString(R.string.unspecified));
                        break;
                    default:
                        break;
                }
            }
        });
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
//                util.displayToast(item.getTitle().toString());
                startActivity(new Intent(this, MainActivity.class));
//                NavUtils.navigateUpFromSameTask(this);
                break;
            case R.id.action_next:
                util.displayToast(item.getTitle().toString());
                startActivity(new Intent(this, QstnTwoActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
