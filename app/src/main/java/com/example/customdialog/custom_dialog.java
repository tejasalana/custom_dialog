package com.example.customdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;

public class custom_dialog extends AlertDialog.Builder{

    EditText nameEditText;
    Context context;

    public custom_dialog(Context context, String title, String message) {
        super(context);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.test,null);

        nameEditText = dialogView.findViewById(R.id.nameEditText);

        this.setTitle(title);
        this.setMessage(message);
        this.setCancelable(false);
        this.setView(dialogView);
    }

}
