package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.button3);
        et1=findViewById(R.id.editTextText);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yazi=et1.getText().toString();
                if (!yazi.isEmpty()){
                    Intent yeniintent = new Intent(MainActivity.this, MainActivity2.class);

                    yeniintent.putExtra("kullaniciAdi", yazi);

                    startActivity(yeniintent);
                }
            }
        });

    }
}