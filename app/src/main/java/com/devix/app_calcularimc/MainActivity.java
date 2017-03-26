package com.devix.app_calcularimc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtPeso;
    private TextView txtAltura;
    private EditText edtPeso;
    private EditText edtAltura;
    private Button btnCalcular;
    public static double totallez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtPeso = (TextView) findViewById(R.id.txtPeso);
        txtAltura = (TextView) findViewById(R.id.txtEstatura);
        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtAltura = (EditText) findViewById(R.id.edtEstatura);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tuPeso = edtPeso.getText().toString();
                String tuEstatura = edtAltura.getText().toString();


                if (tuEstatura.length() == 0 || tuPeso.length() == 0) {
                    Toast.makeText(MainActivity.this, "No ingresaste ningun valor ", Toast.LENGTH_SHORT).show();

                } else {
                    Double convertPeso = Double.parseDouble(tuPeso);
                    Double convertEstatura = Double.parseDouble(tuEstatura);

                    calcularIMC(convertPeso, convertEstatura);

                    System.out.println("VALOR FINAL " + totallez);
                }

            }
        });


    }

    public double calcularIMC(double peso, double estatura) {

        double suPeso = 0;
        double suEstatura = 0;
        double total = 0;
        if (peso > 0 && estatura > 0) {

            System.out.println("Valor PESO " + peso);
            System.out.println("Valor ESTATURA " + estatura);

            suPeso = peso;
            suEstatura = estatura * estatura;

            total = suPeso / suEstatura;

            Toast.makeText(this, "VALOR IMC " + total, Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this, "Ingresa valores validos ", Toast.LENGTH_SHORT).show();
        }
        return totallez = total;

    }
}
