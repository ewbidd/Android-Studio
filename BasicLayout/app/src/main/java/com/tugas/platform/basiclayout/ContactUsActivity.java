package com.tugas.platform.basiclayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContactUsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView location, phone, email;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

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

        location.setOnClickListener(this);
        phone.setOnClickListener(this);
        email.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.textLocation) {
            Intent loc = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("google.navigation:q=" + location.getText().toString()));
            startActivity(loc);

        } else if (id == R.id.textEmail) {
            Intent mail = new Intent(Intent.ACTION_SENDTO,
                    Uri.fromParts("mailto", email.getText().toString(), null));
            mail.putExtra(Intent.EXTRA_SUBJECT, "Subjek");
            mail.putExtra(Intent.EXTRA_TEXT, "Isi Pesan");
            startActivity(mail);

        } else if (id == R.id.textPhone) {
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:" + phone.getText().toString()));
            startActivity(call);
        }
    }
}