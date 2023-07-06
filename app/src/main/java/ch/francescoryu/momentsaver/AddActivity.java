package ch.francescoryu.momentsaver;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;


public class AddActivity extends AppCompatActivity {

    String title;
    String desc;
    double laditudeDouble;
    double longitudeDouble;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlocation);

        Bundle extras = getIntent().getExtras();
        TextView laditude = findViewById(R.id.latitude);
        TextView longitude = findViewById(R.id.longitude);

        laditude.setText("Laditude: " + extras.getDouble("laditude"));
        longitude.setText("Longitude: " + extras.getDouble("longitude"));

        TextView titleTextView = findViewById(R.id.inputTitle);
        TextView descTextView = findViewById(R.id.desc);

        title = String.valueOf(titleTextView.getText());
        desc = String.valueOf(descTextView.getText());
        laditudeDouble = extras.getDouble("laditude");
        longitudeDouble = extras.getDouble("longitude");
        System.out.println(title + desc + laditudeDouble + longitudeDouble);
    }
}