package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    Button btnClear;
    ListView lvToDo;
    ArrayList<String> althingstodo = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etElement = findViewById(R.id.editTextToDo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvToDo = findViewById(R.id.listViewToDo);
        ArrayAdapter aaToDo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,althingstodo);
        lvToDo.setAdapter(aaToDo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String thingtodo = etElement.getText().toString();
                althingstodo.add(thingtodo);
                aaToDo.notifyDataSetChanged();
                etElement.setText("");
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String thingtodo = etElement.getText().toString();
                althingstodo.clear();
                aaToDo.notifyDataSetChanged();
                etElement.setText("");
            }
        });
    }
}