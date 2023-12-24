package com.example.smarthomefinale;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.os.Handler;
public class MainActivity extends AppCompatActivity {
    EditText nombre;Button envoiButton;TextView resultat ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.nombre);
        resultat = findViewById(R.id.resultat);
        envoiButton = findViewById(R.id.envoiButton);
/////////////////////
        envoiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculerFactoriel(); } });}

    //////////////////////////////////////////////
    private int Factoriel(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * Factoriel(n - 1); }
    }
    //////////////////////////////////////////
    public void calculerFactoriel() {
        int x,R;
        try {
            // Vérifier si le champ est vide
            String input = nombre.getText().toString().trim();
            if (TextUtils.isEmpty(input)) {
                resultat.setText("Veuillez entrer un nombre SVP");
                return; }
            x = Integer.parseInt(input);
            if (x < 0) {
                resultat.setText("Erreur : le factoriel n'est pas défini pour les nombres négatifs");
            } else {
                R = Factoriel(x);
                resultat.setText("Le factoriel de votre nombre "+ x+" est " + R);
            }
        } catch (NumberFormatException e) { resultat.setText("Entrer un nombre valide"); }}
///////////////////////////////////////
    }


