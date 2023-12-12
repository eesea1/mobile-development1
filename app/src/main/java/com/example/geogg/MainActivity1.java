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

public class MainActivity1 extends AppCompatActivity {
    EditText grad, min, sec;
    Button button;
    ImageButton button2;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        grad = findViewById(R.id.grad);
        min = findViewById(R.id.min);
        sec = findViewById(R.id.sec);

        button = findViewById(R.id.button);
        answer = findViewById(R.id.answer1);
        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        button2.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    button2.setVisibility(View.VISIBLE);
                    double g = Double.parseDouble(grad.getText().toString());
                    double m = Double.parseDouble(min.getText().toString());
                    double s = Double.parseDouble(sec.getText().toString());

                    double res = Program.Gr(g, m, s);

                    answer.setText(String.valueOf(res));

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Ошибка при вводе данных!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value = answer.getText().toString();
                ClipboardManager Clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Data", Value);
                Clip.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(), "Скопировано в буфер обмена!", Toast.LENGTH_SHORT).show();
                /*
                grad.setText("");
                min.setText("");
                sec.setText("");
                */
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String Value = "Отчёт по переводу градусов ГГММСС (градусы, минуты, секунды) в формат десятичных градусов: Градусы " + grad.getText().toString() + " Минуты " + min.getText().toString() + " Секунды " + sec.getText().toString() + " Ответ: " + answer.getText().toString();
                ClipboardManager Clip = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Data", Value);
                Clip.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(),"Скопировано в буфер обмена", Toast.LENGTH_SHORT).show();
                grad.setText("");
                min.setText("");
                sec.setText("");
            }
        });
    }
}