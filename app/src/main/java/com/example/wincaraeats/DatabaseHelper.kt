package com.example.wincaraeats

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DatabaseHelper (context: Context):
SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "UserManager.db"

        const val TABLE_USER = "user"
        const val COLUMN_USER_ID = "user_id"
        const val COLUMN_USER_FIRSTNAME = "user_firstname"
        const val COLUMN_USER_LASTNAME = "user_lastname"
        const val COLUMN_USER_PASSWORD = "user_password"
        const val COLUMN_USER_GENDER = "user_gender"
        const val COLUMN_USER_DEPARTMENT = " user_department"

    }

    override fun onCreate(db: SQLiteDatabase) {

        val createTableStatement = ("CREATE TABLE" + TABLE_USER + "("
                + COLUMN_USER_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_USER_FIRSTNAME + "TEXT,"
                + COLUMN_USER_LASTNAME + "TEXT,"
                + COLUMN_USER_PASSWORD + "TEXT,"
                + COLUMN_USER_GENDER + "TEXT,"
                + COLUMN_USER_DEPARTMENT + "TEXT" + ")")

        db.execSQL(createTableStatement)

    }
    override fun onUpgrade(db: SQLiteDatabase,oldVersion: Int,newVersion:Int){
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USER")
        onCreate(db)
    }
    fun addUser(userFirstname: String, userLastname: String,userPassword: String,userGender: String,userDepartment: String){
        val db=this.writableDatabase
        val values= ContentValues().apply{
            put(COLUMN_USER_FIRSTNAME,userFirstname)
            put(COLUMN_USER_LASTNAME,userLastname)
            put(COLUMN_USER_PASSWORD,userPassword)
            put(COLUMN_USER_GENDER,userGender)
            put(COLUMN_USER_DEPARTMENT,userDepartment)


        }

        db.insert(TABLE_USER, null, values)
        db.close()
    }
}
