package it.spacecoding.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText userMessage;
    Button mButton;
    CheckBox remember;
    Button mButtonSave;
    int count = 0;
    String name;
    String message;
    boolean isChecked;
    SharedPreferences mSharedPreferences;
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
        mButton = findViewById(R.id.button);
        remember = findViewById(R.id.checkBox);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                mButton.setText(String.valueOf(count));
            }
        });
        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();

    }
    public void saveData() {
        // Context.MODE_PRIVATE -> memorizza le informazioni ma non le rende accessibili ad altre applicazioni
        mSharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        name = userName.getText().toString();
        message = userMessage.getText().toString();
        isChecked = remember.isChecked();
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("key name", name);
        editor.putString("key message", message);
        editor.putInt("key count", count);
        editor.putBoolean("key remember", isChecked);
        editor.commit(); // scrive i dati in memoria
        Toast.makeText(getApplicationContext(), "Your data has been Saved", Toast.LENGTH_SHORT).show();
    }
}