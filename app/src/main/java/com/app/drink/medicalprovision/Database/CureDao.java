package com.app.drink.medicalprovision.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CureDao {
    @Query("SELECT * FROM cure")
    List<Cure> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCure(Cure cure);

    @Update
    void updateCure(Cure cure);

    @Query("SELECT cureName FROM cure")
    List<String> getCureName();

    @Query("SELECT * FROM cure WHERE cureName = :cureNameSearching")
    Cure getCureByName(String cureNameSearching);
}
