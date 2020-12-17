package com.app.drink.medicalprovision.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cure {

    public Cure(@NonNull String cureName, String description, int quantity) {
        this.cureName = cureName;
        this.description = description;
        this.quantity = quantity;
    }

    @PrimaryKey
    @NonNull
    public String cureName;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "quantity")
    public int quantity;


}
