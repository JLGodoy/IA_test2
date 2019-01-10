package e.juanluis.ia_test.Data;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


@Dao
public interface UserDAO {

    @Insert
    void insertUser(UserModel data);

    @Query("select * from Users")
    LiveData<List<UserModel>>getDetails();

    @Query("DELETE from Users")
    void deleteData();
}
