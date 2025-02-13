package com.example.gobig;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FullScreenActivity extends AppCompatActivity {
    private TextView displayText;
    private boolean isDarkMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        // Force landscape orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        displayText = findViewById(R.id.fullscreen_text);
        String message = getIntent().getStringExtra("DISPLAY_TEXT");

        // Configure text display
        displayText.setText(message);
        displayText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 72); // 72sp = extra large
        displayText.setTypeface(null, Typeface.BOLD);

        // Toggle colors on click
        displayText.setOnClickListener(v -> toggleColors());
    }

    private void toggleColors() {
        isDarkMode = !isDarkMode;
        if(isDarkMode) {
            displayText.setTextColor(Color.WHITE);
            getWindow().getDecorView().setBackgroundColor(Color.BLACK);
        } else {
            displayText.setTextColor(Color.BLACK);
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        }
    }
}
