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
    public void showDialog(custom_dialog dialog){

        AlertDialog alertDialog = dialog.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(context.getResources().getColor(R.color.light_blue_900));
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(17);
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(context.getResources().getColor(R.color.grey_800));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(17);
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setAllCaps(false);
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setAllCaps(false);
     }
}
