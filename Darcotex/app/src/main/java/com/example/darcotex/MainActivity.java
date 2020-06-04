package com.example.darcotex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.CallableStatement;
import java.sql.Types;

public class MainActivity extends AppCompatActivity {



    //DECLARAMOS VARIABLES DE MAIN ACTIVITY
    private FirebaseAuth firebaseAuth;
    private static final int REQUEST_CALL = 1;
    private EditText edit_inicio_Usuario, edit_inicio_pass;
    Button edit_btn_llamar;
    //String URL="http://192.168.56.1:8081/CursoAndroid/consulta.php"; //CONEXION a BASE DE DATOS


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_inicio_Usuario = (EditText)findViewById(R.id.inicio_Usuario);
        edit_inicio_pass = (EditText)findViewById(R.id.inicio_pass);
        edit_btn_llamar = (Button)findViewById(R.id.btn_llamar);
        edit_btn_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                    return;
                }
                else{
                    Intent llamar = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+56212345678"));
                    startActivity(llamar);
                }

            }
        });

    }


    //METODO PARA BOTON INICIO SESION
    public void Inicio_sesion(View view){

        String Usuario = edit_inicio_Usuario.getText().toString();
        final String Password = edit_inicio_pass.getText().toString();

        if(Usuario.length() == 0){
            Toast.makeText(this, "Debes ingresar tu nombre de usuario", Toast.LENGTH_LONG).show();
        }
        else if(Password.length() == 0){
            Toast.makeText(this, "Debes ingresar tu contraseña", Toast.LENGTH_LONG).show();
        }
        else if (Usuario.length() == 0 && Password.length() == 0){
            Toast.makeText(this, "Debes llenar los campos", Toast.LENGTH_LONG).show();
        }
        else { //AQUI ES CUANDO PUEDE INICIAR SESION///////////////////////////////////////////////////////////////////

            /*String new_url= URL + "?usuario="+Usuario+"&password="+Password;
            JsonArrayRequest jsonarrayrequest = new JsonArrayRequest(new_url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try {
                        final String email = response.getString(4);
                        firebaseAuth = FirebaseAuth.getInstance();
                        firebaseAuth.signInWithEmailAndPassword(email, Password)
                                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        FirebaseUser user = firebaseAuth.getCurrentUser();

                                        if (!user.isEmailVerified()) {
                                            Toast.makeText(MainActivity.this, "Debe verificar email para poder iniciar sesion", Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            Toast.makeText(MainActivity.this, "Listo, registro completo" , Toast.LENGTH_SHORT).show();

                                            /////////////////////   EMPLEADOS          //////////////////////////////////////////////////
                                            Intent inicio_sesion_clientes = new Intent(getApplicationContext(), Menu_Activity.class);
                                            startActivity(inicio_sesion_clientes);
                                            //////////////////////////////////////////////////////////////////////////////////////////
                                        }
                                    }
                                });


                    }catch (Exception e){

                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), "ERROR EN LA CONEXION", Toast.LENGTH_LONG).show();
                }
            }
            );
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(jsonarrayrequest);*/

            Intent inicio_sesion_clientes = new Intent(getApplicationContext(), Menu_Activity.class);
            startActivity(inicio_sesion_clientes);
        }
    }


    //METODO PARA BOTON REGISTRO
    public void Registro(View view){
        Intent registro = new Intent(this, Activity_Registro.class);
        startActivity(registro);
    }


}
