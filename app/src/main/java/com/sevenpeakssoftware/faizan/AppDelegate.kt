package com.sevenpeakssoftware.faizan

import android.app.Application
import com.sevenpeakssoftware.faizan.repo.ArticleRepository
import com.sevenpeakssoftware.faizan.repo.ArticleRoomDatabase
import timber.log.Timber

class AppDelegate : Application() {

    private val database by lazy { ArticleRoomDatabase.getDatabase(this) }
    val articleRepository by lazy { ArticleRepository(database.articleDao()) }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}