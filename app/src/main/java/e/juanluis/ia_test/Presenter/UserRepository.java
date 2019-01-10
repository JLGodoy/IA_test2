package e.juanluis.ia_test.Presenter;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import e.juanluis.ia_test.Data.UserDAO;
import e.juanluis.ia_test.Data.UserDB;
import e.juanluis.ia_test.Data.UserModel;

public class UserRepository {

    private UserDAO userDAO;
    private LiveData<List<UserModel>> allData;

    public UserRepository(Application app){
        UserDB userDB= UserDB.getDatabase(app);
        userDAO = userDB.userDAO();
        allData = userDAO.getDetails();
    }

    public LiveData<List<UserModel>> getAllData(){
        return allData;
    }

    public void insertData(UserModel data) {
        new UserInsertion(userDAO).execute(data);
    }

    private static class UserInsertion extends AsyncTask<UserModel, Void, Void>{

        private UserDAO userDAO;
        private UserInsertion(UserDAO userDAO){
            this.userDAO = userDAO;
        }
        @Override
        protected Void doInBackground(UserModel... data) {
            userDAO.deleteData();
            userDAO.insertUser(data[0]);
            return null;

        }


    }
}
