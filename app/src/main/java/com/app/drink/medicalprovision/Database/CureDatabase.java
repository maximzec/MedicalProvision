package com.app.drink.medicalprovision.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Cure.class} , version = 1)
public abstract class CureDatabase extends RoomDatabase {
    public abstract CureDao cureDao();
}
