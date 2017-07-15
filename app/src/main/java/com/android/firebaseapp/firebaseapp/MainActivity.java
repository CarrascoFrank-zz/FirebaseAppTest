package com.android.firebaseapp.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    //recuperando a instancia do Database
    private DatabaseReference firebaseReferencia = FirebaseDatabase.getInstance().getReference(); //getREference volta ao no incial do banco
    private DatabaseReference usuarioReferencia = firebaseReferencia.child("usuarios");
    private DatabaseReference produtoReferencia = firebaseReferencia.child("produtos").child("001");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Usuarios usuarios = new Usuarios();
//        usuarios.setNome("Ana Helena");
//        usuarios.setSobrenome("Silva");
//        usuarios.setIdade(25);
//        usuarios.setSexo("Femenino");
//
//        Produtos produtos = new Produtos();
//        produtos.setDescricao("Relogio");
//        produtos.setCor("Preto");
//        produtos.setFabricante("Omega");
//
//
//        firebaseReferencia.child("pontos").setValue("100"); //adicionando valor ao banco
//        usuarioReferencia.child("002").child("nome").setValue("Juliana Sampaio");
//        usuarioReferencia.child("003").setValue(usuarios);
//        produtoReferencia.child("001").setValue(produtos);


        //colocando o Listener.
        usuarioReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }); //adicionando um listener
    }
}
