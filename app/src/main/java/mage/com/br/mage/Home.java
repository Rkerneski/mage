package mage.com.br.mage;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    Handler handler = new Handler();
    Button btn_exercicio;
    Button btn_calcular;
    Button btn_formulas;
    Button btn_videos;
    ImageButton facear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        btn_exercicio = (Button)findViewById(R.id.btn_exercicio);
        btn_calcular = (Button)findViewById(R.id.btn_calcular);
        btn_formulas = (Button)findViewById(R.id.btn_formulas);
        btn_videos = (Button)findViewById(R.id.btn_videos);
        facear = (ImageButton)findViewById(R.id.facear);

        facear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                facear.setVisibility(View.INVISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        facear.setVisibility(View.VISIBLE);

                    }
                }, 0);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://unifacear.edu.br"));

                startActivity(intent);

            }
        });

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_calcular.setVisibility(View.INVISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn_calcular.setVisibility(View.VISIBLE);

                    }
                }, 0);

                Intent i = new Intent(Home.this, Calcular.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });


        btn_exercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_exercicio.setVisibility(View.INVISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn_exercicio.setVisibility(View.VISIBLE);

                    }
                }, 0);

                        Intent i = new Intent(Home.this, Exercicios.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                        finish();
            }
        });

        btn_formulas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_formulas.setVisibility(View.INVISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn_formulas.setVisibility(View.VISIBLE);

                    }
                }, 0);

                Intent i = new Intent(Home.this, Formulas.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        btn_videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_videos.setVisibility(View.INVISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn_videos.setVisibility(View.VISIBLE);

                    }
                }, 0);

                Intent i = new Intent(Home.this, Videos.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });
    }
}
