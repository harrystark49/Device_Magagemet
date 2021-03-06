package com.example.mini_proect.DataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context,"DeviceManagement",null,2) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ADD_EMPLOYEE(ID VARCHAR2 PRIMARY KEY,NAME VARCHAR2,EMAIL VARCHAR2,PASSWORD VARCAHR2,MOBILE VARCHAR2)")

        db?.execSQL("CREATE TABLE ADD_ADMIN(ID VARCHAR2 PRIMARY KEY,NAME VARCHAR2,EMAIL VARCHAR2,PASSWORD VARCAHR2,MOBILE VARCHAR2)")

        db?.execSQL("CREATE TABLE REQUESTED_DEVICES(EMAIL VARCHAR2,DEVICE_ID VARCHAR2,MANUFACTURE VARCHAR2,OS_TYPE VARCAHR2,VERSION VARCHAR2,PHN_TYPE VARCHAR2)")

        db?.execSQL("CREATE TABLE ACCEPTED_DEVICES(DEVICE_ID VARCHAR2,EMP_ID VARCHAR2,START_TIME VARCHAR2)")

        db?.execSQL("CREATE TABLE DEVICE_HISTORY(DEVICE_ID VARCHAR2,EMP_ID VARCHAR2,START_TIME VARCHAR2,END_TIME VARCHAR2)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}