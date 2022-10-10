package mage.com.br.mage;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

public class Pontos extends AppCompatActivity {

    Exercicios exercicios = new Exercicios();
    TableRow tableRow;
    TableRow tableRow2;
    TableRow tableRow3;
    TableRow tableRow4;
    TableRow tableRow5;
    TextView acertos;
    TextView erros;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tableRow = (TableRow)findViewById(R.id.tableRow);
        tableRow2 = (TableRow)findViewById(R.id.tableRow2);
        tableRow3 = (TableRow)findViewById(R.id.tableRow3);
        tableRow4 = (TableRow)findViewById(R.id.tableRow4);
        tableRow5 = (TableRow)findViewById(R.id.tableRow5);
        acertos = (TextView)findViewById(R.id.acertos);
        erros = (TextView)findViewById(R.id.erros);
        textView = (TextView)findViewById(R.id.textView);


        if(exercicios.acerto == 20){
            textView.setText("Parabéns!");
            acertos.setText("Acertou: " + exercicios.acerto);
            erros.setText("Errou: " + exercicios.erro);
            tableRow.setVisibility(View.VISIBLE);
        }
        else if((exercicios.acerto >= 16)&&(exercicios.acerto <=19)){
            textView.setText("Muito bem!");
            acertos.setText("Acertou: " + exercicios.acerto);
            erros.setText("Errou: " + exercicios.erro);
            tableRow2.setVisibility(View.VISIBLE);
        }
        else if((exercicios.acerto >= 11)&&(exercicios.acerto <=15)){
            textView.setText("Legal!, continue estudando");
            acertos.setText("Acertou: " + exercicios.acerto);
            erros.setText("Errou: " + exercicios.erro);
            tableRow3.setVisibility(View.VISIBLE);
        }
        else if((exercicios.acerto >= 6)&&(exercicios.acerto <=10)){
            textView.setText("Ok!, continue estudando");
            acertos.setText("Acertou: " + exercicios.acerto);
            erros.setText("Errou: " + exercicios.erro);
            tableRow4.setVisibility(View.VISIBLE);
        }
        else if((exercicios.acerto >= 0)&&(exercicios.acerto <=5)){
            textView.setText("Não desista!, continue estudando");
            acertos.setText("Acertou: " + exercicios.acerto);
            erros.setText("Errou: " + exercicios.erro);
            tableRow5.setVisibility(View.VISIBLE);
        }
    }

    public void onBackPressed() {
        exercicios.acerto = 0;
        exercicios.erro = 0;
        startActivity(new Intent(this, Home.class));
        finish();

        return;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        exercicios.acerto = 0;
        exercicios.erro = 0;
        startActivity(new Intent(this, Home.class));
        finish();

        return true;
    }
}
