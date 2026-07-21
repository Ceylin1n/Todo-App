package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    TextView kullanici;
    EditText et2;
    Button btn2;
    ListView list;
    ArrayList<String> taskList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        kullanici=findViewById(R.id.textView3);
        et2=findViewById(R.id.editTextText2);
        btn2=findViewById(R.id.button2);
        list=findViewById(R.id.listvieww);
        String isim = getIntent().getStringExtra("kullaniciAdi");
        kullanici.setText("Welcome " + isim + "👋");
        taskList = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                taskList
        );

        list.setAdapter(adapter);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = et2.getText().toString();

                if (!task.isEmpty()) {

                    taskList.add("📝"+task);
                    adapter.notifyDataSetChanged();

                    et2.setText("");

                } else {
                    Toast.makeText(MainActivity2.this,"Please enter a task", Toast.LENGTH_SHORT).show();
                }
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                taskList.remove(position);
                adapter.notifyDataSetChanged();

                Toast.makeText(
                        MainActivity2.this,
                        "Task deleted",
                        Toast.LENGTH_SHORT
                ).show();

                return true;
            }
        });

    }

}