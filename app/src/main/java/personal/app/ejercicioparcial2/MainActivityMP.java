package personal.app.ejercicioparcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import personal.app.ejercicioparcial2.adapterMP.ContactoMPadapter;
import personal.app.ejercicioparcial2.daoMP.ContactoMPDAO;
import personal.app.ejercicioparcial2.daoMP.ContactoMPDAOImpRoom;
import personal.app.ejercicioparcial2.modelMP.ContactoMP;

public class MainActivityMP extends AppCompatActivity {

    String nombre= null;
    String numero=null;
    TextView Bienvenida;

    FloatingActionButton btnNuevaTarea;
    RecyclerView rwTareas;
    List<ContactoMP> tareas;


    ContactoMPDAO dao;

    public static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            sharedPreferences = getSharedPreferences("Configuracion", MODE_PRIVATE);
            nombre= (sharedPreferences.getString("Nombre", null));
            numero=(sharedPreferences.getString("Numero", null));
            if(nombre==null && numero== null){

                Intent intent= new Intent (this, RegistrarPropietarioMP.class);
                startActivity(intent);

            }else{
                Bienvenida=(TextView) findViewById(R.id.Bienvenida);
                Bienvenida.setText("Bienvenido "+nombre);

                dao=new ContactoMPDAOImpRoom(getApplicationContext());

                this.btnNuevaTarea=(FloatingActionButton) findViewById(R.id.btnNuevaTarea);
                this.rwTareas=(RecyclerView) findViewById(R.id.rwTareas);

                Intent intent=new Intent(this, NuevoContactoMP.class);

                //eventos
                this.btnNuevaTarea.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(intent);
                    }
                });

                this.cargarDatos();

                ContactoMPadapter adapter=new ContactoMPadapter(this.tareas,getApplicationContext(),dao);

                rwTareas.setLayoutManager(new LinearLayoutManager(this));

                rwTareas.setAdapter(adapter);
            }
        }catch(Exception e){
            Toast.makeText(this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    void  cargarDatos(){
        tareas=new ArrayList<ContactoMP>();
        tareas=dao.getAll();
    }


    public  void IrActualizar(View view)
    {
        Intent intent= new Intent (this, RegistrarPropietarioMP.class);
        startActivity(intent);
    }

}