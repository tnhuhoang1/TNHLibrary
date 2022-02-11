package com.tnh.tnhlibrary.room

import androidx.room.*

@Dao
interface BaseDao<MODEL>{
    /**
     * insert one object into table in the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(data: MODEL)

    /**
     * insert one or more objects into table in the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg data: MODEL)

    /**
     * delete one object in database
     *
     * @return the number of rows that were deleted, in this case (0, 1)
     */
    @Delete
    suspend fun deleteOne(data: MODEL): Int

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