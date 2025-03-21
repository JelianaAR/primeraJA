package com.example.primeraja;

import android.graphics.Color;
import java.util.Random;
import android.widget.SeekBar;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private SeekBar seekBar;

    private Button button2;
    private final Random RANDOM = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextText);
        button = findViewById(R.id.button);
        seekBar = findViewById(R.id.seekBar3);
        button2 = findViewById(R.id.button2);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float textSize = 10 + progress;
                editText.setTextSize(textSize);
                editText.setHint("Tamaño: " + textSize + "sp");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        int[] fuentes = {
                R.font.dmserif,
                R.font.doto,
                R.font.caveat
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fuenteAleatoria = fuentes[(int) (Math.random() * fuentes.length)];
                Typeface typeface = ResourcesCompat.getFont(MainActivity.this, fuenteAleatoria);
                editText.setTypeface(typeface);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int red = RANDOM.nextInt(256);
                int green = RANDOM.nextInt(256);
                int blue = RANDOM.nextInt(256);
                int color = Color.rgb(red, green, blue);
                editText.setTextColor(color);
            }
        });
    }
}

