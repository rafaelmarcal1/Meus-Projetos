package br.edu.ifsp.aplicativoconversordemoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final double DOLLAR_VALUE = 5.8;

    private EditText valueEditText;
    private Button converterDollarbButton;
    private Button converterRealButton;
    private TextView convertedValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valueEditText = findViewById(R.id.edittext_value);
        convertedValueTextView = findViewById(R.id.textview_value_converted);

        converterDollarbButton = findViewById(R.id.button_converter_dollar);
        converterDollarbButton.setOnClickListener(this);

        converterRealButton = findViewById(R.id.button_converter_real);
        converterRealButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == converterDollarbButton){
            getDollarConvertion();
        }
        if(view == converterRealButton){
            getRealConvertion();
        }
    }

    private double getValue(){
        double value;
        String valueString;

        valueString = valueEditText.getText().toString();

        try {
            value = Double.valueOf(valueString);
        }catch (NumberFormatException e){
            Toast.makeText(this, "Valor digitado é inválido.", Toast.LENGTH_SHORT).show();
            value = 0;
        }
        return value;
    }

    private void getRealConvertion() {
        double value = getValue();

        value = value * DOLLAR_VALUE;

        convertedValueTextView.setText(String.format("R$: %.2f", value));
    }

    private void getDollarConvertion() {
        double value = getValue();

        value = value / DOLLAR_VALUE;

        convertedValueTextView.setText(String.format("UDS: %.2f", value));
    }
}