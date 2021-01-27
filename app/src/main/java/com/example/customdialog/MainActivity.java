package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.txt);

        btn.setOnClickListener(view -> show());
    }

    private void show() {
        custom_dialog dialog = new custom_dialog(this,"Rename Token", "Enter a unique name for your token");
        dialog.setNegativeButton("Cancel", (dialogInterface, i) -> {
            txt.setText("cancel button clicked");
            Toast.makeText(getApplicationContext(),"cancel button", Toast.LENGTH_LONG).show();
        });
        dialog.setPositiveButton("Save", (dialogInterface, i) -> {
            txt.setText((dialog.nameEditText.getText().toString()));
            Toast.makeText(getApplicationContext(),"save button", Toast.LENGTH_LONG).show();
        });

       dialog.showDialog(dialog);

    }
}