package com.micromap.model;

import android.database.sqlite.SQLiteDatabase;

import com.micromap.core.map.model.FacilityMark;
import com.micromap.core.map.model.dao.FacilityMarkDao;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门查询API
 * @author Pingfu
 */
public class SearchFacilityUtil {
    public static List<FacilityMark> getFacilityMarksById(SQLiteDatabase database,
    		int id){
    	List<FacilityMark> facilityMarks = new ArrayList<FacilityMark>();
    	return facilityMarks;
    }
    
    /**
     * 根据名称查找Facility
     * @param database       数据库
     * @param name           要查找的Facility名称
     * @return facilityMarks 所有和名称name类似的Facility列表
     */
    public static List<FacilityMark> getFacilityMarkByName(String name,
    		SQLiteDatabase database){
    	List<FacilityMark> facilityMarks = new ArrayList<FacilityMark>();
    	facilityMarks = new FacilityMarkDao(database).getFacilityMarkByName(name);
    	return facilityMarks;
    }
    
    /**
     *根据类型查找Facility
     * @param database       数据库
     * @param name           要查找的Facility名称
     * @return facilityMarks 所有和名称name类似的Facility列表
     */
    public static List<FacilityMark> getFacilityMarkByType(int type,
    		SQLiteDatabase database){
    	List<FacilityMark> facilityMarks = new ArrayList<FacilityMark>();
    	facilityMarks = new FacilityMarkDao(database).getFacilityMarkByType(type);
    	return facilityMarks;
    }
}
