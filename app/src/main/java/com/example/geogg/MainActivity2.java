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

public class MainActivity2 extends AppCompatActivity {
    EditText grad;
    Button button;
    ImageButton button2;
    TextView answer1, answer2, answer3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        grad = findViewById(R.id.grad);

        button = findViewById(R.id.button);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);

        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        button2.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    button2.setVisibility(View.VISIBLE);
                    double g = Double.parseDouble(grad.getText().toString());

                    String res = Program.Gr_min_sk(g);

                    String[] result = res.split(" ");
                    answer1.setText(result[0]);
                    answer2.setText(result[1]);
                    answer3.setText(result[2]);
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
                //grad.setText("");
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value = answer2.getText().toString();
                ClipboardManager Clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Data", Value);
                Clip.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(), "Скопировано в буфер обмена!", Toast.LENGTH_SHORT).show();
                //grad.setText("");
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value = answer3.getText().toString();
                ClipboardManager Clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Data", Value);
                Clip.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(), "Скопировано в буфер обмена!", Toast.LENGTH_SHORT).show();
                //grad.setText("");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String Value = "Отчёт по обратному переводу градусов. Из десятичных градусов (deg) в формат ГГММСС (градусы, минуты, секунды): Градусы " + grad.getText().toString() + " Ответ: " + answer1.getText().toString() + " " + answer2.getText().toString() + " " + answer3.getText().toString();
                ClipboardManager Clip = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Data", Value);
                Clip.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(),"Скопировано в буфер обмена", Toast.LENGTH_SHORT).show();
                grad.setText("");
            }
        });
    }
}