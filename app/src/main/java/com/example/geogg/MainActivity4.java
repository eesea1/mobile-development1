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

public class MainActivity4 extends AppCompatActivity {
    EditText Xa, Ya, Xb, Yb;
    Button button;
    ImageButton button2;
    TextView answer1, answer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Xa = findViewById(R.id.Xa);
        Ya = findViewById(R.id.Ya);

        Xb = findViewById(R.id.Xb);
        Yb = findViewById(R.id.Yb);

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
                    double XA = Double.parseDouble(Xa.getText().toString());
                    double YA = Double.parseDouble(Ya.getText().toString());

                    double XB = Double.parseDouble(Xb.getText().toString());
                    double YB = Double.parseDouble(Yb.getText().toString());

                    //double res = Program.Ob(XA, YA, XB, YB);
                    String res = Program.D_alfa(XA, YA, XB, YB);
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
                Xb.setText("");
                Yb.setText("");
                 */
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
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String Value = "Отчёт по Обратной геодезической задаче: Xa " + Xa.getText().toString() + " Ya " + Ya.getText().toString() + " Xb " + Xb.getText().toString() + " Yb " + Yb.getText().toString() + " Ответ: " + answer1.getText().toString() + " " + answer2.getText().toString();
                ClipboardManager Clip = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Data", Value);
                Clip.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(),"Скопировано в буфер обмена", Toast.LENGTH_SHORT).show();
                Xa.setText("");
                Ya.setText("");
                Xb.setText("");
                Yb.setText("");
            }
        });
    }
}