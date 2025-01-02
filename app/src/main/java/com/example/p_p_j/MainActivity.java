package com.example.p_p_j;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    //creamos tablas
    private ImageView imgPiedra, imgPapel, imgTijera, imgResultado;
    private TextView txtResultado, textView;

    private MediaPlayer mediaPlayer;
    private ImageButton btnSound;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        imgPiedra = findViewById(R.id.imgPiedra);
        imgPapel = findViewById(R.id.imgPapel);
        imgTijera = findViewById(R.id.imgTijera);
        imgResultado = findViewById(R.id.imgResultado);
        txtResultado = findViewById(R.id.txtResultado);

        // Asignar imágenes a los ImageView
        imgPiedra.setImageResource(R.drawable.piedra);
        imgPapel.setImageResource(R.drawable.papel);
        imgTijera.setImageResource(R.drawable.tijera);

        imgPiedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugar("piedra");
            }
        });

        imgPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugar("papel");
            }
        });

        imgTijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugar("tijera");
            }
        });
    }


    private void jugar(String jugador) {
        String[] opciones = {"piedra", "papel", "tijera"};
        Random random = new Random();
        int computadora = random.nextInt(3);
        String opcionComputadora = opciones[computadora];

        String resultado;
        if (jugador.equals(opcionComputadora)) {
            resultado = "Empate!";
        } else if ((jugador.equals("piedra") && opcionComputadora.equals("tijera")) ||
                (jugador.equals("papel") && opcionComputadora.equals("piedra")) ||
                (jugador.equals("tijera") && opcionComputadora.equals("papel"))) {
            resultado = "Ganaste!";
        } else {
            resultado = "Perdiste!";
        }

        txtResultado.setText("Tú haz escogido la opcion: " + jugador + "\n" + "El oponente escogio la opcion: " + opcionComputadora + "\n" + resultado);

        switch (resultado) {
            case "Empate!":
                imgResultado.setImageResource(R.drawable.empate);
                break;
            case "Ganaste!":
                imgResultado.setImageResource(R.drawable.ganaste);
                break;
            case "Perdiste!":
                imgResultado.setImageResource(R.drawable.perdiste);
                break;
        }
    }
}
