package com.campelo.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pedra(View view){
        verificaVencedor("Pedra");
    }

    public void papel(View view){
        verificaVencedor("Papel");
    }

    public void tesoura(View view){
        verificaVencedor("Tesoura");
    }

    private String escolhaApp(){
        String[] escolhas = {"Pedra", "Papel", "Tesoura"};
        int i = new Random().nextInt(escolhas.length);
        String escolhaApp = escolhas[i];
        ImageView ivEscolhaApp = findViewById(R.id.ivEscolhaApp);

        switch (escolhaApp){
            case "Pedra":
                ivEscolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                ivEscolhaApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                ivEscolhaApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return escolhaApp;
    }

    private void verificaVencedor(String escolhaJogador){
        String escolhaApp = escolhaApp();
        TextView txtResultado = findViewById(R.id.txtResultado);

        if(
            (escolhaJogador == "Pedra" && escolhaApp == "Tesoura") ||
            (escolhaJogador == "Papel" && escolhaApp == "Pedra") ||
            (escolhaJogador == "Tesoura" && escolhaApp == "Papel")
        ){
            txtResultado.setText("Você venceu!");
        }else if(
            (escolhaApp == "Pedra" && escolhaJogador == "Tesoura") ||
            (escolhaApp == "Papel" && escolhaJogador == "Pedra") ||
            (escolhaApp == "Tesoura" && escolhaJogador == "Papel")
        ){
            txtResultado.setText("Você perdeu!");
        }else{
            txtResultado.setText("Você empatou!");
        }
    }
}