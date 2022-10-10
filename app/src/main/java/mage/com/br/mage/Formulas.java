package mage.com.br.mage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Formulas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
