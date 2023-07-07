package ch.francescoryu.momentsaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.UUID;


public class AddActivity extends AppCompatActivity {

    double latitudeDouble;
    double longitudeDouble;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlocation);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "momentsaver").build();

        Bundle extras = getIntent().getExtras();
        TextView latitude = findViewById(R.id.latitude);
        TextView longitude = findViewById(R.id.longitude);

        latitude.setText("Latitude: " + extras.getDouble("latitude"));
        longitude.setText("Longitude: " + extras.getDouble("longitude"));

        TextView titleTextView = findViewById(R.id.inputTitle);
        TextView descTextView = findViewById(R.id.desc);

        //title = String.valueOf(titleTextView.getText());
        //desc = String.valueOf(descTextView.getText());
        latitudeDouble = extras.getDouble("latitude");
        longitudeDouble = extras.getDouble("longitude");

        Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(v -> {
            AsyncTask.execute(() -> {
                LocationEntity location = new LocationEntity();
                location.title = String.valueOf(titleTextView.getText());
                location.desc = String.valueOf(descTextView.getText());
                location.latitude = latitudeDouble;
                location.longitude = longitudeDouble;

                AppDatabase.getInstance(this).locationDao().insertAll(location);
                Intent firstAct = new Intent(this, MainActivity.class);
                startActivity(firstAct);
            });
        });
    }
}