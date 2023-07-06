package ch.francescoryu.momentsaver;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LocationDao {
    @Query("SELECT * FROM location")
    List<LocationEntity> getAll();

    @Query("SELECT * FROM location WHERE locationId IN (:locationIds)")
    List<LocationEntity> loadAllByIds(int[] locationIds);

    @Insert
    void insertAll(LocationEntity... locationEntities);
}
