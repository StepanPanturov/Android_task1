package com.example.android_task1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OtherActivity extends AppCompatActivity {
    TextView greetingTextView;
    Button sendName;
    EditText enterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_other);
        greetingTextView = findViewById(R.id.greeting);
        enterName = findViewById(R.id.enterName);
        sendName = findViewById(R.id.sendName);
        String greeting = getIntent().getStringExtra("greeting");
        greetingTextView.setText(greeting);
        sendName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = enterName.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}