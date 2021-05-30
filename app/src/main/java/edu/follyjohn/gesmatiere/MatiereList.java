package edu.follyjohn.gesmatiere;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MatiereList extends AppCompatActivity {
    Button addMaitreBtn, menuButton, saveBtn;
    public final static String MYNUMBER = "number";
    public EditText editNumber;
    SharedPreferences mesPref = getSharedPreferences(Context.MODE_PRIVATE);

    private SharedPreferences getSharedPreferences(int modePrivate) {
        return null;
    }


    int IeCompteur;
    private final static int MENU_AJOUTER = Menu.FIRST;
    private final static int MENU_SUPPRIMER = Menu.FIRST +1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matiere_list);
        menuButton = findViewById(R.id.button_menu);
        addMaitreBtn = findViewById(R.id.menum_add);
        addMaitreBtn.setOnClickListener(v -> {

            Intent form_matiere_page;
            form_matiere_page = new Intent(this,AjouterMatiere.class);
            startActivity(form_matiere_page);

        });

        registerForContextMenu(menuButton);
//        if(mesPref.getInt("Compteur",0) != 0) {
//            editNumber.setText(mesPref.getString(MYNUMBER, ""));
//
//        }

        editNumber = findViewById(R.id.textPref);

        saveBtn = findViewById(R.id.btn_save);

        saveBtn.setOnClickListener(v -> {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putString(MYNUMBER, String.valueOf(editNumber.getText()));

            editor.apply();
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, MENU_AJOUTER, Menu.NONE, "Ajouter un element");
        menu.add(Menu.NONE, MENU_SUPPRIMER, Menu.NONE, "Supprimer un element");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case MENU_AJOUTER:
                Toast.makeText(getApplicationContext(), "AJOUTER", Toast.LENGTH_LONG).show();
                break;
            case MENU_SUPPRIMER:
                Toast.makeText(getApplicationContext(), "SUPPRIMER", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}