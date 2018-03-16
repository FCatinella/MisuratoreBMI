package com.mirothan.bmi.misuratorebmi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText altezza,peso;
    private Button calcola;
    private TextView risultato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Modificato da me
        altezza=(EditText)findViewById(R.id.boxAltezza);
        peso= (EditText) findViewById(R.id.boxPeso);
        calcola = (Button) findViewById(R.id.calcolaButton);
        risultato= (TextView) findViewById(R.id.risultato);

        calcola.setOnClickListener(this);
        calcola.setEnabled(true);
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public void onClick(View v){
            if (v == calcola) {
                double PESO = Double.parseDouble(peso.getText().toString());
                double ALT = Double.parseDouble(altezza.getText().toString());
                double BMI = PESO / (ALT * ALT);
                if(BMI<16.5){
                    risultato.setText(String.format("Sottopeso di grado severo : %2.1f",BMI));
                }
                else if(BMI<18.4) {
                    risultato.setText(String.format("Sottopeso : %2.1f", BMI));
                } else if(BMI<24.9){
                    risultato.setText(String.format("Normale : %2.1f",BMI));
                }
                else if(BMI<30){
                    risultato.setText(String.format("Obesità di primo grado : %2.1f",BMI));
                }
                else if(BMI<34.9){
                    risultato.setText(String.format("Obesità di secondo grado : %2.1f",BMI));
                }
                else if(BMI>40){
                    risultato.setText(String.format("Obesità di terzo grado : %2.1f",BMI));
                }

            }
    }


    public void displayInfo(View v){
        Intent infoIntent = new Intent(this, infoActivity.class);
        startActivity(infoIntent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
