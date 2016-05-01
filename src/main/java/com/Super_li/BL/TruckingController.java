package com.Super_li.BL;

import java.util.List;

import com.Super_li.Backend.Driver;
import com.Super_li.Backend.IdB_Entity;
import com.Super_li.Backend.Moving;
import com.Super_li.Backend.Orders;
import com.Super_li.Backend.Place;
import com.Super_li.Backend.Truck;
import com.Super_li.DataBase.SQLiteJDBC;

public class TruckingController {
	SQLiteJDBC db_Sql;
	public TruckingController(SQLiteJDBC db_Sql) {
		this.db_Sql=db_Sql;
	}
	public boolean addMoving(Moving moving){
		boolean cont = db_Sql.add(moving);
		if(cont)
			db_Sql.setMovingID(moving);
		return cont;
	}
	public List<Truck> getAllTrucks() {
		return db_Sql.getAllTrucks();
	}
	public List<Driver> getAllDrivers(String truckLicense) {
		return db_Sql.getAllDrivers(truckLicense);

	}
	public List<Place> getAllAdress() {
		return db_Sql.getAlPlaces();

	}
	public List<Orders> getOrders(String sourcePlace) {
		List<Orders> list = db_Sql.getAllOrders();
		list.removeIf((order)-> order.getMovingId()!=-1 || !(order.getSourcePlace().equals(sourcePlace)));
		return list;
	}
	public void update(IdB_Entity o) {
		db_Sql.update(o);
		
	}
	public List<Moving> getAllTruckings() {
		return db_Sql.getAllTruckings();
	}

}
