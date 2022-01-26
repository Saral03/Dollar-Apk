package com.example.dollar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView2;
    private Vibrator vib;
    DecimalFormat df = new DecimalFormat("#.##");

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        textView2 = findViewById(R.id.textView2);
        ImageView im = findViewById(R.id.im);
        YoYo.with(Techniques.Tada).duration(4500).repeat(-1).playOn(im);
        vib=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        button.setOnClickListener(v -> {
            vib.vibrate(10);
            if(editText.getText().toString().isEmpty()){
                textView2.setText(null);
                return;
            }
            String price = editText.getText().toString();
            double p = Double.parseDouble(price);
            if (p < 0) {
                Toast.makeText(MainActivity.this, "INVALID:(", Toast.LENGTH_SHORT).show();
                textView2.setText(null);
            }
            else {
                BigDecimal dol = BigDecimal.valueOf(p * 74.55);
                textView2.setText(df.format(dol) + " Rs");
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}