// DBHandler.kt

package com.example.appsqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Cadastro"
        private const val TABLE_NAME = "Cliente"
        private const val KEY_NAME = "Nome"
        private const val KEY_ADDRESS = "Endereco"
        private const val KEY_NEIGHBORHOOD = "Bairro"
        private const val KEY_CEP = "CEP"
        private const val KEY_CITY = "Cidade"
        private const val KEY_STATE = "Estado"
        private const val KEY_PHONE = "Telefone"
        private const val KEY_CELLULAR = "celular"
    }

    fun addData(
        name: String,
        address: String,
        neighborhood: String,
        cep: String,
        city: String,
        state: String,
        phone: String,
        cellular: String
    ) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, name)
        values.put(KEY_ADDRESS, address)
        values.put(KEY_NEIGHBORHOOD, neighborhood)
        values.put(KEY_CEP, cep)
        values.put(KEY_CITY, city)
        values.put(KEY_STATE, state)
        values.put(KEY_PHONE, phone)
        values.put(KEY_CELLULAR, cellular)
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = ("CREATE TABLE $TABLE_NAME ($KEY_NAME TEXT, " +
                "$KEY_ADDRESS TEXT, " +
                "$KEY_NEIGHBORHOOD TEXT, " +
                "$KEY_CEP TEXT, " +
                "$KEY_CITY TEXT, " +
                "$KEY_STATE TEXT, " +
                "$KEY_PHONE TEXT, " +
                "$KEY_CELLULAR TEXT)")
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}
