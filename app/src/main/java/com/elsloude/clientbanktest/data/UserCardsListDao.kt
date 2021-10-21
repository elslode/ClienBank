package com.elsloude.clientbanktest.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.elsloude.clientbanktest.data.card_holder.pojo.User

@Dao
interface UserCardsListDao {

    @Query("SELECT * FROM cards_user")
    fun getCardsList(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsersList(update: List<User>)

    @Query("SELECT * FROM cards_user")
    fun getAllUsers():List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(card: User)

    @Query("select * from cards_user where isChecked =:flag")
    fun getIsCheckedCard(flag: Boolean): LiveData<List<User>>

    @Query("select * from cards_user where cardNumber =:userCard")
    fun getUser(userCard: String): User
}