package com.Super_li.Trucking;

import com.Super_li.DataBase.DB_Sql;

public class TruckingController {
	DB_Sql db_Sql;
	public TruckingController(DB_Sql db_Sql) {
		this.db_Sql=db_Sql;
	}
	public boolean addItem(String fullName, int weight){
		return db_Sql.addItem(fullName, weight);
	}

}
