package mage.com.br.mage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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

import java.text.DecimalFormat;
import java.util.Random;

import mage.com.br.mage.Uteis.Uteis;

public class Exercicios extends AppCompatActivity {

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
    Button conferir;
    EditText aux_2;
    EditText aux_1;
    EditText aux_3;
    TextView acertos;
    TextView erros;
    TextView respostas;
    TextView txt_1;
    TextView txt_2;
    TextView txt_3;
    EditText aux_5;
    TextView txt_5;
    EditText aux_4;
    TextView txt_4;
    TextView txt_6;
    EditText aux_6;
    TextView txt_7;
    EditText aux_7;
    TextView txt_8;
    EditText aux_8;
    TableRow tableRow10;
    int m = 0;
    int z = 0;
    int dp = 0;
    int de = 0;
    int di = 0;
    int c = 0;
    int f = 0;
    int h = 0;
    int p = 0;
    int s = 0;
    public static int acerto = 0;
    public static int erro = 0;
    TableRow tableRow8;
    TableRow tableRow9;
    int mProgressStatus = 0;
    ProgressBar progressBar;
    TextView contador;
    int proximo = 0;
    ImageButton image_funcao;
    Handler mHandler = new Handler();
    int confere = 0;
    Handler handler = new Handler();
    ImageButton question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);

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
        conferir = (Button)findViewById(R.id.conferir);
        aux_2 = (EditText)findViewById(R.id.aux_2);
        aux_1 = (EditText)findViewById(R.id.aux_1);
        aux_3 = (EditText)findViewById(R.id.aux_3);
        acertos = (TextView) findViewById(R.id.acertos);
        erros = (TextView) findViewById(R.id.erros);
        respostas = (TextView) findViewById(R.id.respostas);
        tableRow8 = (TableRow)findViewById(R.id.tableRow8);
        tableRow9 = (TableRow)findViewById(R.id.tableRow9);
        tableRow10 = (TableRow)findViewById(R.id.tableRow10);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        contador = (TextView)findViewById(R.id.contador);
        txt_1 = (TextView) findViewById(R.id.txt_1);
        txt_2 = (TextView) findViewById(R.id.txt_2);
        txt_3 = (TextView) findViewById(R.id.txt_3);
        aux_5 = (EditText)findViewById(R.id.aux_5);
        txt_5 = (TextView) findViewById(R.id.txt_5);
        aux_4 = (EditText)findViewById(R.id.aux_4);
        txt_4 = (TextView) findViewById(R.id.txt_4);
        txt_6 = (TextView) findViewById(R.id.txt_6);
        aux_6 = (EditText)findViewById(R.id.aux_6);
        txt_7 = (TextView) findViewById(R.id.txt_7);
        aux_7 = (EditText)findViewById(R.id.aux_7);
        txt_8 = (TextView) findViewById(R.id.txt_8);
        aux_8 = (EditText)findViewById(R.id.aux_8);
        image_funcao = (ImageButton)findViewById(R.id.image_funcao);
        question = (ImageButton)findViewById(R.id.question);

        txt_m.setFocusable(false);
        txt_z.setFocusable(false);
        txt_dp.setFocusable(false);
        txt_de.setFocusable(false);
        txt_c.setFocusable(false);
        txt_f.setFocusable(false);
        txt_p.setFocusable(false);
        aux_3.setFocusable(false);
        aux_1.setFocusable(false);
        aux_2.setFocusable(false);
        aux_5.setFocusable(false);
        aux_4.setFocusable(false);
        aux_6.setFocusable(false);
        aux_7.setFocusable(false);
        aux_8.setFocusable(false);

        txt_di.setTextColor(Color.BLACK);
        txt_h.setTextColor(Color.BLACK);
        txt_s.setTextColor(Color.BLACK);

        dosomething();

        Random random = new Random();
        m = random.nextInt(10)+2;
        z = random.nextInt(10)+2;
        DecimalFormat df = new DecimalFormat("###,###0.000");//usar para formar os valores de double

        //pega os numeros do random
        txt_m.setText(String.valueOf(m).toString());
        txt_z.setText(String.valueOf(z).toString());

        //calcula o de
        int aux = z + 2;
        int de = m * aux;
        txt_de.setText(String.valueOf(de));

        //calcula altura do dente
        double r = 2.166;
        double H = (r * m);
        aux_2.setText(String.valueOf(df.format(H)));

        //calcula altura do pé do dente
        double auxF = (1.166 * m);
        txt_f.setText(String.valueOf(df.format(auxF)));

        //calcula passo
        double pi = 3.14 * m;
        txt_p.setText(String.valueOf(df.format(pi)));

        //calcula a cabeça do dente
        //sempre vai ser igual ao nº do modulo f: 1 X m
        txt_c.setText(String.valueOf(m));

        //calcula espessura do dente
        double espe = 1.57 * m;
        aux_3.setText(String.valueOf(df.format(espe)));

        //calcula diametro primitivo
        int dp = m * z;
        txt_dp.setText(String.valueOf(dp));

        //calcula diamentro interno
        double Di = dp - (2 * 1.166 * m);

        if(Di < 0){
            double x = Di * (- 1);
            aux_1.setText(String.valueOf(df.format(x)));
        }else{
            aux_1.setText(String.valueOf(df.format(Di)));
        }

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


        image_funcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                image_funcao.setVisibility(View.INVISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image_funcao.setVisibility(View.VISIBLE);

                    }
                }, 0);

                if(proximo == 0){
                    Random random = new Random();
                    m = random.nextInt(10)+2;
                    z = random.nextInt(10)+2;
                    DecimalFormat df = new DecimalFormat("###,###0.000");//usar para formar os valores de double

                    //pega os numeros do random
                    txt_m.setText(String.valueOf(m).toString());
                    txt_z.setText(String.valueOf(z).toString());

                    //calcula o de
                    int aux = z + 2;
                    int de = m * aux;
                    txt_de.setText(String.valueOf(de));

                    //calcula altura do dente
                    double r = 2.166;
                    double H = (r * m);
                    aux_2.setText(String.valueOf(df.format(H)));

                    //calcula altura do pé do dente
                    double auxF = (1.166 * m);
                    txt_f.setText(String.valueOf(df.format(auxF)));

                    //calcula passo
                    double pi = 3.14 * m;
                    txt_p.setText(String.valueOf(df.format(pi)));

                    //calcula a cabeça do dente
                    //sempre vai ser igual ao nº do modulo f: 1 X m
                    txt_c.setText(String.valueOf(m));

                    //calcula espessura do dente
                    double espe = 1.57 * m;
                    aux_3.setText(String.valueOf(df.format(espe)));

                    //calcula diametro primitivo
                    int dp = m * z;
                    txt_dp.setText(String.valueOf(dp));

                    //calcula diamentro interno
                    double Di = dp - (2 * 1.166 * m);

                    if(Di < 0){
                        double x = Di * (- 1);
                        aux_1.setText(String.valueOf(df.format(x)));
                    }else{
                        aux_1.setText(String.valueOf(df.format(Di)));
                    }
                }
                else if(proximo == 2){

                    Random random = new Random();
                    m = random.nextInt(10)+2;
                    z = random.nextInt(10)+2;
                    DecimalFormat df = new DecimalFormat("###,###0.000");//usar para formar os valores de double

                    //pega os numeros do random
                    txt_m.setText(String.valueOf(m).toString());
                    txt_z.setText(String.valueOf(z).toString());

                    //calcula o de
                    int aux = z + 2;
                    int de = m * aux;
                    aux_2.setText(String.valueOf(de));

                    //calcula altura do dente
                    double r = 2.166;
                    double H = (r * m);
                    txt_h.setText(String.valueOf(df.format(H)));

                    //calcula altura do pé do dente
                    double auxF = (1.166 * m);
                    txt_f.setText(String.valueOf(df.format(auxF)));

                    //calcula passo
                    double pi = 3.14 * m;
                    aux_5.setText(String.valueOf(df.format(pi)));

                    //calcula a cabeça do dente
                    //sempre vai ser igual ao nº do modulo f: 1 X m
                    aux_3.setText(String.valueOf(m));

                    //calcula espessura do dente
                    double espe = 1.57 * m;
                    txt_s.setText(String.valueOf(df.format(espe)));

                    //calcula diametro primitivo
                    int dp = m * z;
                    aux_1.setText(String.valueOf(dp));

                    //calcula diamentro interno
                    double Di = dp - (2 * 1.166 * m);

                    if(Di < 0){
                        double x = Di * (- 1);
                        txt_di.setText(String.valueOf(df.format(x)));
                    }else{
                        txt_di.setText(String.valueOf(df.format(Di)));
                    }
                }
                else if(proximo == 4){
                    Random random = new Random();
                    m = random.nextInt(10)+2;
                    z = random.nextInt(10)+2;
                    DecimalFormat df = new DecimalFormat("###,###0.000");//usar para formar os valores de double

                    //pega os numeros do random
                    txt_m.setText(String.valueOf(m).toString());
                    aux_1.setText(String.valueOf(z).toString());

                    //calcula o de
                    int aux = z + 2;
                    int de = m * aux;
                    aux_2.setText(String.valueOf(de));

                    //calcula altura do dente
                    double r = 2.166;
                    double H = (r * m);
                    aux_4.setText(String.valueOf(df.format(H)));

                    //calcula altura do pé do dente
                    double auxF = (1.166 * m);
                    aux_3.setText(String.valueOf(df.format(auxF)));

                    //calcula passo
                    double pi = 3.14 * m;
                    txt_p.setText(String.valueOf(df.format(pi)));

                    //calcula a cabeça do dente
                    //sempre vai ser igual ao nº do modulo f: 1 X m
                    txt_c.setText(String.valueOf(m));

                    //calcula espessura do dente
                    double espe = 1.57 * m;
                    aux_5.setText(String.valueOf(df.format(espe)));

                    ///calcula diametro primitivo
                    int dp = m * z;
                    txt_dp.setText(String.valueOf(dp));

                    //calcula diamentro interno
                    double Di = dp - (2 * 1.166 * m);

                    if(Di < 0){
                        double x = Di * (- 1);
                        txt_di.setText(String.valueOf(df.format(x)));
                    }else{
                        txt_di.setText(String.valueOf(df.format(Di)));
                    }
                }
                else if(proximo == 6){
                    Random random = new Random();
                    m = random.nextInt(10)+2;
                    z = random.nextInt(10)+2;
                    DecimalFormat df = new DecimalFormat("###,###0.000");//usar para formar os valores de double

                    //pega os numeros do random
                    aux_1.setText(String.valueOf(m).toString());
                    txt_z.setText(String.valueOf(z).toString());

                    //calcula o de
                    int aux = z + 2;
                    int de = m * aux;
                    txt_de.setText(String.valueOf(de));

                    //calcula altura do dente
                    double r = 2.166;
                    double H = (r * m);
                    aux_6.setText(String.valueOf(df.format(H)));

                    //calcula altura do pé do dente
                    double auxF = (1.166 * m);
                    aux_5.setText(String.valueOf(df.format(auxF)));

                    //calcula passo
                    double pi = 3.14 * m;
                    aux_7.setText(String.valueOf(df.format(pi)));

                    //calcula a cabeça do dente
                    //sempre vai ser igual ao nº do modulo f: 1 X m
                    aux_4.setText(String.valueOf(m));

                    //calcula espessura do dente
                    double espe = 1.57 * m;
                    aux_8.setText(String.valueOf(df.format(espe)));

                    ///calcula diametro primitivo
                    int dp = m * z;
                    aux_2.setText(String.valueOf(dp));

                    //calcula diamentro interno
                    double Di = dp - (2 * 1.166 * m);

                    if(Di < 0){
                        double x = Di * (- 1);
                        aux_3.setText(String.valueOf(df.format(x)));
                    }else{
                        aux_3.setText(String.valueOf(df.format(Di)));
                    }
                }

            }
        });

        conferir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conferir();
            }
        });
    }

    public void altura_do_dente(){
        if(proximo == 0){
            if(txt_h.getText().toString().equals(aux_2.getText().toString()) ){
                //Toast.makeText(Exercicios.this, "acertou", Toast.LENGTH_LONG).show();
                txt_h.setTextColor(Color.parseColor("#006400"));
                acerto ++;
            }else{
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_h.setTextColor(Color.RED);
                erro ++;
            }
        }
        else if(proximo == 4){
            if(txt_h.getText().toString().equals(aux_4.getText().toString()) ){
                txt_h.setTextColor(Color.parseColor("#006400"));
                acerto ++;
            }else{
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_h.setTextColor(Color.RED);
                erro ++;
            }
        }
        else if(proximo == 6){
            if(txt_h.getText().toString().equals(aux_6.getText().toString()) ){
                txt_h.setTextColor(Color.parseColor("#006400"));
                acerto ++;
            }else{
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_h.setTextColor(Color.RED);
                erro ++;
            }
        }
    }

    public void dia_interno(){
        if(proximo == 0){
            if(txt_di.getText().toString().equals(aux_1.getText().toString()) ){
                txt_di.setTextColor(Color.parseColor("#006400"));
                acerto ++;
            }else{
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_di.setTextColor(Color.RED);
                erro ++;
            }
        }
        else if(proximo == 6){
            if(txt_di.getText().toString().equals(aux_3.getText().toString()) ){
                txt_di.setTextColor(Color.parseColor("#006400"));
                acerto ++;
            }else{
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_di.setTextColor(Color.RED);
                erro ++;
            }
        }
    }

    public void espessura_dente(){
       if(proximo == 0){
           if(txt_s.getText().toString().equals(aux_3.getText().toString()) ){
               txt_s.setTextColor(Color.parseColor("#006400"));
               acerto ++;
           }else{
               //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
               txt_s.setTextColor(Color.RED);
               erro ++;
           }
       }
       else if(proximo == 4){
           if(txt_s.getText().toString().equals(aux_5.getText().toString()) ){
               txt_s.setTextColor(Color.parseColor("#006400"));
               acerto ++;
           }else{
               //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
               txt_s.setTextColor(Color.RED);
               erro ++;
           }
       }
       else if(proximo == 6){
           if(txt_s.getText().toString().equals(aux_8.getText().toString()) ){
               txt_s.setTextColor(Color.parseColor("#006400"));
               acerto ++;
           }else{
               //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
               txt_s.setTextColor(Color.RED);
               erro ++;
           }
       }

    }
    public void dia_primitivo(){

        if(proximo == 2){
            if(txt_dp.getText().toString().equals(aux_1.getText().toString()) ){
                txt_dp.setTextColor(Color.parseColor("#006400"));
                acerto ++;
            }else{
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_dp.setTextColor(Color.RED);
                erro ++;
            }
        }
        if(proximo == 6){
            if(txt_dp.getText().toString().equals(aux_2.getText().toString()) ){
                txt_dp.setTextColor(Color.parseColor("#006400"));
                acerto ++;
            }else{
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_dp.setTextColor(Color.RED);
                erro ++;
            }
        }
    }
    public void dia_externo(){
        if(proximo == 2){
            if(txt_de.getText().toString().equals(aux_2.getText().toString()) ){
                txt_de.setTextColor(Color.parseColor("#006400"));
                acerto ++;
            }else{
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_de.setTextColor(Color.RED);
                erro ++;
            }
        }
        if(proximo == 4){
            if(txt_de.getText().toString().equals(aux_2.getText().toString()) ){
                txt_de.setTextColor(Color.parseColor("#006400"));
                acerto ++;
            }else{
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_de.setTextColor(Color.RED);
                erro ++;
            }
        }
    }

    public void cabeca(){
        if(proximo == 2){
            if(txt_c.getText().toString().equals(aux_3.getText().toString()) ){
                txt_c.setTextColor(Color.parseColor("#006400"));
                acerto ++;
            }else{
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_c.setTextColor(Color.RED);
                erro ++;
            }
        }
        else if(proximo == 6){
            if(txt_c.getText().toString().equals(aux_4.getText().toString()) ){
                txt_c.setTextColor(Color.parseColor("#006400"));
                acerto ++;
            }else{
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_c.setTextColor(Color.RED);
                erro ++;
            }
        }
    }
    public void passo() {
       if(proximo == 2){
           if (txt_p.getText().toString().equals(aux_5.getText().toString())) {
               txt_p.setTextColor(Color.parseColor("#006400"));
               acerto++;
           } else {
               //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
               txt_p.setTextColor(Color.RED);
               erro++;
           }
       }
       else if(proximo == 4){
           if (txt_p.getText().toString().equals(aux_5.getText().toString())) {
               txt_p.setTextColor(Color.parseColor("#006400"));
               acerto++;
           } else {
               //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
               txt_p.setTextColor(Color.RED);
               erro++;
           }
       }
       else if(proximo == 6){
           if (txt_p.getText().toString().equals(aux_7.getText().toString())) {
               txt_p.setTextColor(Color.parseColor("#006400"));
               acerto++;
           } else {
               //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
               txt_p.setTextColor(Color.RED);
               erro++;
           }
       }
    }
    public void n_dente() {
        if(proximo == 4){
            if (txt_z.getText().toString().equals(aux_1.getText().toString())) {
                txt_z.setTextColor(Color.parseColor("#006400"));
                acerto++;
            } else {
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_z.setTextColor(Color.RED);
                erro++;
            }
        }
    }
    public void pe_dente() {
        if(proximo == 4){
            if (txt_f.getText().toString().equals(aux_3.getText().toString())) {
                txt_f.setTextColor(Color.parseColor("#006400"));
                acerto++;
            } else {
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_f.setTextColor(Color.RED);
                erro++;
            }
        }
        else if(proximo == 6){
            if (txt_f.getText().toString().equals(aux_5.getText().toString())) {
                txt_f.setTextColor(Color.parseColor("#006400"));
                acerto++;
            } else {
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_f.setTextColor(Color.RED);
                erro++;
            }
        }
    }
    public void modulo() {
         if(proximo == 6){
            if (txt_m.getText().toString().equals(aux_1.getText().toString())) {
                txt_m.setTextColor(Color.parseColor("#006400"));
                acerto++;
            } else {
                //Toast.makeText(Exercicios.this, "errou", Toast.LENGTH_LONG).show();
                txt_m.setTextColor(Color.RED);
                erro++;
            }
        }
    }

    public void conferir(){

        if(confere == 0){
            if (txt_h.getText().toString().trim().equals("") ||txt_di.getText().toString().trim().equals("")|| txt_s.getText().toString().trim().equals("") ||
                    txt_dp.getText().toString().trim().equals("")|| txt_de.getText().toString().trim().equals("")|| txt_c.getText().toString().trim().equals("")
                    || txt_p.getText().toString().trim().equals("")|| txt_z.getText().toString().trim().equals("")|| txt_f.getText().toString().trim().equals("")
                    || txt_m.getText().toString().trim().equals("")) {
                Uteis.Alert(this, this.getString(R.string.conferir));
                //this.editTextNome.requestFocus();
            }
            else if(txt_di.getText().toString().trim().length() < aux_1.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.conta));
            }
            else if(txt_h.getText().toString().trim().length() < aux_2.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.conta));
            }
            else if(txt_s.getText().toString().trim().length() < aux_3.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.conta));
            }
            else{

                exercicio();

            }
        }
            else if(confere == 1){
            exercicio();
        }
        else if(confere == 2){
            if (txt_h.getText().toString().trim().equals("") ||txt_di.getText().toString().trim().equals("")|| txt_s.getText().toString().trim().equals("") ||
                    txt_dp.getText().toString().trim().equals("")|| txt_de.getText().toString().trim().equals("")|| txt_c.getText().toString().trim().equals("")
                    || txt_p.getText().toString().trim().equals("")|| txt_z.getText().toString().trim().equals("")|| txt_f.getText().toString().trim().equals("")
                    || txt_m.getText().toString().trim().equals("")) {
                Uteis.Alert(this, this.getString(R.string.conferir));
                //this.editTextNome.requestFocus();
            }
            else if(txt_dp.getText().toString().trim().length() > aux_1.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.dia_ex));
            }
            else if(txt_de.getText().toString().trim().length() > aux_2.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.dia_ex));
            }
            else if(txt_c.getText().toString().trim().length() > aux_3.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.dia_ex));
            }
            else if(txt_p.getText().toString().trim().length() < aux_4.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.conta));
            }
            else{

                exercicio();

            }
        }
        else if(confere == 3){
            exercicio();
        }
        else if(confere == 4){
            if (txt_h.getText().toString().trim().equals("") ||txt_di.getText().toString().trim().equals("")|| txt_s.getText().toString().trim().equals("") ||
                    txt_dp.getText().toString().trim().equals("")|| txt_de.getText().toString().trim().equals("")|| txt_c.getText().toString().trim().equals("")
                    || txt_p.getText().toString().trim().equals("")|| txt_z.getText().toString().trim().equals("")|| txt_f.getText().toString().trim().equals("")
                    || txt_m.getText().toString().trim().equals("")) {
                Uteis.Alert(this, this.getString(R.string.conferir));
                //this.editTextNome.requestFocus();
            }
            else if(txt_z.getText().toString().trim().length() > aux_1.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.dia_ex));
            }
            else if(txt_de.getText().toString().trim().length() > aux_2.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.dia_ex));
            }
            else if(txt_f.getText().toString().trim().length() < aux_3.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.conta));
            }
            else if(txt_h.getText().toString().trim().length() < aux_4.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.conta));
            }
            else if(txt_s.getText().toString().trim().length() < aux_5.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.conta));
            }
            else{

                exercicio();

            }
        }
        else if(confere == 5){
            exercicio();
        }
        else if(confere == 6){
            if (txt_h.getText().toString().trim().equals("") ||txt_di.getText().toString().trim().equals("")|| txt_s.getText().toString().trim().equals("") ||
                    txt_dp.getText().toString().trim().equals("")|| txt_de.getText().toString().trim().equals("")|| txt_c.getText().toString().trim().equals("")
                    || txt_p.getText().toString().trim().equals("")|| txt_z.getText().toString().trim().equals("")|| txt_f.getText().toString().trim().equals("")
                    || txt_m.getText().toString().trim().equals("")) {
                Uteis.Alert(this, this.getString(R.string.conferir));
                //this.editTextNome.requestFocus();
            }
            else if(txt_m.getText().toString().trim().length() > aux_1.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.dia_ex));
            }
            else if(txt_dp.getText().toString().trim().length() > aux_2.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.dia_ex));
            }
            else if(txt_di.getText().toString().trim().length() < aux_3.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.conta));
            }
            else if(txt_c.getText().toString().trim().length() > aux_4.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.dia_ex));
            }
            else if(txt_f.getText().toString().trim().length() < aux_5.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.conta));
            }
            else if(txt_h.getText().toString().trim().length() < aux_5.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.conta));
            }
            else if(txt_p.getText().toString().trim().length() < aux_5.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.conta));
            }
            else if(txt_s.getText().toString().trim().length() < aux_5.getText().toString().trim().length()){
                Uteis.Alert(this, this.getString(R.string.conta));
            }
            else{

                exercicio();

            }
        }
        else if(confere == 7){
            Intent i = new Intent(Exercicios.this, Pontos.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }
    }

    public void exercicio(){

        if(proximo == 0){

            //APAGA O TECLADO QUANDO PESQUISAR
            InputMethodManager inputMethodManager =  (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

            altura_do_dente();
            dia_interno();
            espessura_dente();

            acertos.setVisibility(View.VISIBLE);
            erros.setVisibility(View.VISIBLE);
            tableRow8.setVisibility(View.VISIBLE);
            respostas.setVisibility(View.VISIBLE);
            image_funcao.setVisibility(View.INVISIBLE);
            question.setVisibility(View.INVISIBLE);

            txt_h.setFocusable(false);
            txt_di.setFocusable(false);
            txt_s.setFocusable(false);

            acertos.setText("Acertos: "+ acerto);
            erros.setText("Erros: " + erro);

            conferir.setText("Próximo");

            proximo = 1;
            confere = 1;

        }
        else if(proximo == 1){

                conferir.setText("Conferir");
                txt_h.setTextColor(Color.BLUE);
                txt_di.setTextColor(Color.BLUE);
                txt_s.setTextColor(Color.BLUE);

                txt_dp.setTextColor(Color.BLACK);
                txt_de.setTextColor(Color.BLACK);
                txt_c.setTextColor(Color.BLACK);
                txt_p.setTextColor(Color.BLACK);

                acertos.setVisibility(View.INVISIBLE);
                erros.setVisibility(View.INVISIBLE);
                tableRow8.setVisibility(View.INVISIBLE);
                respostas.setVisibility(View.INVISIBLE);
                image_funcao.setVisibility(View.VISIBLE);
                question.setVisibility(View.VISIBLE);

                txt_4.setVisibility(View.INVISIBLE);
                aux_4.setVisibility(View.INVISIBLE);
                txt_6.setVisibility(View.INVISIBLE);
                aux_6.setVisibility(View.INVISIBLE);

                dosomething();

                if (false) {
                    txt_dp.setFocusable(false);
                    txt_de.setFocusable(false);
                    txt_c.setFocusable(false);
                    txt_p.setFocusable(false);
                }
                else{
                    txt_dp.setFocusableInTouchMode(true);
                    txt_de.setFocusableInTouchMode(true);
                    txt_c.setFocusableInTouchMode(true);
                    txt_p.setFocusableInTouchMode(true);
                }

                txt_dp.setText(null);
                txt_de.setText(null);
                txt_c.setText(null);
                txt_p.setText(null);

                txt_dp.setHint("?");
                txt_de.setHint("?");
                txt_c.setHint("?");
                txt_p.setHint("?");

                txt_1.setText("DP:");
                txt_2.setText("DE:");
                txt_3.setText("C:");
                txt_4.setText("P:");

                Random random = new Random();
                m = random.nextInt(10)+2;
                z = random.nextInt(10)+2;
                DecimalFormat df = new DecimalFormat("###,###0.000");//usar para formar os valores de double

                //pega os numeros do random
                txt_m.setText(String.valueOf(m).toString());
                txt_z.setText(String.valueOf(z).toString());

                //calcula o de
                int aux = z + 2;
                int de = m * aux;
                aux_2.setText(String.valueOf(de));

                //calcula altura do dente
                double r = 2.166;
                double H = (r * m);
                txt_h.setText(String.valueOf(df.format(H)));

                //calcula altura do pé do dente
                double auxF = (1.166 * m);
                txt_f.setText(String.valueOf(df.format(auxF)));

                //calcula passo
                double pi = 3.14 * m;
                aux_5.setText(String.valueOf(df.format(pi)));

                //calcula a cabeça do dente
                //sempre vai ser igual ao nº do modulo f: 1 X m
                aux_3.setText(String.valueOf(m));

                //calcula espessura do dente
                double espe = 1.57 * m;
                txt_s.setText(String.valueOf(df.format(espe)));

                //calcula diametro primitivo
                int dp = m * z;
                aux_1.setText(String.valueOf(dp));

            //calcula diamentro interno
            double Di = dp - (2 * 1.166 * m);

            if(Di < 0){
                double x = Di * (- 1);
                txt_di.setText(String.valueOf(df.format(x)));
            }else{
                txt_di.setText(String.valueOf(df.format(Di)));
            }

                proximo = 2;
                confere = 2;

        }
        else if(proximo == 2){

            //APAGA O TECLADO QUANDO PESQUISAR
            InputMethodManager inputMethodManager =  (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

            conferir.setText("Próximo");

            txt_dp.setFocusable(false);
            txt_c.setFocusable(false);
            txt_p.setFocusable(false);
            txt_de.setFocusable(false);

            dia_primitivo();
            dia_externo();
            cabeca();
            passo();

            acertos.setVisibility(View.VISIBLE);
            erros.setVisibility(View.VISIBLE);
            tableRow8.setVisibility(View.VISIBLE);
            tableRow9.setVisibility(View.VISIBLE);
            respostas.setVisibility(View.VISIBLE);
            image_funcao.setVisibility(View.INVISIBLE);
            question.setVisibility(View.INVISIBLE);

            acertos.setText("Acertos: "+ acerto);
            erros.setText("Erros: " + erro);

            proximo = 3;
            confere = 3;
        }
        else if (proximo == 3){

            conferir.setText("Conferir");
            txt_dp.setTextColor(Color.BLUE);
            txt_c.setTextColor(Color.BLUE);
            txt_p.setTextColor(Color.BLUE);
            txt_di.setTextColor(Color.BLUE);

            txt_dp.setFocusable(false);
            txt_c.setFocusable(false);
            txt_p.setFocusable(false);

            txt_z.setTextColor(Color.BLACK);
            txt_de.setTextColor(Color.BLACK);
            txt_f.setTextColor(Color.BLACK);
            txt_h.setTextColor(Color.BLACK);
            txt_s.setTextColor(Color.BLACK);

            acertos.setVisibility(View.INVISIBLE);
            erros.setVisibility(View.INVISIBLE);
            tableRow8.setVisibility(View.INVISIBLE);
            respostas.setVisibility(View.INVISIBLE);
            tableRow9.setVisibility(View.INVISIBLE);
            image_funcao.setVisibility(View.VISIBLE);
            question.setVisibility(View.VISIBLE);

            dosomething();

            if (false) {
                txt_z.setFocusable(false);
                txt_de.setFocusable(false);
                txt_f.setFocusable(false);
                txt_h.setFocusable(false);
                txt_s.setFocusable(false);
            }
            else{
                txt_z.setFocusableInTouchMode(true);
                txt_de.setFocusableInTouchMode(true);
                txt_f.setFocusableInTouchMode(true);
                txt_h.setFocusableInTouchMode(true);
                txt_s.setFocusableInTouchMode(true);
            }

            txt_z.setText(null);
            txt_de.setText(null);
            txt_f.setText(null);
            txt_h.setText(null);
            txt_s.setText(null);

            txt_z.setHint("?");
            txt_de.setHint("?");
            txt_f.setHint("?");
            txt_h.setHint("?");
            txt_s.setHint("?");

            txt_1.setText("Z:");
            txt_2.setText("DE:");
            txt_3.setText("F:");
            txt_4.setText("H:");
            txt_5.setText("S:");

            Random random = new Random();
            m = random.nextInt(10)+2;
            z = random.nextInt(10)+2;
            DecimalFormat df = new DecimalFormat("###,###0.000");//usar para formar os valores de double

            //pega os numeros do random
            txt_m.setText(String.valueOf(m).toString());
            aux_1.setText(String.valueOf(z).toString());

            //calcula o de
            int aux = z + 2;
            int de = m * aux;
            aux_2.setText(String.valueOf(de));

            //calcula altura do dente
            double r = 2.166;
            double H = (r * m);
            aux_4.setText(String.valueOf(df.format(H)));

            //calcula altura do pé do dente
            double auxF = (1.166 * m);
            aux_3.setText(String.valueOf(df.format(auxF)));

            //calcula passo
            double pi = 3.14 * m;
            txt_p.setText(String.valueOf(df.format(pi)));

            //calcula a cabeça do dente
            //sempre vai ser igual ao nº do modulo f: 1 X m
            txt_c.setText(String.valueOf(m));

            //calcula espessura do dente
            double espe = 1.57 * m;
            aux_5.setText(String.valueOf(df.format(espe)));

            ///calcula diametro primitivo
            int dp = m * z;
            txt_dp.setText(String.valueOf(dp));

            //calcula diamentro interno
            double Di = dp - (2 * 1.166 * m);

            if(Di < 0){
                double x = Di * (- 1);
                txt_di.setText(String.valueOf(df.format(x)));
            }else{
                txt_di.setText(String.valueOf(df.format(Di)));
            }

            proximo = 4;
            confere = 4;

        } else if (proximo == 4) {

            //APAGA O TECLADO QUANDO PESQUISAR
            InputMethodManager inputMethodManager =  (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

            conferir.setText("Próximo");

            n_dente();
            dia_externo();
            altura_do_dente();
            pe_dente();
            espessura_dente();

            txt_z.setFocusable(false);
            txt_de.setFocusable(false);
            txt_f.setFocusable(false);
            txt_h.setFocusable(false);
            txt_s.setFocusable(false);

            acertos.setVisibility(View.VISIBLE);
            erros.setVisibility(View.VISIBLE);
            tableRow8.setVisibility(View.VISIBLE);
            tableRow9.setVisibility(View.VISIBLE);
            respostas.setVisibility(View.VISIBLE);
            txt_4.setVisibility(View.VISIBLE);
            aux_4.setVisibility(View.VISIBLE);
            image_funcao.setVisibility(View.INVISIBLE);
            question.setVisibility(View.INVISIBLE);
            acertos.setText("Acertos: "+ acerto);
            erros.setText("Erros: " + erro);

            proximo = 5;
            confere = 5;
        }

        else if(proximo == 5){

            conferir.setText("Conferir");
            txt_z.setTextColor(Color.BLUE);
            txt_de.setTextColor(Color.BLUE);

            txt_m.setTextColor(Color.BLACK);
            txt_dp.setTextColor(Color.BLACK);
            txt_di.setTextColor(Color.BLACK);
            txt_c.setTextColor(Color.BLACK);
            txt_f.setTextColor(Color.BLACK);
            txt_h.setTextColor(Color.BLACK);
            txt_p.setTextColor(Color.BLACK);
            txt_s.setTextColor(Color.BLACK);

            acertos.setVisibility(View.INVISIBLE);
            erros.setVisibility(View.INVISIBLE);
            tableRow8.setVisibility(View.INVISIBLE);
            respostas.setVisibility(View.INVISIBLE);
            tableRow9.setVisibility(View.INVISIBLE);
            image_funcao.setVisibility(View.VISIBLE);
            question.setVisibility(View.VISIBLE);
            dosomething();

            if (false) {
                txt_m.setFocusable(false);
                txt_dp.setFocusable(false);
                txt_di.setFocusable(false);
                txt_c.setFocusable(false);
                txt_f.setFocusable(false);
                txt_h.setFocusable(false);
                txt_p.setFocusable(false);
                txt_s.setFocusable(false);
            }
            else{
                txt_m.setFocusableInTouchMode(true);
                txt_dp.setFocusableInTouchMode(true);
                txt_di.setFocusableInTouchMode(true);
                txt_c.setFocusableInTouchMode(true);
                txt_f.setFocusableInTouchMode(true);
                txt_h.setFocusableInTouchMode(true);
                txt_p.setFocusableInTouchMode(true);
                txt_s.setFocusableInTouchMode(true);
            }

            txt_m.setText(null);
            txt_dp.setText(null);
            txt_di.setText(null);
            txt_c.setText(null);
            txt_f.setText(null);
            txt_h.setText(null);
            txt_p.setText(null);
            txt_s.setText(null);

            txt_m.setHint("?");
            txt_dp.setHint("?");
            txt_di.setHint("?");
            txt_c.setHint("?");
            txt_f.setHint("?");
            txt_h.setHint("?");
            txt_p.setHint("?");
            txt_s.setHint("?");

            txt_1.setText("M:");
            txt_2.setText("DP:");
            txt_3.setText("DI:");
            txt_4.setText("C:");
            txt_5.setText("F:");
            txt_6.setText("H:");

            Random random = new Random();
            m = random.nextInt(10)+2;
            z = random.nextInt(10)+2;
            DecimalFormat df = new DecimalFormat("###,###0.000");//usar para formar os valores de double

            //pega os numeros do random
            aux_1.setText(String.valueOf(m).toString());
            txt_z.setText(String.valueOf(z).toString());

            //calcula o de
            int aux = z + 2;
            int de = m * aux;
            txt_de.setText(String.valueOf(de));

            //calcula altura do dente
            double r = 2.166;
            double H = (r * m);
            aux_6.setText(String.valueOf(df.format(H)));

            //calcula altura do pé do dente
            double auxF = (1.166 * m);
            aux_5.setText(String.valueOf(df.format(auxF)));

            //calcula passo
            double pi = 3.14 * m;
            aux_7.setText(String.valueOf(df.format(pi)));

            //calcula a cabeça do dente
            //sempre vai ser igual ao nº do modulo f: 1 X m
            aux_4.setText(String.valueOf(m));

            //calcula espessura do dente
            double espe = 1.57 * m;
            aux_8.setText(String.valueOf(df.format(espe)));

            ///calcula diametro primitivo
            int dp = m * z;
            aux_2.setText(String.valueOf(dp));

            //calcula diamentro interno
            double Di = dp - (2 * 1.166 * m);

            if(Di < 0){
                double x = Di * (- 1);
                aux_3.setText(String.valueOf(df.format(x)));
            }else{
                aux_3.setText(String.valueOf(df.format(Di)));
            }

            proximo = 6;
            confere = 6;

        }
        else if(proximo == 6){
            //APAGA O TECLADO QUANDO PESQUISAR
            InputMethodManager inputMethodManager =  (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

            conferir.setText("Fim");

            modulo();
            dia_primitivo();
            dia_interno();
            cabeca();
            altura_do_dente();
            pe_dente();
            passo();
            espessura_dente();

            txt_m.setFocusable(false);
            txt_dp.setFocusable(false);
            txt_di.setFocusable(false);
            txt_c.setFocusable(false);
            txt_f.setFocusable(false);
            txt_h.setFocusable(false);
            txt_p.setFocusable(false);
            txt_s.setFocusable(false);

            acertos.setVisibility(View.VISIBLE);
            erros.setVisibility(View.VISIBLE);
            tableRow8.setVisibility(View.VISIBLE);
            tableRow9.setVisibility(View.VISIBLE);
            tableRow10.setVisibility(View.VISIBLE);
            respostas.setVisibility(View.VISIBLE);
            image_funcao.setVisibility(View.INVISIBLE);
            question.setVisibility(View.INVISIBLE);
            txt_4.setVisibility(View.VISIBLE);
            aux_4.setVisibility(View.VISIBLE);
            txt_6.setVisibility(View.VISIBLE);
            aux_6.setVisibility(View.VISIBLE);

            acertos.setText("Acertos: "+ acerto);
            erros.setText("Erros: " + erro);

            proximo = 7;
            confere = 7;
        }
    }

    public void dosomething() {

        new Thread(new Runnable() {
            public void run() {
                final int presentage=0;

                mProgressStatus += 1;
                // Update the progress bar
                mHandler.post(new Runnable() {
                    public void run() {
                        progressBar.setProgress(mProgressStatus);
                        contador.setText(String.valueOf(mProgressStatus)+" de 4");
                    }
                });
                try {

                    Thread.sleep(50);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void mensagem(){
        Uteis.Alert(this, this.getString(R.string.exercicio));
    }

    public void onBackPressed() {
        acerto = 0;
        erro = 0;
        startActivity(new Intent(this, Home.class));
        finish();

        return;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        acerto = 0;
        erro = 0;
        startActivity(new Intent(this, Home.class));
        finish();

        return true;
    }
}
