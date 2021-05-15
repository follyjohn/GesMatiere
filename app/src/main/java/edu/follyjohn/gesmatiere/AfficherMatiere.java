package edu.follyjohn.gesmatiere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import edu.follyjohn.gesmatiere.model.Matiere;
import edu.follyjohn.gesmatiere.service.MatiereService;

public class AfficherMatiere extends AppCompatActivity {

    Button retourBtn;
    Button menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_matiere);

        menuBtn = findViewById(R.id.menuBtn);
        retourBtn = findViewById(R.id.retoutBtn);
        Bundle extras = getIntent().getExtras();
        Matiere matiere = extras.getParcelable("edu.follyjohn.gesmatiere.model.Matiere");

        TextView vIdMat = findViewById(R.id.matId);
        vIdMat.setText(matiere.getId().toString());

        TextView vLibMat = findViewById(R.id.libMat);
        vLibMat.setText(matiere.getLibelle());

        TextView vEnsbMat = findViewById(R.id.ensMat);
        vEnsbMat.setText(matiere.getEnseignant());

        TextView vTypeMat = findViewById(R.id.typeMat);
        vTypeMat.setText(matiere.getFacultatif()? getResources().getString(R.string.facultatif_label) : getResources().getString(R.string.obligatoire_label));

        ImageView vMatImage  = findViewById(R.id.imageMAt);
        vMatImage.setImageResource(matiere.getImage().getImg());

        retourBtn.setOnClickListener(v -> {
            Intent afficher_page = new Intent(this, AjouterMatiere.class);

            startActivity(afficher_page);
        });

        menuBtn.setOnClickListener(v -> {
            Intent afficher_page = new Intent(this, MatiereList.class);

            startActivity(afficher_page);
        });

    }
}