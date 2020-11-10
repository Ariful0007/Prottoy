package com.example.prottoy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //action bar
        Handler handler=new Handler();
        progressDialog=new ProgressDialog(this);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                progressDialog.setTitle("Loading...");
                progressDialog.setMessage("loading..");
                progressDialog.show();;

                Intent intent=new Intent(MainActivity.this,LOgIn.class);
                startActivity(intent);
                progressDialog.dismiss();
                finish();

            }
        },2500);


    }


    @Override
    public void onBackPressed() {
        AlertBoxUser();
        super.onBackPressed();
    }

    private void AlertBoxUser() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Delete");
        builder.setMessage("Do you want to logout?");
        builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();;
            }
        }).setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();;

    }
}