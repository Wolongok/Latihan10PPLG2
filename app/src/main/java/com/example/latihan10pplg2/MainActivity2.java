package com.example.latihan10pplg2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView hasilTextView;
    EditText angka1EditText;
    EditText angka2EditText;
    Spinner operatorSpinner;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalkulator);

        // konek layout
        angka1EditText = findViewById(R.id.angka1);
        angka2EditText = findViewById(R.id.angka2);
        operatorSpinner = findViewById(R.id.Spinner);
        calculateButton = findViewById(R.id.button);
        hasilTextView = findViewById(R.id.hasil);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operatorSpinner.setAdapter(adapter);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }


    private void calculate() {
        String angka1Str = angka1EditText.getText().toString();
        String angka2Str = angka2EditText.getText().toString();

        if (angka1Str.isEmpty() || angka2Str.isEmpty()) {
            Toast.makeText(this, "Please enter numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double angka1 = Double.parseDouble(angka1Str);
        double angka2 = Double.parseDouble(angka2Str);
        String operator = operatorSpinner.getSelectedItem().toString();

        double result = 0;
        switch (operator) {
            case "Tambah":
                result = angka1 + angka2;
                break;
            case "Kurang":
                result = angka1 - angka2;
                break;
            case "Kali":
                result = angka1 * angka2;
                break;
            case "Bagi":
                if (angka2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = angka1 / angka2;
                break;
        }

        // Display the result
        hasilTextView.setText("Result : " + Double.toString(result));
    }
}