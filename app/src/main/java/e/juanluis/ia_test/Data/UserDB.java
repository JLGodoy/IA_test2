package e.juanluis.ia_test.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {UserModel.class}, version = 1)
public abstract class UserDB extends RoomDatabase {

    public abstract UserDAO userDAO();
    private static UserDB INSTANCE;


    public static UserDB getDatabase(final Context context){

        if (INSTANCE == null){
            synchronized (UserDB.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, UserDB.class, "User_Database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
