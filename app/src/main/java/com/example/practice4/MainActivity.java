package com.example.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button second, callme, website, mail, message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        second = findViewById(R.id.Second);
        second.setOnClickListener(this);
        callme = findViewById(R.id.callme);
        callme.setOnClickListener(this);
        website = findViewById(R.id.website);
        website.setOnClickListener(this);
        mail = findViewById(R.id.mail);
        mail.setOnClickListener(this);
        message = findViewById(R.id.message);
        message.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        Uri uri;
        String msg;
        switch (v.getId()) {
            case R.id.Second:
                intent = new Intent(MainActivity.this, MainActivity2.class);
                msg = "Text Passed by First Intent";
                intent.putExtra("first", msg);
                startActivity(intent);
                break;
            case R.id.callme:
                uri = Uri.parse("tel:+923064769479");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;
            case R.id.website:
                uri = Uri.parse("https://youtube.com");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.mail:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, "address");
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                break;
            case R.id.message:
                msg = "New Message!";
                intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, msg);
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected Value: " + v.getId());
        }
    }
}