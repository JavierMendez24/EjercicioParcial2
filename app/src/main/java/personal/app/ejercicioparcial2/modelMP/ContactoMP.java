package personal.app.ejercicioparcial2.modelMP;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "contactos")
public class ContactoMP implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int id;
    String nombre;
    String numero;
    String propietario;

    public ContactoMP(){

    }

    public ContactoMP(int id, String nombre, String numero, String propietario) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.propietario = propietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
