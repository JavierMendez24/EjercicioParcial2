package personal.app.ejercicioparcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrarPropietarioMP extends AppCompatActivity {

    public static SharedPreferences sharedPreferences;
    EditText nombre,numero;
    Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_propietario_mp);

        sharedPreferences = getSharedPreferences("Configuracion", MODE_PRIVATE);



        nombre=(EditText) findViewById(R.id.Nombre);
        numero=(EditText) findViewById(R.id.Telefono);
        aceptar=(Button) findViewById(R.id.enviar);

        nombre.setText(sharedPreferences.getString("Nombre", " "));
        numero.setText(sharedPreferences.getString("Numero", " "));

    }

    public void Actualizar(View view)
    {

        SharedPreferences.Editor editorConfig = sharedPreferences.edit();
        editorConfig.putString("Nombre", nombre.getText().toString());
        editorConfig.putString("Numero", numero.getText().toString());

        editorConfig.commit();

        Intent intent= new Intent (RegistrarPropietarioMP.this, MainActivityMP.class);
        startActivity(intent);
        finish();
    }

}