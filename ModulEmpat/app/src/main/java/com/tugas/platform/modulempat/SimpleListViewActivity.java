package com.tugas.platform.modulempat;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SimpleListViewActivity extends AppCompatActivity {

    private static final String TAG = "SimpleListViewActivity";
    private ListView simpleLV;
    private ArrayList ar_nama_mhs;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_simple_list_view);

        simpleLV = findViewById(R.id.simpleLV);

        ar_nama_mhs = new ArrayList<String>();
        ar_nama_mhs.add("AUZIA NATASA");
        ar_nama_mhs.add("M. ICHWAN AKBAR");
        ar_nama_mhs.add("CHAHNIYAN REGINA KASIH ZEBUA");
        ar_nama_mhs.add("RISKA MULIATI");
        ar_nama_mhs.add("AINUR AZIZAH");
        ar_nama_mhs.add("AISYAH SEPTIANI");
        ar_nama_mhs.add("RIZKA AULIA");
        ar_nama_mhs.add("KURNI IRFANSAH");
        ar_nama_mhs.add("MUHAMMAD RIDWAN");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ar_nama_mhs);
        simpleLV.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}