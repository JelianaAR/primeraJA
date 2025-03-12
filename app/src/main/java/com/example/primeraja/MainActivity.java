package com.example.primeraja;

import android.widget.SeekBar;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private RadioGroup radioGroup;
    private Button button;
    private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        radioGroup = findViewById(R.id.radioGroup3);
        button = findViewById(R.id.button);
        seekBar = findViewById(R.id.seekBar3);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float textSize = 12 + progress;
                editText.setTextSize(textSize);
                editText.setHint("Tamaño: " + textSize + "sp");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String fontName = selectedRadioButton.getTag().toString();
                    int fontId = getResources().getIdentifier(fontName, "font", getPackageName());
                    Typeface typeface = ResourcesCompat.getFont(MainActivity.this, fontId);
                    editText.setTypeface(typeface);
                }
            }
        });
    }
}
