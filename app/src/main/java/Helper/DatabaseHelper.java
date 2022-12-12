package Helper;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.a111.DataViewerActivity;

import java.util.List;

import Databases.DatabaseClient;
import Databases.StudentTable;

public class DatabaseHelper {
Context context;

    public DatabaseHelper(Context context) {
        this.context = context;
    }

    public static DatabaseHelper getInstance(Context context) {
        return new DatabaseHelper(context);
    }
    public void addNewStudent(String stu_name,String stu_standard){
        class NewStudent extends AsyncTask<Void,Void,StudentTable> {

            @Override
            protected StudentTable doInBackground(Void... voids) {
                StudentTable studentTable=new StudentTable();
                studentTable.setStu_name(stu_name);
                studentTable.setStu_standard(stu_standard);
                DatabaseClient.getInstance(context)
                        .getStudentsDatabase()
                        .studentDAO()
                        .insertData(studentTable);
                return studentTable;
            }

            @Override
            protected void onPostExecute(StudentTable studentTable) {
                super.onPostExecute(studentTable);
                if (studentTable!=null){
                    Toast.makeText(context, studentTable.getStu_name()+"\n"+studentTable.getStu_standard(), Toast.LENGTH_SHORT).show();
                }
            }
        }

     NewStudent newStudent=new NewStudent();
        newStudent.execute();
        }
        //show all data
    public void getAllStudentsData(){
        class AllStudents extends AsyncTask<Void,Void,List<StudentTable>>{

            @Override
            protected List<StudentTable> doInBackground(Void... voids) {
                List<StudentTable> list =DatabaseClient.getInstance(context)
                        .getStudentsDatabase()
                        .studentDAO()
                        .selectAll();
                return list;
            }

            @Override
            protected void onPostExecute(List<StudentTable> studentTables) {
                super.onPostExecute(studentTables);
                if (studentTables!=null && studentTables.size()>0){
                    ((DataViewerActivity)context).setRecycler_view(studentTables);
                }

            }
        }
        AllStudents allStudents=new AllStudents();
        allStudents.execute();
    }

    }

