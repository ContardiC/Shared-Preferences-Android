package it.spacecoding.sharedpreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText userMessage;
    Button counter;
    CheckBox remember;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        userName = findViewById(R.id.editTextName);
        userMessage = findViewById(R.id.editTextMessage);
        counter = findViewById(R.id.button);
        remember = findViewById(R.id.checkBox);

        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                counter.setText(String.valueOf(count));
            }
        });

    }
}