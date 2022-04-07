package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class Registro extends AppCompatActivity {

    //definimos los objetos

    private EditText Gmail;
    private EditText Contraseña;
    private Button registrar;
    private EditText ConfirmarCont;




    //declaramos el objeto firebase
   private FirebaseAuth mfirebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //inicializamos el objeto

        mfirebaseAuth = FirebaseAuth.getInstance();

        //referenciamos los view

        Gmail = (EditText) findViewById(R.id.Gmail);
        Contraseña = (EditText) findViewById(R.id.Contraseña);
        ConfirmarCont = (EditText) findViewById(R.id.ConfirmarContraseña);

        registrar = (Button) findViewById(R.id.Registrar);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //obtenemos los datos

                String email = Gmail.getText().toString().trim();
                String password = Contraseña.getText().toString().trim();
                String confirmpassword = ConfirmarCont.getText().toString().trim();

                if (!email.isEmpty()&&!password.isEmpty()&&!confirmpassword.isEmpty()){
                    if(password.equals(confirmpassword)){
                        if(password.length()>=6){

                            mfirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()){
                                        startActivity(new Intent(Registro.this, iniciarApp.class));
                                        finish();
                                    }else{
                                        Toast.makeText(Registro.this, "Intente otra vez", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Registro.this, "Error"+ e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnCanceledListener(new OnCanceledListener() {
                                @Override
                                public void onCanceled() {
                                    Toast.makeText(Registro.this, "Cancelado el registro, intente de nuevo", Toast.LENGTH_SHORT).show();
                                }
                            })

                            ;



                        }else{
                            Toast.makeText(Registro.this, "ingrese una contraseña con 6 o mas caracteres", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(Registro.this, "Verifique la contraseña", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(Registro.this, "", Toast.LENGTH_SHORT).show();
                }

            }
        });






    }


    //metodo siguiente boton Regresar
    public void Irmain(View view) {
        Intent Irmain = new Intent(this, MainActivity.class);
        startActivity(Irmain);
    }


}