package com.micromap.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.micromap.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


public class DBManager {
    private String PACKAGE_NAME = "com.cucmap";
    private String DB_NAME = "cucmap.db3";
    private String DB_PATH = "/data";
    private static DBManager instance;

    private int BUFFER_SIZE = 4000;
    
    private SQLiteDatabase database;
    private Context context;
    
    private DBManager(Context context){
    	this.DB_PATH += Environment.getDataDirectory().getAbsolutePath();
    	this.DB_PATH += "/" + PACKAGE_NAME + "/databases";
    	this.context = context;
        database = openDatabase(DB_PATH + "/" + DB_NAME);
    }
    
    /*
	 * 如果数据库存在，打开数据库，否则从raw中读取数据库
	 */
    private SQLiteDatabase openDatabase(String db_name){
    	/*
    	 * 在测试阶段，每次都重新更新数据库
    	 */
    	try {
			if(!(new File(db_name).exists())){
				if(! new File(this.DB_PATH).exists()){
					new File(this.DB_PATH).mkdir();
				}
				InputStream is = context.getResources().openRawResource(R.raw.cucmap);
				FileOutputStream out = new FileOutputStream(db_name);
				byte buffer[] = new byte[BUFFER_SIZE];
				int length = 0;
				while((length = is.read(buffer)) > 0 ){
					out.write(buffer,0,length);
				}
				out.close();
				is.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		Log.i("Path-->",this.DB_PATH);
		SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(db_name,null);
		this.database = database;
		return database;
    }
    
    public static synchronized DBManager getInstance(Context context){
        if(instance == null){
            instance = new DBManager(context);
        }
    	return instance;
    }

	public SQLiteDatabase getDatabase() {
		return database;
	}
}

