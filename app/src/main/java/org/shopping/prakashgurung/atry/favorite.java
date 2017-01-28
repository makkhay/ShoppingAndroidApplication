package org.shopping.prakashgurung.atry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.shopping.prakashgurung.atry.R;

import static android.support.v7.appcompat.R.id.image;

public class favorite extends AppCompatActivity {
    int favImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);


        ImageView displayImage = (ImageView) findViewById(R.id.movieImage);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        displayImage.setImageResource(settings.getInt("Favorite", 0));

            Intent intent = getIntent();
            if (intent.hasExtra(Intent.EXTRA_TEXT)) {
                favImage = intent.getIntExtra(Intent.EXTRA_TEXT,image);
                displayImage.setImageResource(favImage);

          }





         }



    }

