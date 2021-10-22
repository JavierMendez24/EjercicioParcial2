package personal.app.ejercicioparcial2.daoMP;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import personal.app.ejercicioparcial2.dataMP.DataBaseRoomMP;
import personal.app.ejercicioparcial2.modelMP.ContactoMP;

public class ContactoMPDAOImpRoom implements ContactoMPDAO{

    DataBaseRoomMP db;

    ContactoMPDAO dao;

    public ContactoMPDAOImpRoom(Context context){
        db= Room.databaseBuilder(context,DataBaseRoomMP.class,"db")
                .allowMainThreadQueries().build();
        dao=db.contactoFTDAO();
    }

    @Override
    public List<ContactoMP> getAll() {
        return dao.getAll();
    }

    @Override
    public ContactoMP get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(ContactoMP entity) {
        dao.save(entity);
    }

    @Override
    public void delete(ContactoMP entity) {
        dao.delete(entity);
    }

    @Override
    public void update(ContactoMP entity) {
        dao.update(entity);
    }
}
