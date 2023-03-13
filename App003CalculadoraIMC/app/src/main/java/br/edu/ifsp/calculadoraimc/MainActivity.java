package br.edu.ifsp.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText weightEditText;
    private EditText heightEditText;
    private TextView outputTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Esconde a barra de título (ActionBar) do aplicativo.
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        //Recupera a referência dos objetos da interface.
        weightEditText = findViewById(R.id.edittext_weigth);
        heightEditText = findViewById(R.id.edittext_height);
        outputTextView = findViewById(R.id.textview_output);
        calculateButton = findViewById(R.id.btn_calculate);

        //Define a classe responsável pelo controle do clique no botão.
        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == calculateButton){
            process();
        }
    }

    /*
    Recupera os valores da entrada do usuário e faz o calculo do IMC. O resultado é apresentado
    em um TextView.
     */
    private void process(){
        double weigth = getDouble(weightEditText);
        double heigth = getDouble(heightEditText);
        double imc;

        if(weigth != 0 && heigth != 0){
            imc = weigth / (heigth * heigth);
            outputTextView.setText(String.format("%s %.2f", "IMC", imc));
        }
    }

    /*
    Recebe um widget do tipo EditText e retorna o valor digitado no edittext em formato double.
    Em caso de erro na conversão do valor, o valor retornado será zero.
     */
    private double getDouble(EditText edit){
        double value;
        try{
            value = Double.valueOf(edit.getText().toString());
        }catch (NumberFormatException nfe){
            Toast.makeText(this, R.string.number_error_message, Toast.LENGTH_SHORT).show();
            value = 0;
        }
        return value;
    }
}