package com.example.orient1;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SnP extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sn_p);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("android.resource://" + getPackageName() + "/" + R.drawable.compsec1);
        arrayList.add("android.resource://" + getPackageName() + "/" + R.drawable.comspsec2);

        ImageAdapter adapter = new ImageAdapter(SnP.this, arrayList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ImageAdapter.OnItemClickListener() {
            @Override
            public void onClick(ImageView imageView, String path) {
                startActivity(new Intent(SnP.this, ImageViewActivity.class).putExtra("image", path), ActivityOptions.makeSceneTransitionAnimation(SnP.this, imageView, "image").toBundle());
            }
        });


        TextView description = findViewById(R.id.descriptionText);
        String htmlText = "<b>Saint Dominic, OP</b> (Spanish: Santo Domingo; 8 August 1170 – 6 August 1221), " +
                "also known as <b>Dominic de Guzmán</b>, was a Castilian Catholic priest and the founder of the Dominican Order.";
        description.setText(Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY));

        TextView description1 = findViewById(R.id.descriptionText1);
        String htmlText1 = " Last commencement exercises, <b> March 1973 </b> ,Religious Missionaries St. Dominic.";
        description1.setText(Html.fromHtml(htmlText1, Html.FROM_HTML_MODE_LEGACY));

        TextView description2 = findViewById(R.id.bishopSisonDescription);
        String htmlText2 = " <b>Bishop Jesus J. Sison</b> became the pastor of Bonuan, \n" +
                "Pangasinan in 1943 and was named bishop of the newly erected diocese of Tarlac in 1963. \n" +
                "During his tenure as bishop, \n" +
                "he worked tirelessly to improve the Catholic education of his flock. \n" +
                "After his retirement in 1988, \n" +
                "he moved to America";
        description2.setText(Html.fromHtml(htmlText2, Html.FROM_HTML_MODE_LEGACY));

        TextView description3 = findViewById(R.id.descriptionText3);
        String htmlText3 = " Bachelor of Arts courses and Computer\n" +
                "Secretarial are offered in this year";
        description3.setText(Html.fromHtml(htmlText3, Html.FROM_HTML_MODE_LEGACY));


        // Home button - goes to MainActivity with animation
        ImageButton homeButton = findViewById(R.id.btnHome);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(SnP.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        });

        // Back button - goes to previous page with reverse animation
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }

}