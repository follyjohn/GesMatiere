package edu.follyjohn.gesmatiere;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import edu.follyjohn.gesmatiere.model.Matiere;

public class AfficherMatiere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_matiere);

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



        Log.i("matiere: ", matiere.getLibelle());
    }
}