package com.example.geogg;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    EditText Xa, Ya, d, grad, min, sec;
    Button button;
    ImageButton button2;
    TextView answer1, answer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Xa = findViewById(R.id.Xa);
        Ya = findViewById(R.id.Ya);
        d = findViewById(R.id.d);

        grad = findViewById(R.id.grad);
        min = findViewById(R.id.min);
        sec = findViewById(R.id.sec);

        button = findViewById(R.id.button);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);

        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        button2.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    button2.setVisibility(View.VISIBLE);
                    double X = Double.parseDouble(Xa.getText().toString());
                    double Y = Double.parseDouble(Ya.getText().toString());
                    double D = Double.parseDouble(d.getText().toString());

                    double g = Double.parseDouble(grad.getText().toString());
                    double m = Double.parseDouble(min.getText().toString());
                    double s = Double.parseDouble(sec.getText().toString());

                    String res = Program.XY_b(X, Y, D, g, m, s);
                    String[] result = res.split(" ");
                    answer1.setText(result[0]);
                    answer2.setText(result[1]);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Ошибка при вводе данных!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value = answer1.getText().toString();
                ClipboardManager Clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Data", Value);
                Clip.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(), "Скопировано в буфер обмена!", Toast.LENGTH_SHORT).show();
                /*
                Xa.setText("");
                Ya.setText("");
                d.setText("");
                grad.setText("");
                min.setText("");
                sec.setText("");
                */
            }
        });

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value = answer1.getText().toString();
                ClipboardManager Clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Data", Value);
                Clip.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(), "Скопировано в буфер обмена!", Toast.LENGTH_SHORT).show();
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String Value = "Отчёт по прямой геодезической задаче: Xa " + Xa.getText().toString() + " Ya " + Ya.getText().toString() + " d " + d.getText().toString() + " grad " + grad.getText().toString() + " min " + min.getText().toString() + " sec " + sec.getText().toString() + " Ответ: " + answer1.getText().toString() + " " + answer2.getText().toString();
                ClipboardManager Clip = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Data", Value);
                Clip.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(),"Скопировано в буфер обмена", Toast.LENGTH_SHORT).show();
                Xa.setText("");
                Ya.setText("");
                d.setText("");
                grad.setText("");
                min.setText("");
                sec.setText("");
            }
        });
    }
}