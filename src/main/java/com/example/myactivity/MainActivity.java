package com.example.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import Modelo.Pessoa;
import dao.PessoaDao;

public class MainActivity extends AppCompatActivity {
ListView listvisivel;
Button btnCadastrar;

Pessoa pessoa;
PessoaDao pessoaDao;
ArrayList<Pessoa> arrayListpessoa;
ArrayAdapter<Pessoa> arrayAdapterpessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listvisivel = (ListView) findViewById(R.id.listPessoas);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FormPessoa.class);
                startActivity(i);
            }
        });

    }

    private void populaLista(){
pessoaDao = new PessoaDao(MainActivity.this);
arrayListpessoa = pessoaDao.selectAllpessoa();
pessoaDao.close();

if(listvisivel != null){
    arrayAdapterpessoa = new ArrayAdapter<Pessoa>(MainActivity.this,
             android.R.layout.simple_list_item_1,arrayListpessoa);
    listvisivel.setAdapter(arrayAdapterpessoa);

}
    }

    @Override
    protected void onResume() {
        super.onResume();
        populaLista();
    }
}
