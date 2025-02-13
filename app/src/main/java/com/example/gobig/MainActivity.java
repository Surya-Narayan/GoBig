package com.example.gobig;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity {

    private EditText inputText;
    private Button showButton;
    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        inputText = findViewById(R.id.inputText);
        showButton = findViewById(R.id.showButton);
        displayText = findViewById(R.id.displayText);

        // Set button click listener
        // In MainActivity's showButton onClickListener
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = inputText.getText().toString().trim();
                if (!message.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, FullScreenActivity.class);
                    intent.putExtra("DISPLAY_TEXT", message);
                    startActivity(intent);
                }
            }
        });


        // Hide the displayText when clicked
        displayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText.setVisibility(View.GONE);
                inputText.setText("");
            }
        });
    }
}
