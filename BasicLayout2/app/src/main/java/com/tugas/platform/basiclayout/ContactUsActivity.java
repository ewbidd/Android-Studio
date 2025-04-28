package com.tugas.platform.basiclayout;

import static com.tugas.platform.basiclayout.R.layout.activity_contact_us;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContactUsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView location, phone, email, btnBack;
    private ImageView imgLocation, imgPhone, imgEmail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_contact_us);

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContactUsActivity.this, MainActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        location = findViewById(R.id.textLocation);
        phone = findViewById(R.id.textPhone);
        email = findViewById(R.id.textEmail);
        imgLocation = findViewById(R.id.imgLocation);
        imgPhone = findViewById(R.id.imgPhone);
        imgEmail = findViewById(R.id.imgEmail);

        location.setOnClickListener(this);
        phone.setOnClickListener(this);
        email.setOnClickListener(this);
        imgLocation.setOnClickListener(this);
        imgPhone.setOnClickListener(this);
        imgEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.textLocation || id == R.id.imgLocation) {
            Intent loc = new Intent(Intent.ACTION_VIEW, Uri.parse(
                    "google.navigation:q=" + location.getText().toString()));
            startActivity(loc);

        } else if (id == R.id.textEmail || id == R.id.imgEmail) {
            Intent mail = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", email.getText().toString(), null));
            mail.putExtra(Intent.EXTRA_SUBJECT, "Subjek");
            mail.putExtra(Intent.EXTRA_TEXT, "Isi Pesan");
            startActivity(mail);

        } else if (id == R.id.textPhone || id == R.id.imgPhone) {
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:" + phone.getText().toString()));
            startActivity(call);
        }
    }
}