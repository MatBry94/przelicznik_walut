package com.example.przelicznik_wlut;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Deklaracja zmiennych dla elementów UI
    private EditText ilePrzeliczycEditText;
    private Button buttonUsd, buttonEur, buttonChf;
    private TextView wynikTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Powiązanie zmiennych z elementami UI
        ilePrzeliczycEditText = findViewById(R.id.ilePrzeliczyć);
        buttonUsd = findViewById(R.id.buttonUsd);
        buttonEur = findViewById(R.id.buttonEur);
        buttonChf = findViewById(R.id.buttonChf);
        wynikTextView = findViewById(R.id.wynik);

        // Ustawienie listenerów dla przycisków
        buttonUsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                przeliczWalute(3.99, "USD");
            }
        });

        buttonEur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                przeliczWalute(4.32, "EUR");
            }
        });

        buttonChf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                przeliczWalute(4.53, "CHF");
            }
        });
    }

    // Metoda do przeliczania waluty
    private void przeliczWalute(double kurs, String waluta) {
        // Sprawdzenie, czy pole tekstowe nie jest puste
        String kwotaStr = ilePrzeliczycEditText.getText().toString();
        if (kwotaStr.isEmpty()) {
            Toast.makeText(this, "Proszę wpisać kwotę do przeliczenia!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Konwersja wprowadzonej wartości na double
            double kwota = Double.parseDouble(kwotaStr);

            // Obliczenie wyniku
            double wynik = kwota * kurs;

            // Wyświetlenie wyniku w TextView
            String wynikTekst = "Po przeliczeniu (" + waluta + " -> PLN): " + String.format("%.2f PLN", wynik);
            wynikTextView.setText(wynikTekst);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Niepoprawny format liczby!", Toast.LENGTH_SHORT).show();
        }
    }
}
