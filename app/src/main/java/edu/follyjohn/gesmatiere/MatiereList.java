package edu.follyjohn.gesmatiere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MatiereList extends AppCompatActivity {
    Button addMaitreBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matiere_list);

        addMaitreBtn = findViewById(R.id.menum_add);
        addMaitreBtn.setOnClickListener(v -> {


            Intent form_matiere_page;
            form_matiere_page = new Intent(this,AjouterMatiere.class);
            startActivity(form_matiere_page);

        });
    }
}