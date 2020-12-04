package com.matkinson.dist_convert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumber;
    Double kmeters;
    Double meters;
    String S;
    Button convert;
    Button recommencer;
    Button quitter;
    private AlertDialog.Builder alertDialog;
    TextView textView;
    ImageView imageView;
    public void convert(View view) {

        editTextNumber = findViewById(R.id.editTextNumber);
        kmeters = Double.parseDouble(editTextNumber.getText().toString());
        meters = kmeters*1000;
        S=meters.toString() + " m";
        textView = findViewById(R.id.textView);
        textView.setText(S);
        //hide text
        InputMethodManager mgr=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public  void recommencer(View view){
        editTextNumber = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);
        editTextNumber.setText(null);
        textView.setText(null);

    }
    public void quiterProgram (View view){

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quitter=findViewById(R.id.quitter);
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog= new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Alert de sortie");
                alertDialog.setMessage("Est-ce que vous voudriez quittez l'application?");
                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                });
                alertDialog.setNegativeButton("non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog=alertDialog.create();
                dialog.show();
            }
        });
    }
}