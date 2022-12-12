package Databases;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDAO {
    //for inserting data
    @Insert
    void insertData(StudentTable studentTable);
    //for getting all data
    @Query("SELECT * FROM studenttable")
    List<StudentTable> selectAll();


}
