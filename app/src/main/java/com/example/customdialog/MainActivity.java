package com.example.customdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
            txt.setText(R.string.cancel_button_clicked);
            Toast.makeText(getApplicationContext(),"cancel button", Toast.LENGTH_LONG).show();
        });
        dialog.setPositiveButton("Save", (dialogInterface, i) -> {

        });

        AlertDialog alertDialog = dialog.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
            boolean wantToCloseDialog = (dialog.nameEditText.getText().toString().trim().isEmpty());
            if (!wantToCloseDialog){
                txt.setText(dialog.nameEditText.getText().toString().trim());
                Toast.makeText(getApplicationContext(),"save button", Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }

        });

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.light_blue_900));
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(17);
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.grey_800));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(17);
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setAllCaps(false);
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setAllCaps(false);

    }
}