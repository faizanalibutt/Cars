package com.sevenpeakssoftware.faizan.repo

import android.content.Context
import android.net.ConnectivityManager
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sevenpeakssoftware.faizan.model.CarArticle
import com.sevenpeakssoftware.faizan.model.Converter

// Annotates class to be a Room Database with a table (entity) of the Article class
@Database(entities = [CarArticle::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ArticleRoomDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE: ArticleRoomDatabase? = null

        fun getDatabase(context: Context): ArticleRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        ArticleRoomDatabase::class.java,
                        "article_database"
                    ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

fun Context.isOnline(): Boolean {
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}