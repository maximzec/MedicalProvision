package com.app.drink.medicalprovision.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CureDao {
    @Query("SELECT * FROM cure")
    List<Cure> getAll();

    @Insert
    void insertCure(Cure cure);

    @Query("UPDATE cure SET quantity = cure.quantity WHERE cureName == cure.cureName")
    void updateCure(Cure cure);
}
