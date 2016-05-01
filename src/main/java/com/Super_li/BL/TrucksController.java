package com.Super_li.BL;


import java.util.List;

import com.Super_li.Backend.Truck;
import com.Super_li.DataBase.SQLiteJDBC;
import com.Super_li.Backend.Driver;

public class TrucksController {
	SQLiteJDBC db_Sql;
	public TrucksController(SQLiteJDBC db_Sql) {
		this.db_Sql=db_Sql;
		
	}
	public boolean addNewTruck(Truck truck){
		return db_Sql.add(truck);
	}
	public List<Truck> getAll(){
		return db_Sql.getAllTrucks();
	}
	
	public Truck isExists(int id){
		Truck t = new Truck(id);
		return db_Sql.isExists(t)==null?null:(Truck)db_Sql.isExists(t);
	}
	
	public boolean update(Truck t){
		return this.db_Sql.update(t);
	}
	public boolean delete(Truck t) {
		return db_Sql.delete(t);
		
	}
}
