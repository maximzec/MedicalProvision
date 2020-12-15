package com.app.drink.medicalprovision.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cure {

    @PrimaryKey
    public String cureName;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "quantity")
    public int quantity;


}
