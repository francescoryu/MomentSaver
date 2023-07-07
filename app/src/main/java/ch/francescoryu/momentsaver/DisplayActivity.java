package ch.francescoryu.momentsaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Bundle extras = getIntent().getExtras();

        TextView titleTextView = findViewById(R.id.title);
        titleTextView.setText(extras.getString("title"));

        TextView descTextView = findViewById(R.id.desc);
        descTextView.setText(extras.getString("desc"));

        TextView latTextView = findViewById(R.id.latitude);
        latTextView.setText("Latitude: " + String.valueOf(extras.getDouble("latitude")));

        TextView longTextView = findViewById(R.id.longitude);
        longTextView.setText("Longitude: " + String.valueOf(extras.getDouble("longitude")));

        Button cancelButton = findViewById(R.id.back);
        cancelButton.setOnClickListener(view -> {
            Intent mainAct = new Intent(this, MainActivity.class);
            startActivity(mainAct);
        });
    }
}