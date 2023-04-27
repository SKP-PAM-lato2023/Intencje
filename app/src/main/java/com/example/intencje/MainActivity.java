package com.example.intencje;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Activity2.class);
                intent.putExtra("Wartosc1", 2.3 );
                intent.putExtra("Wartosc2", "tekst");
                startActivity(intent);
            }
        });


        ActivityResultLauncher<Intent> getResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // pobieram dane
                        Intent intent = result.getData();
                        if(intent != null){
                            CharSequence imie = intent.getCharSequenceExtra("Imie");
                            Toast.makeText(getBaseContext(), String.format("Witaj %s !", imie),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        Button logowanie = findViewById(R.id.button3);
        logowanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Logowanie.class);
                getResult.launch(intent);
            }
        });
    }
}