package com.elsloude.clientbanktest.data

import android.app.Application
import androidx.room.*
import com.elsloude.clientbanktest.data.card_holder.Converters
import com.elsloude.clientbanktest.data.card_holder.pojo.CardsPlaceholderResponce
import com.elsloude.clientbanktest.data.card_holder.pojo.User

@Database(entities = [User::class], version = 13, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase()  {

    abstract fun userDao(): UserCardsListDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "shop_item.db"

        fun getInstance(application: Application): AppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK){
                INSTANCE?.let {
                    return it
                }
            }
            val db = Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                DB_NAME
            )
                .allowMainThreadQueries()
                .build()
            INSTANCE = db
            return db
        }
    }
}