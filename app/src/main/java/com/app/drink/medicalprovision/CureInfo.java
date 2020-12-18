package com.app.drink.medicalprovision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.app.drink.medicalprovision.Database.Cure;
import com.app.drink.medicalprovision.Database.CureDatabase;

public class CureInfo extends AppCompatActivity {

    TextView cureName;
    TextView cureQuantity;
    TextView cureDescription;

    Cure cure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cure_info);

        final CureDatabase cureDatabase = Room.databaseBuilder(getApplicationContext() , CureDatabase.class , "cure").allowMainThreadQueries().build();

        cureName = findViewById(R.id.cureName);
        cureQuantity = findViewById(R.id.cureQuantity);
        cureDescription = findViewById(R.id.cureDescription);

        Bundle arguments = getIntent().getExtras();
        final String cureNameKey = arguments.get("selectedCure").toString();
        cure = cureDatabase.cureDao().getCureByName(cureNameKey);


        try{
            cureName.setText(cure.cureName);
            cureQuantity.setText(String.valueOf(cure.quantity));
            cureDescription.setText(cure.description);

        }catch (NullPointerException e) {
            Toast toast = Toast.makeText(getApplicationContext(), "ВСЕ ПОШЛО НЕ ТАК!" , Toast.LENGTH_SHORT);
            toast.show();
        }


    }
}
