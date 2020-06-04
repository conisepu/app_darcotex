package com.example.darcotex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Registro extends AppCompatActivity {

    private EditText edit_registrar_nombre, edit_registrar_apellido, edit_registrar_nombre_usuario, edit_registrar_email, edit_registrar_numero_tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__registro);

        edit_registrar_nombre = (EditText)findViewById(R.id.Registrar_Nombre);
        edit_registrar_apellido = (EditText)findViewById(R.id.Registrar_apellido);
        edit_registrar_nombre_usuario = (EditText)findViewById(R.id.Registrar_Nombre_usuario);
        edit_registrar_email = (EditText)findViewById(R.id.Registrar_email);
        edit_registrar_numero_tel = (EditText)findViewById(R.id.Registrar_numero_tel);
    }

    //METODO PARA VOLVER al inicio de sesion
    public void Volver_inicio_sesion(View view){
        Intent volver_inicio_sesion = new Intent(this, MainActivity.class);
        startActivity(volver_inicio_sesion);
    }

    //METODO PARA IR AL SIGUIENTE PAGINA DE REGISTRO
    public void Sgte_registro_persona(View view){

        String Registrar_nombre = edit_registrar_nombre.getText().toString();
        String Registrar_apellido = edit_registrar_apellido.getText().toString();
        String Registrar_nombre_usuario = edit_registrar_nombre_usuario.getText().toString();
        String Registrar_email = edit_registrar_email.getText().toString();
        String Registrar_numero_tel = edit_registrar_numero_tel.getText().toString();

        if(Registrar_nombre.length() == 0 || Registrar_apellido.length() == 0 || Registrar_nombre_usuario.length() == 0 || Registrar_email.length() == 0 || Registrar_numero_tel.length() == 0 ){

            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
        }
        if(Registrar_nombre.length() != 0 && Registrar_apellido.length() != 0 && Registrar_nombre_usuario.length() != 0 && Registrar_email.length() != 0 && Registrar_numero_tel.length() != 0 ){
            if(Registrar_numero_tel.length() == 9 ){
                Intent sgte_registro = new Intent(this, activity_registro_2.class);
                sgte_registro.putExtra("Registrar_nombre", Registrar_nombre);//ESTO ES PARA PASARLO guardado AL SEGUNDO ACTIVITY DE REGISTRO
                sgte_registro.putExtra("Registrar_apellido", Registrar_apellido);
                sgte_registro.putExtra("Registrar_nombre_usuario", Registrar_nombre_usuario);
                sgte_registro.putExtra("Registrar_email", Registrar_email);
                sgte_registro.putExtra("Registrar_numero_tel", Registrar_numero_tel);
                startActivity(sgte_registro);
            }
            else if(Registrar_numero_tel.length() == 8 ){
                Toast.makeText(this, "Debes agregar el N° 9 adelante de los numeros", Toast.LENGTH_LONG).show();
            }
            else if(Registrar_numero_tel.length() < 8){
                Toast.makeText(this, "Debes colocar tu numero del celular", Toast.LENGTH_LONG).show();
            }

        }


    }

}
