package personal.app.ejercicioparcial2.adapterMP;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import personal.app.ejercicioparcial2.NuevoContactoMP;
import personal.app.ejercicioparcial2.R;
import personal.app.ejercicioparcial2.daoMP.ContactoMPDAO;
import personal.app.ejercicioparcial2.modelMP.ContactoMP;

public class ContactoMPadapter extends RecyclerView.Adapter<ContactoMPadapter.ViewHolder>{
    List<ContactoMP> contactos;
    Context context;
    ContactoMPDAO dao;


    @NonNull
    @Override
    public ContactoMPadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto,parent,false);
        ViewHolder vh = new ViewHolder(v, context);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoMPadapter.ViewHolder holder, int position) {
        ContactoMP p = contactos.get(position);
        holder.tvId.setText(""+p.getId());
        holder.tvNombre.setText(p.getNombre());
        holder.tvNumero.setText(p.getNumero());
        holder.tvPropietario.setText(p.getPropietario());

        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delete(p);
                contactos = dao.getAll();
                notifyDataSetChanged();
                Toast.makeText(context.getApplicationContext(),"ELiminado",Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NuevoContactoMP.class);
                intent.putExtra("estado",1);
                intent.putExtra("contacto", p);
                intent.putExtra("numero", p);
                intent.putExtra("propietario", p);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        private TextView tvId, tvNombre, tvNumero, tvPropietario;
        private Button btnModificar, btnEliminar;
        private Context context;

        public  ViewHolder(View view,Context context){
            super(view);
            tvId=(TextView) view.findViewById(R.id.txtId);
            tvNombre=(TextView) view.findViewById(R.id.txtNombre);
            tvNumero=(TextView) view.findViewById(R.id.txtNumero);
            tvPropietario=(TextView) view.findViewById(R.id.txtPropietario);
            btnModificar=(Button) view.findViewById(R.id.btnModificar);

            btnEliminar=(Button) view.findViewById(R.id.btnEliminar);

            this.context=context;

        }
    }

    public ContactoMPadapter(List<ContactoMP> contacts, Context context, ContactoMPDAO dao) {
        this.context = context;
        this.contactos = contacts;
        this.dao = dao;
    }

}
