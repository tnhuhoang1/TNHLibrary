package com.tnh.tnhlibrary.room

import androidx.room.*

@Dao
interface BaseDao<MODEL>{
    /**
     * insert one object into table in the database
     *
     * If the object already exists in table, place it
     *
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(data: MODEL)

    /**
     * insert one or more objects into table in the database, replace if exists
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg data: MODEL)

    /**
     * insert on object into table if it is not exists
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOneIfNotExists(data: MODEL)

    /**
     * insert one or more objects into table if it is not exists
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllIfNotExists(data: MODEL)

    /**
     * delete one object in database
     *
     * @return the number of rows that were deleted, in this case (0, 1)
     */
    @Delete
    suspend fun deleteOne(data: MODEL): Int

    /**
     * delete one or more objects in database
     *
     * @return the number of rows that were deleted
     */
    @Delete
    suspend fun deleteAll(vararg data: MODEL): Int

    /**
     * update one object in database
     *
     * @return the number of rows that were updated, in this case (0, 1)
     */
    @Update
    suspend fun updateOne(data: MODEL): Int

    /**
     * update one or more objects in database
     *
     * @return the number of rows the were updated
     */
    @Update
    suspend fun updateAll(vararg data: MODEL)
}