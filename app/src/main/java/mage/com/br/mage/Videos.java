package mage.com.br.mage;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Videos extends AppCompatActivity {

    ImageButton video1;
    ImageButton video2;
    ImageButton video3;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        video1 = (ImageButton)findViewById(R.id.video1);
        video2 = (ImageButton)findViewById(R.id.video2);
        video3 = (ImageButton)findViewById(R.id.video3);

        video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                video1.setVisibility(View.INVISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        video1.setVisibility(View.VISIBLE);

                    }
                }, 0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=OupvaBsKmQ0"));

                startActivity(intent);

            }
        });

        video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                video2.setVisibility(View.INVISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        video2.setVisibility(View.VISIBLE);

                    }
                }, 0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/embed/RCMsTK8q0eg"));

                startActivity(intent);

            }
        });

        video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                video3.setVisibility(View.INVISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        video3.setVisibility(View.VISIBLE);

                    }
                }, 0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/embed/9_WImndYS2A"));

                startActivity(intent);

            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent(this, Home.class));
        finish();

        return;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {

        startActivity(new Intent(this, Home.class));
        finish();

        return true;
    }
}
