package ch.francescoryu.momentsaver;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LocationEntity {
    @PrimaryKey
    public int locationId;

    @ColumnInfo(name = "location_name")
    public String locationName;

    // Add other columns as needed

    // Getters and setters
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}

