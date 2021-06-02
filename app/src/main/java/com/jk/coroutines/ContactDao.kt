package com.jk.coroutines

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact_table ORDER BY name ASC")
    fun getAlphabetizedWords(): Flow<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(contact: Contact)

    @Query("DELETE FROM contact_table")
     fun deleteAll()


    // run async and await the result
    suspend fun ContactDao.getAlphabetizedWords(): Flow<List<Contact>> =
            withContext(CoroutineScope(kotlinx.coroutines.Dispatchers.Default).coroutineContext) {
                getAlphabetizedWords()
            }

//    suspend fun ContactDao.insert(contact: Contact) =
//            withContext(CoroutineScope(kotlinx.coroutines.Dispatchers.Default).coroutineContext) {
//                insert(contact)
//            }
//
//    suspend fun ContactDao.deleteAll() =
//            withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
//                deleteAll()
//            }
}
