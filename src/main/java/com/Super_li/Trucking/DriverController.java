package com.Super_li.Trucking;

import com.Super_li.DataBase.DB_Sql;

public class DriverController {
	DB_Sql db_Sql;
	public DriverController(DB_Sql db_Sql) {
		this.db_Sql = db_Sql;
	}
	public boolean addDriver(String fullName , int id , char driverLicense){
		return db_Sql.addDriver(fullName,id,driverLicense);
	}
	public boolean UpdateDriver(int key,String fullName , int id , char driverLicense){
		return db_Sql.UpdateDriver(key,fullName,id,driverLicense);
	}
}
