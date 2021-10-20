package com.example.kieutienanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edUser, edEmail, edDes;
    Button btSend;
    Spinner spinner;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        edUser = findViewById(R.id.edUser);
        edEmail = findViewById(R.id.edEmail);
        edDes = findViewById(R.id.edDes);
        btSend = findViewById(R.id.btSend);
        btSend.setOnClickListener(this);

        String[] genders = {"Male", "Female"};
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    public void onClick(View v) {
        if (v == btSend) {
            onSend();
        }
    }
    private void onSend() {
        if (edUser.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter username", Toast.LENGTH_LONG).show();
            return;
        }
        if (edEmail.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }
        if (!checkBox.isChecked()) {
            Toast.makeText(this, "Please select checkbox", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(MainActivity.this, MessageAct.class);
        startActivity(intent);
    }
}