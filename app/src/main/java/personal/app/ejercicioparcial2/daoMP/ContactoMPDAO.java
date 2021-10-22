package personal.app.ejercicioparcial2.daoMP;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import personal.app.ejercicioparcial2.modelMP.ContactoMP;

@Dao
public interface ContactoMPDAO {
    @Query("select * from contactos")
    public List<ContactoMP> getAll();

    @Query("select * from contactos where id = :id")
    public ContactoMP get(int id);

    @Insert
    public void save(ContactoMP entity);

    @Delete
    public void delete(ContactoMP entity);

    @Update
    public void update(ContactoMP entity);
}
