package br.com.alura.orgs.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.alura.orgs.database.convertor.Converters
import br.com.alura.orgs.database.dao.produtoDao
import br.com.alura.orgs.model.Produto

@Database(entities = [Produto::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun produtoDao(): produtoDao

    companion object {
        fun instancia(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context, AppDataBase::class.java, "orgs.db"
            ).allowMainThreadQueries()
                .build()
        }
    }
}