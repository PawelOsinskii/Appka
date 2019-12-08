package com.example.appka;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Kody.db";
    public static final String Table_NAME1 = "kody_table";
    public static final String Table_NAME2 = "bufor_table";
    public static final String COL_1 = "Code"; //VARCHAR(50) NOT NULL
    public static final String COL_2 = "MaxEntryCount"; //INTEGER NOT NULL DEFAULT '1'
    public static final String COL_3 = "CurrentEntryCount"; //INTEGER NOT NULL DEFAULT '0'
    public static final String COL_4 = "Active"; //BOOLEAN NOT NULL DEFAULT '1'
    public static final String COL_5 = "LastEntry"; //TIMESTAMP DEFAULT NULL
    public static final String COL_6 = "ValidFrom"; //TIMESTAMP DEFAULT (strftime('%Y-%m-%d %H:%M:%f', '1900-01-01 00:00:00.001', 'localtime'))
    public static final String COL_7 = "ValidTo"; //TIMESTAMP DEFAULT (strftime('%Y-%m-%d %H:%M:%f', '1900-01-01 00:00:00.001', 'localtime'))
    public static final String COL_8 = "Sektor"; //VARCHAR(50) DEFAULT
    public static final String COL_9 = "Rzad"; //VARCHAR(50) DEFAULT
    public static final String COL_10 = "Miejsce"; //VARCHAR(50) DEFAULT
    public static final String COL_11 = "PESEL"; //VARCHAR(50) DEFAULT
    public static final String COL_12 = "Imie"; //VARCHAR(50) DEFAULT
    public static final String COL_13 = "Nazwisko"; //VARCHAR(50) DEFAULT
    public static final String COL_14 = "Opis"; //VARCHAR(50) DEFAULT
    public static final String COL_15 = "Typ"; //VARCHAR(50) DEFAULT
    public static final String COL_16 = "Numer"; //INTEGER NOT NULL DEFAULT '0'
    public static final String COL_17 = "Status"; //INTEGER NOT NULL DEFAULT '0'
    public static final String COL_18 = "Event"; //VARCHAR(250) DEFAULT '',PRIMARY KEY(Code))";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + Table_NAME1 +" (Code VARCHAR(50) NOT NULL, MaxEntryCount INTEGER NOT NULL DEFAULT '1', CurrentEntryCount INTEGER NOT NULL DEFAULT '0', Active BOOLEAN NOT NULL DEFAULT '1', " +
                "LastEntry TIMESTAMP DEFAULT NULL, ValidFrom TIMESTAMP DEFAULT (strftime('%Y-%m-%d %H:%M:%f', '1900-01-01 00:00:00.001', 'localtime')), ValidTo TIMESTAMP DEFAULT (strftime('%Y-%m-%d %H:%M:%f', '1900-01-01 00:00:00.001', 'localtime')), " +
                "Sektor VARCHAR(50) DEFAULT NULL, Rzad VARCHAR(50) DEFAULT NULL, Miejsce VARCHAR(50) DEFAULT NULL, PESEL VARCHAR(50) DEFAULT NULL, Imie VARCHAR(50) DEFAULT NULL, Nazwisko VARCHAR(50) DEFAULT NULL, Opis VARCHAR(50) DEFAULT NULL, Typ VARCHAR(50) DEFAULT NULL, Numer INTEGER NOT NULL DEFAULT '0', Status INTEGER NOT NULL DEFAULT '0',  Event VARCHAR(250) DEFAULT '')");

     //   db.execSQL();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+Table_NAME1);
        onCreate(db);

    }
    public boolean inserData(String code, String maxEntryCount, String currentEntryCount, String validFrom,
                             String validTo, String sektor, String rzad, String miejsce, String PESEL, String Imie,
                             String Nazwisko, String Opis, String typ, String Numer, String Status, String Event){



        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, code);
        contentValues.put(COL_2, maxEntryCount);
        contentValues.put(COL_3, currentEntryCount);
        //contentValues.put(COL_4, active);
        //contentValues.put(COL_5, lastEntry);
        contentValues.put(COL_6, validFrom);
        contentValues.put(COL_7, validTo);
        contentValues.put(COL_8, sektor);
        contentValues.put(COL_9, rzad);
        contentValues.put(COL_10, miejsce);
        contentValues.put(COL_11, PESEL);
        contentValues.put(COL_12, Imie);
        contentValues.put(COL_13, Nazwisko);
        contentValues.put(COL_14, Opis);
        contentValues.put(COL_15, typ);
        contentValues.put(COL_16, Numer);
        contentValues.put(COL_17, Status);
        contentValues.put(COL_18, Event);
        long restult = db.insert(Table_NAME1, null, contentValues);
        if(restult == -1)
            return false;
        return true;

    }
}
