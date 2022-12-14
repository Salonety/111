package Databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {StudentTable.class},version = 1)
public abstract class StudentsDatabase extends RoomDatabase {
    public abstract StudentDAO studentDAO();

}
