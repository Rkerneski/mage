package mage.com.br.mage;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONException;

import java.text.DecimalFormat;

import mage.com.br.mage.Uteis.Uteis;

public class Calcular extends AppCompatActivity {

    EditText txt_m;
    EditText txt_z;
    EditText txt_dp;
    EditText txt_de;
    EditText txt_di;
    EditText txt_c;
    EditText txt_f;
    EditText txt_h;
    EditText txt_p;
    EditText txt_s;
    Button btn_calcular;
    Button btn_limpar;
    TableRow tableRow;
    TableRow tableRow2;
    TableRow tableRow3;
    TableRow tableRow5;
    TableRow tableRow7;
    int m = 0;
    int z = 0;
    int dp = 0;
    float de = 0;
    int di = 0;
    int c = 0;
    int f = 0;
    int h = 0;
    int p = 0;
    int s = 0;
    ImageButton question;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txt_m = (EditText)findViewById(R.id.txt_m);
        txt_z = (EditText)findViewById(R.id.txt_z);
        txt_dp = (EditText)findViewById(R.id.txt_dp);
        txt_de = (EditText)findViewById(R.id.txt_de);
        txt_di = (EditText)findViewById(R.id.txt_di);
        txt_c = (EditText)findViewById(R.id.txt_c);
        txt_f = (EditText)findViewById(R.id.txt_f);
        txt_h = (EditText)findViewById(R.id.txt_h);
        txt_p = (EditText)findViewById(R.id.txt_p);
        txt_s = (EditText)findViewById(R.id.txt_s);
        tableRow = (TableRow)findViewById(R.id.tableRow);
        tableRow2 = (TableRow)findViewById(R.id.tableRow2);
        tableRow3 = (TableRow)findViewById(R.id.tableRow3);
        tableRow5 = (TableRow)findViewById(R.id.tableRow5);
        tableRow7 = (TableRow)findViewById(R.id.tableRow7);
        btn_calcular = (Button)findViewById(R.id.btn_calcular);
        btn_limpar = (Button)findViewById(R.id.btn_limpar);
        question = (ImageButton)findViewById(R.id.question);

        txt_m.setFocusable(false);
        txt_dp.setFocusable(false);
        txt_di.setFocusable(false);
        txt_c.setFocusable(false);
        txt_f.setFocusable(false);
        txt_h.setFocusable(false);
        txt_p.setFocusable(false);
        txt_s.setFocusable(false);

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.setVisibility(View.INVISIBLE);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        question.setVisibility(View.VISIBLE);
                        mensagem();
                    }
                }, 0);

            }
        });

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conferir();

            }
        });

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tableRow2.setVisibility(View.INVISIBLE);
                tableRow3.setVisibility(View.INVISIBLE);
                tableRow5.setVisibility(View.INVISIBLE);
                tableRow7.setVisibility(View.INVISIBLE);
                btn_calcular.setVisibility(View.VISIBLE);
                btn_limpar.setVisibility(View.INVISIBLE);
                question.setVisibility(View.VISIBLE);

                txt_de.setText(null);
                txt_z.setText(null);

                if (false) {
                    txt_de.setFocusable(false);
                    txt_z.setFocusable(false);
                }
                else{
                    txt_de.setFocusableInTouchMode(true);
                    txt_z.setFocusableInTouchMode(true);
                }
            }
        });
    }

    public void conferir(){
        if (txt_de.getText().toString().trim().equals("") ||txt_z.getText().toString().trim().equals("")) {
            Uteis.Alert(this, this.getString(R.string.conferir));
            //this.editTextNome.requestFocus();
        }
        else {
            DecimalFormat df = new DecimalFormat("###,###0.000");//usar para formar os valores de double
            if (txt_de.getText() != df) {
                try {
                    //

                    //txt_de.setText(String.valueOf(df.format(de)));

                    de = Float.parseFloat(txt_de.getText().toString());
                    z = Integer.parseInt(txt_z.getText().toString());

                    //APAGA O TECLADO QUANDO PESQUISAR
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                    tableRow2.setVisibility(View.VISIBLE);
                    tableRow3.setVisibility(View.VISIBLE);
                    tableRow5.setVisibility(View.VISIBLE);
                    tableRow7.setVisibility(View.VISIBLE);
                    btn_calcular.setVisibility(View.INVISIBLE);
                    btn_limpar.setVisibility(View.VISIBLE);

                    txt_de.setFocusable(false);
                    txt_z.setFocusable(false);

                    resultado();
                    question.setVisibility(View.INVISIBLE);

                }catch(Exception e) {
                    e.printStackTrace();
                    Uteis.Alert(this, this.getString(R.string.dia));
                }
            }

        }

    }

    public void resultado(){

        DecimalFormat df = new DecimalFormat("###,###0.000");//usar para formar os valores de double

        //calcula modulo
        double mm = z + 2;
        double m = de/mm;
        txt_m.setText(String.valueOf(df.format(m)));

        //calcula altura do dente
        double r = 2.166;
        double H = (r * m);
        txt_h.setText(String.valueOf(df.format(H)));

        //calcula altura do pé do dente
        double auxF = (1.166 * m);
        txt_f.setText(String.valueOf(df.format(auxF)));

        //calcula passo
        double pi = 3.14 * m;
        txt_p.setText(String.valueOf(df.format(pi)));

        //calcula a cabeça do dente
        //sempre vai ser igual ao nº do modulo f: 1 X m
        txt_c.setText(String.valueOf(df.format(m)));

        //calcula espessura do dente
        double espe = 1.57 * m;
        txt_s.setText(String.valueOf(df.format(espe)));

        //calcula diametro primitivo
        double dp = m * z;
        txt_dp.setText(String.valueOf(df.format(dp)));

        //calcula diamentro interno
        double Di = dp - (2 * 1.166 * m);

        if(Di < 0){
            double x = Di * (- 1);
            txt_di.setText(String.valueOf(df.format(x)));
        }else{
            txt_di.setText(String.valueOf(df.format(Di)));
        }
    }

    public void mensagem(){
        Uteis.Alert(this, this.getString(R.string.calcular));
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
