package com.example.everythingminecraft;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //defining the field
    String searchString;

    //declaring generic variables for page items
    EditText search;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting variables for page items
        search = findViewById(R.id.edtxt_searchMain);
        searchButton = findViewById(R.id.btn_searchMain);

        //check if what the user searched is actually in the database
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get text from editText
                searchString = search.getText().toString().trim();

                //call method to search available pages
                SearchDatabase(searchString);
            }
        });
    }

    /*
        SearchDatabase - Contains a switch statement with all available pages to
        make navigation easy for the user

        String searchString - retrieves the string from the editText with the users search
     */
    public void SearchDatabase(String searchString)
    {
        switch(searchString)
        {
            case "Dirt":
                //launch dirt page
                Toast.makeText(this, "Launching dirt page", Toast.LENGTH_SHORT).show();
                LaunchPage(Dirt.class);
                break;


            default:
                Toast.makeText(this, getString(R.string.unimplemented_feature), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /*
        LaunchPage - Adds easy access to launch the next activity needed by reusing the launching
        code making it maintainable and scalable

        Class<?> pageNameClass - The activity's java class name + .class
     */
    public void LaunchPage(Class<?> pageNameClass)
    {
        Intent intent = new Intent(MainActivity.this, pageNameClass);
        startActivity(intent);
    }
}