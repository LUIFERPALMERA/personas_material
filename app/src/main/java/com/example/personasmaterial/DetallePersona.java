package com.example.personasmaterial;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePersona extends AppCompatActivity {
    private TextView nombres;
    private TextView apellidos;
    private ImageView foto;
    private Bundle bundle;
    private Intent i;
    private int fot;
    private String nomb,apel,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);
        nombres = findViewById(R.id.lblNombresD);
        apellidos = findViewById(R.id.lblApellidosD);
        foto = findViewById(R.id.fotoD);
        i = getIntent();
        bundle = i.getBundleExtra("datos");
        nomb = bundle.getString("nombres");
        apel = bundle.getString("apellidos");
        fot = bundle.getInt("foto");
        id = bundle.getString("id");

        nombres.setText(nomb);
        apellidos.setText(apel);
        foto.setImageResource(fot);
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(DetallePersona.this,MainActivity.class);
        startActivity(i);
    }

    public void eliminar(View v){
        String positivo, negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.titulo_eliminar));
        builder.setMessage(getResources().getString(R.string.mensaje_eliminar));
        positivo = getResources().getString(R.string.positivo);
        negativo = getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Persona p = new Persona();
                p.setId(id);
                p.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
