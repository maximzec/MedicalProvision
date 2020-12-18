package com.app.drink.medicalprovision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.drink.medicalprovision.Database.Cure;
import com.app.drink.medicalprovision.Database.CureDatabase;

public class AddingCure extends AppCompatActivity {
    public EditText editName, editDescription, editQuantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_cure);
        final CureDatabase cureDatabase = Room.databaseBuilder(getApplicationContext() , CureDatabase.class , "cure").build();

        editName = findViewById(R.id.editName);
        editDescription = findViewById(R.id.editDescription);
        editQuantity = findViewById(R.id.editQuantity);

        Button addCure = findViewById(R.id.addCure);
        addCure.setOnClickListener(new View.OnClickListener() {
            Cure cure;
            @Override
            public void onClick(View v) {

                if(editName.getText().length() == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Имя обязательно!" , Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                cure = new Cure(editName.getEditableText().toString(), Integer.parseInt(editQuantity.getEditableText().toString()) , editDescription.getEditableText().toString());
                                cureDatabase.cureDao().insertCure(cure);
                            }catch (Exception e){
                                Toast toast = Toast.makeText(getApplicationContext(), "Упс! Что-то пошло не так", Toast.LENGTH_SHORT);
                            }

                        }
                    });
                    Toast toastShow = Toast.makeText(getApplicationContext(), "Загрузили!" , Toast.LENGTH_SHORT);
                    toastShow.show();
                    editName.setText("");
                    editDescription.setText("");
                    editQuantity.setText("");
                }
            }
        });
    }
}
