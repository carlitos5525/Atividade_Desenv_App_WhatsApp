package com.example.whats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutMensagem;
    private TextInputEditText textInputEditTextMensagem;
    private TextInputLayout textInputLayoutNumero;
    private TextInputEditText textInputEditTextNumero;
    private Button buttonEnviarMensagem;

    private String url_padrao = "https://wa.me/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayoutMensagem = findViewById(R.id.textInputLayout_Mensagem);
        textInputEditTextMensagem = findViewById(R.id.textInputEdit_Mensagem);
        textInputLayoutNumero = findViewById(R.id.textInputLayout_Numero);
        textInputEditTextNumero = findViewById(R.id.textInputEdit_numero);
        buttonEnviarMensagem = findViewById(R.id.button_enviar);

        buttonEnviarMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = textInputEditTextNumero.getText().toString();
                String mensagem = textInputEditTextMensagem.getText().toString();

                String url = url_padrao + numero + "?" + "text=" + mensagem;

                openWebPage(url);
            }
        });
    }

    public void openWebPage(String url){
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

}