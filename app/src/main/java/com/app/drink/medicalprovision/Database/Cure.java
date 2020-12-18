package com.app.drink.medicalprovision.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cure {


    public Cure(@NonNull String cureName, int quantity , String description) {
        this.cureName = cureName;
        this.description = description;
        this.quantity = quantity;
    }

    @ColumnInfo(name = "cureName")
    @PrimaryKey
    @NonNull
    public String cureName;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "quantity")
    public int quantity;


}
