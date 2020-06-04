package com.example.darcotex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.HashMap;
import java.util.Map;

public class activity_registro_2 extends AppCompatActivity {

    private FirebaseAuth firebaseAuth = null;
    private EditText edit_Registrar_pass, edit_Registrar_confirm_contra;
    //String URL="http://192.168.56.1:8081/CursoAndroid/registro.php"; //CONEXION a BASE DE DATOS


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_2);
        edit_Registrar_pass = (EditText)findViewById(R.id.registrar_contraseña);
        edit_Registrar_confirm_contra = (EditText)findViewById(R.id.registrar_confirm_cotra);



    }
    //METODO PARA REGISTRARSE
    public void Registrar_persona(View view){

        String pass = edit_Registrar_pass.getText().toString();
        final String confirm_pass = edit_Registrar_confirm_contra.getText().toString();
        final String Registrar_nombre = getIntent().getStringExtra("Registrar_nombre");
        final String Registrar_apellido = getIntent().getStringExtra("Registrar_apellido");
        final String Registrar_nombre_usuario = getIntent().getStringExtra("Registrar_nombre_usuario");
        final String Registrar_email = getIntent().getStringExtra("Registrar_email");
        final String Registrar_numero_tel = getIntent().getStringExtra("Registrar_numero_tel");

        if(pass.length() == 0 || confirm_pass.length() == 0){
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
        }
        else if(pass.length() > 6 && confirm_pass.length() > 6){////////////////////// CONECTAR A LA BASE DE DATOS

            if(pass.contentEquals(confirm_pass)){

                /*//////////////////////////SE CONECTA A FIREBASE///////////////////////////////////////
                firebaseAuth = FirebaseAuth.getInstance();


                firebaseAuth.createUserWithEmailAndPassword(Registrar_email, confirm_pass)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    //////////////////////////////////////////////////////////////////////////

                                    FirebaseUser user = firebaseAuth.getCurrentUser();
                                    user.sendEmailVerification();

                                    ///////////////Se conecta a mysql y se agrega a tabla usuario////////////////
                                    String new_url= URL + "?nombre="+Registrar_nombre+"&apellido="+Registrar_apellido+"&usuario="+Registrar_nombre_usuario+"&email="+Registrar_email+"&numero_celular="+Registrar_numero_tel+"&password="+confirm_pass;
                                    StringRequest stringRequest= new StringRequest(Request.Method.POST, new_url, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_LONG).show();
                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                                        }
                                    });
                                    RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                                    requestQueue.add(stringRequest);

                                    ///VUELVE A LA PAGINA DE INICIO UNA VEZ QUE SE REGISTRA
                                    Intent volver_inicio = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(volver_inicio);

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(getApplicationContext(), task.toString(), Toast.LENGTH_LONG).show();
                                }

                            }
                        });

                 */
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_LONG).show();
                Intent volver_inicio = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(volver_inicio);
            }
            else{
                Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"La contraseña debe tener mas de 6 caracteres",Toast.LENGTH_LONG).show();
        }

    }
    //metodo para volver atras registro
    public void Volver_atras_registro(View view){
        Intent volver_atras = new Intent(this, Activity_Registro.class);
        startActivity(volver_atras);
    }
}


