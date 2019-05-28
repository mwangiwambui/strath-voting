package com.strath.strathvoting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class CandidatesVotingActivity extends AppCompatActivity {
    public static final String EXTRA_POSITION = "position";
    // Creating Toolbar
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidates_voting);
        // Assign ID to Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Tell android to use toolbar as action bar
        setSupportActionBar(toolbar);
        // create back navigation in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // Add text to toolbar
        TextView toolbarTextView = (TextView) findViewById(R.id.toolbarTextView);

        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
    }
}
