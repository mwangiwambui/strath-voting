package com.strath.strathvoting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProfileActivity extends AppCompatActivity {
    // Creating button.
    Button logout ;

    // Creating TextView.
    TextView userEmailShow ;

    //Creating card view
    CardView card_view;

    // Creating FirebaseAuth.
    FirebaseAuth firebaseAuth ;

    // Creating FirebaseAuth.
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        // Assigning ID's to button , CardView and TextView.
        logout = (Button)findViewById(R.id.logout);
        userEmailShow = (TextView)findViewById(R.id.user_email);
        card_view = (CardView) findViewById(R.id.voting_card_view);

        // Adding FirebaseAuth instance to FirebaseAuth object.
        firebaseAuth = FirebaseAuth.getInstance();

        // On activity start check whether there is user previously logged in or not.
        if(firebaseAuth.getCurrentUser() == null){

            // Finishing current Profile activity.
            finish();

            // If user already not log in then Redirect to LoginActivity .
            Intent intent = new Intent(UserProfileActivity.this, LoginActivity.class);
            startActivity(intent);

            // Showing toast message.
            Toast.makeText(UserProfileActivity.this, "Please Log in to continue", Toast.LENGTH_LONG).show();

        }

        // Adding firebaseAuth current user info into firebaseUser object.
        firebaseUser = firebaseAuth.getCurrentUser();

        // Getting logged in user email from firebaseUser.getEmail() method and set into TextView.
        userEmailShow.setText("Welcome " + firebaseUser.getEmail());

        //Adding click listener on voting card view
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
            }
        });

        // Adding click listener on logout button.
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Destroying login season.
                firebaseAuth.signOut();

                // Finishing current User Profile activity.
                finish();

                // Redirect to Login Activity after click on logout button.
                Intent intent = new Intent(UserProfileActivity.this, LoginActivity.class);
                startActivity(intent);

                // Showing toast message on logout.
                Toast.makeText(UserProfileActivity.this, "Logged Out Successfully.", Toast.LENGTH_LONG).show();

            }
        });
    }
}
