package edu.follyjohn.gesmatiere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button matireRbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        matireRbutton = findViewById(R.id.menum_button);
        matireRbutton.setOnClickListener(v -> {


                Intent list_matire_page;
                list_matire_page = new Intent(this,MatiereList.class);
                startActivity(list_matire_page);

        });
    }
}