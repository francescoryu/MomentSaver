package ch.francescoryu.momentsaver;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LocationDao {
    @Insert
    void insert(LocationEntity location);

    @Query("SELECT * FROM locationentity")
    List<LocationEntity> getAllLocations();

    // Add other database operations as needed
}
