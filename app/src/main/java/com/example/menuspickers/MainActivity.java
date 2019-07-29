package com.example.menuspickers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String []countryList = {"India", "Canada", "Brazil", "Russia", "China", "USA", "UK", "India", "Canada", "Brazil", "Russia", "China", "USA", "UK"};
    private Spinner spinnerCountry;
    private AutoCompleteTextView autoCompleteTextView;
    private Button btnShowContextMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryList = getResources().getStringArray(R.array.arrayCountry);

        spinnerCountry = findViewById(R.id.spinnerCountry);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        btnShowContextMenu = findViewById(R.id.btnShowContextMenu);

        registerForContextMenu(btnShowContextMenu);

        btnShowContextMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setPopOverMenuOnButton();
            }
        });

        ArrayAdapter<String>mStringArrayAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item, countryList);

        spinnerCountry.setAdapter(mStringArrayAdapter);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(MainActivity.this, countryList[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                Toast.makeText(MainActivity.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setPopOverMenuOnButton()
    {
        btnShowContextMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, btnShowContextMenu);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.poupup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });//closing the setOnClickListener method
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.mnu_Add:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnu_Delete:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnu_Next:
                Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnu_Update:
                Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        menu.setHeaderTitle("Select The Action");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.mnu_Add:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnu_Delete:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnu_Next:
                Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnu_Update:
                Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onContextItemSelected(item);
    }
}




