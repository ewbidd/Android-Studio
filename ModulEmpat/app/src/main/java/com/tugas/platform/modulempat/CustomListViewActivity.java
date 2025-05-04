package com.tugas.platform.modulempat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {
    private static final String TAG = "CustomListViewActivity";
    private ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list_view);

        listView = findViewById(R.id.customLV);

        ArrayList<ModelMahasiswa> listMahasiswa = new ArrayList<>();

        ModelMahasiswa m1 = new ModelMahasiswa(R.drawable.satu, "AUZIA NATASA", "2307110477");
        ModelMahasiswa m2 = new ModelMahasiswa(R.drawable.dua, "M. ICHWAN AKBAR", "2307110480");
        ModelMahasiswa m3 = new ModelMahasiswa(R.drawable.tiga, "CHAHNIYAN REGINA KASIH ZEBUA", "2307110481");
        ModelMahasiswa m4 = new ModelMahasiswa(R.drawable.empat, "RISKA MULIATI", "2307110484");
        ModelMahasiswa m5 = new ModelMahasiswa(R.drawable.lima, "AINUR AZIZAH", "2307110488");
        ModelMahasiswa m6 = new ModelMahasiswa(R.drawable.enam, "AISYAH SEPTIANI", "2307111532");
        ModelMahasiswa m7 = new ModelMahasiswa(R.drawable.tujuh, "RIZKA AULIA", "2307111534");
        ModelMahasiswa m8 = new ModelMahasiswa(R.drawable.delapan, "KURNI IRFANSAH", "2307111535");
        ModelMahasiswa m9 = new ModelMahasiswa(R.drawable.sembilan, "MUHAMMAD RIDWAN", "2307111536");

        listMahasiswa.add(m1);
        listMahasiswa.add(m2);
        listMahasiswa.add(m3);
        listMahasiswa.add(m4);
        listMahasiswa.add(m5);
        listMahasiswa.add(m6);
        listMahasiswa.add(m7);
        listMahasiswa.add(m8);
        listMahasiswa.add(m9);

        listView.setAdapter(new CustomAdapter(this, R.layout.single_list, listMahasiswa));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}