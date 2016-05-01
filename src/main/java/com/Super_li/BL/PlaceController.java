package com.Super_li.BL;

import java.util.List;

import com.Super_li.Backend.Place;
import com.Super_li.DataBase.SQLiteJDBC;

public class PlaceController {
	SQLiteJDBC db_Sql;
	public PlaceController(SQLiteJDBC db_Sql) {
		this.db_Sql=db_Sql;
	}
	public Place isExists(String id){
		Place d = new Place(id);
		return db_Sql.isExists(d)==null?null:(Place) db_Sql.isExists(d);
	}
	public boolean addPlace(Place p) {
		return db_Sql.add(p);
		
	}
	public boolean deletePlace(Place d) {
		return db_Sql.delete(d);
		
	}
	public List<Place> getAllDrivers() {
		return db_Sql.getAlPlaces();
	}

}
