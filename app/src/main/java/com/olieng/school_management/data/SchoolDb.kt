//package com.olieng.school_management.data
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import com.olieng.school_management.model.SchoolData
//
//@Database(entities = [SchoolData::class], version = 1)
//abstract class SchoolDb ::RoomDatabase(){
//    abstract fun schoolDao():SchoolDao
//    companion object{
//        private var database:SchoolDb?=null
//
//        fun getDataBase(context: Context):SchoolDb{
//            if (database==null){
//                database= Room
//                    .databaseBuilder(context,SchoolDb::class.java,"SchoolDb")
//                    .fallbackToDestructiveMigration()
//                    .build()
//            }
//            return database as SchoolDb
//        }
//    }
//}
package com.olieng.school_management.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.olieng.school_management.model.SchoolData

@Database(entities = [SchoolData::class], version = 1)
abstract class SchoolDb : RoomDatabase() { // Fixed syntax error
    abstract fun schoolDao(): SchoolDao

    companion object {
        @Volatile
        private var database: SchoolDb? = null

        fun getDatabase(context: Context): SchoolDb {
            return database ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(context.applicationContext, SchoolDb::class.java, "SchoolDb")
                    .fallbackToDestructiveMigration()
                    .build()
                database = instance
                instance
            }
        }
    }
}
