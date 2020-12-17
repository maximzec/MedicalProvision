package com.app.drink.medicalprovision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.app.drink.medicalprovision.Database.Cure;
import com.app.drink.medicalprovision.Database.CureDatabase;

import java.nio.file.Watchable;
import java.util.Comparator;
import java.util.List;

public class MedicalList extends AppCompatActivity {
    List<String> cureNamesList;
    ListView cureListView;
    EditText search;
    ArrayAdapter<String> cureAdapter;
    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_list);
        search = findViewById(R.id.search);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        final CureDatabase cureDatabase = Room.databaseBuilder(getApplicationContext() , CureDatabase.class , "cure").build();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try{
                  cureNamesList  =  cureDatabase.cureDao().getCureName();
                }catch (Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Что-то пошло не так", Toast.LENGTH_SHORT );
                    toast.show();
                }
            }
        });
        cureListView = findViewById(R.id.cureList);
        cureAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, names);
        cureListView.setAdapter(cureAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        MedicalList.this.cureAdapter.sort(new Comparator<String>() {
                            @Override
                            public int compare(String o1, String o2) {
                                return o1.compareTo(o2);
                            }
                        });
                        break;
                    }
                    case 1:{
                        MedicalList.this.cureAdapter.sort(new Comparator<String>() {
                            @Override
                            public int compare(String o1, String o2) {
                                return o2.compareTo(o1);
                            }
                        });
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                MedicalList.this.cureAdapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Button btnAddCure = findViewById(R.id.buttonAdd);
        btnAddCure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalList.this, AddingCure.class);
                MedicalList.this.startActivity(intent);
            }
        });
    }
}
