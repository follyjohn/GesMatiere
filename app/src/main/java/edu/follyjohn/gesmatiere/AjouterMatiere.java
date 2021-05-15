package edu.follyjohn.gesmatiere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;

import edu.follyjohn.gesmatiere.model.Image;
import edu.follyjohn.gesmatiere.model.Matiere;
import edu.follyjohn.gesmatiere.service.MatiereService;

public class AjouterMatiere extends AppCompatActivity {
    Button addBtn;
    Button searchBtn;
    RadioButton RadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_matiere);
        Spinner spinner_ens = (Spinner) findViewById(R.id.spinner_enseigant);
        Spinner spinner_img = (Spinner) findViewById(R.id.spinner_image);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_ens = ArrayAdapter.createFromResource(this,
                R.array.liste_enseigant, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_img = ArrayAdapter.createFromResource(this,
                R.array.liste_enseigant, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_ens.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_ens.setAdapter(adapter_ens);
//        spinner_img.setAdapter(adapter_img);

//        LinkedHashMap<String, String> mapData = new LinkedHashMap<String, String>();
//
//        mapData.put("shamu", "Nexus 6");
//        mapData.put("fugu", "Nexus Player");
//        mapData.put("volantisg", "Nexus 9 (LTE)");
//        mapData.put("volantis", "Nexus 9 (Wi-Fi)");
//        mapData.put("hammerhead", "Nexus 5 (GSM/LTE)");
//        mapData.put("razor", "Nexus 7 [2013] (Wi-Fi)");
//        mapData.put("razorg", "Nexus 7 [2013] (Mobile)");
//        mapData.put("mantaray", "Nexus 10");
//        mapData.put("occam", "Nexus 4");
//        mapData.put("nakasi", "Nexus 7 (Wi-Fi)");
//        mapData.put("nakasig", "Nexus 7 (Mobile)");
//        mapData.put("tungsten", "Nexus Q");

        Vector<Image> imgData = new Vector<Image>();
        imgData.add(new Image("dff", R.drawable.ic_launcher_background));
        imgData.add(new Image("gjf", R.drawable.ic_launcher_background));
        imgData.add(new Image("eyt", R.drawable.ic_launcher_background));
        imgData.add(new Image("rey", R.drawable.ic_launcher_background));
        ArrayAdapter<Image> dataAdapter = new ArrayAdapter<Image>(this,android.R.layout.simple_spinner_item, imgData);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(dataAdapter);



//        spinner = (Spinner) findViewById(R.id.spinner);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);

        spinner_img.setAdapter(dataAdapter);

        addBtn = findViewById(R.id.buttonAdd);
        searchBtn = findViewById(R.id.buttonSearch);

        addBtn.setOnClickListener(v -> {
//                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();

            EditText idText = (EditText) findViewById(R.id.editMatId);
            Long id = Long.parseLong(String.valueOf(idText.getText()));

            EditText libelleText = (EditText) findViewById(R.id.editTextLibMat);
            String libelle = String.valueOf(libelleText.getText());

            Spinner profText = (Spinner) findViewById(R.id.spinner_enseigant);
            String ens = String.valueOf(profText.getSelectedItem());

            RadioGroup rgFac = (RadioGroup) findViewById(R.id.rgFac);

            int selectedId = rgFac.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            RadioButton  = (RadioButton) findViewById(selectedId);

            Boolean fac = String.valueOf(RadioButton.getText()).equals(getResources().getString(R.string.facultatif_label));

            Spinner imgSpin = (Spinner) findViewById(R.id.spinner_image);
            Image img = (Image) imgSpin.getSelectedItem();


            Matiere m = new Matiere();

            m.setId(id);
            m.setEnseignant(ens);
            m.setFacultatif(fac);
            m.setLibelle(libelle);
            m.setImage(img);

//            Log.i("dd",m.toString());

            MatiereService.ajouterMatiere(m);

//            Log.i("dds", MatiereService.listMatire.toString());

            afficherMatiere(m);

        });


        searchBtn.setOnClickListener(v -> {
//                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
            EditText idText = (EditText) findViewById(R.id.editMatId);
            Long id = Long.parseLong(String.valueOf(idText.getText()));

            if(MatiereService.rechercherParId(id)){
                Matiere m = MatiereService.selectParId(id);
                afficherMatiere(m);
            }else {
                                Snackbar.make(v, "Auccune matiere trouve", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
            }
        });

    }

    private void afficherMatiere(Matiere m) {
        Intent afficher_page = new Intent(this, AfficherMatiere.class);

        afficher_page.putExtra("edu.follyjohn.gesmatiere.model.Matiere", m);

        startActivity(afficher_page);
    }
}