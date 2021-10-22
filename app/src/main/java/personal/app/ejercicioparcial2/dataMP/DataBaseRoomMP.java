package personal.app.ejercicioparcial2.dataMP;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import personal.app.ejercicioparcial2.daoMP.ContactoMPDAO;
import personal.app.ejercicioparcial2.modelMP.ContactoMP;

@Database(entities = {ContactoMP.class}, version = 1)
public abstract class DataBaseRoomMP extends RoomDatabase {
    public abstract ContactoMPDAO contactoFTDAO ();
}
