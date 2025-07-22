package com.example.orient1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.exit_dialog1, null);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(false)
                .create();

        Button btnYes = dialogView.findViewById(R.id.btnYes);
        Button btnNo = dialogView.findViewById(R.id.btnNo);

        btnYes.setOnClickListener(v -> {
            dialog.dismiss();
//            super.onBackPressed(); // or
         finishAffinity();
        });

        btnNo.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btnOne = findViewById(R.id.btnOne);
        Button btnTwo = findViewById(R.id.btnTwo);
        Button btnthree = findViewById(R.id.btnThree);
        ImageButton btnAbout = findViewById(R.id.aboutButton); // Make sure this ID matches the XML

        // Button 1 - Navigate to Lessons Module
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, lessons_module.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        // Button 2 - Navigate to Quiz Module
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, quiz_module.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        // ImageButton - Navigate to About Activity
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, about.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

        });
        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, arselection.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

        });

    }
}
