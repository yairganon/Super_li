package com.Super_li.BL;

import java.util.List;

import com.Super_li.Backend.Driver;
import com.Super_li.DataBase.SQLiteJDBC;

public class DriverController {
	SQLiteJDBC db_Sql;
	public DriverController(SQLiteJDBC db_Sql) {
		this.db_Sql = db_Sql;
	}
	public boolean addDriver(Driver driver){
		return db_Sql.add(driver);
	}
	public boolean updateDriver(Driver driver){
		return db_Sql.update(driver);
	}
	public Driver isExists(int id){
		Driver d = new Driver(id);
		return db_Sql.isExists(d)==null?null:(Driver) db_Sql.isExists(d);
	}
	public boolean deleteDriver(Driver driver){
		return db_Sql.delete(driver);
	}
	
	public List<Driver> getAllDrivers(){
		return db_Sql.getAllDrivers();
	}
}