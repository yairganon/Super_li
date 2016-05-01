package com.Super_li.BL;
import java.util.List;

import com.Super_li.Backend.Orders;
import com.Super_li.DataBase.SQLiteJDBC;
import com.Super_li.Backend.Place;
public class OrderController {
	SQLiteJDBC db_Sql;
	public OrderController(SQLiteJDBC db_Sql) {
		this.db_Sql = db_Sql;
	}
	
	public boolean addOrder(Orders order){
		return db_Sql.add(order);
	}
	public List<Orders> getAllOrders(){
		return db_Sql.getAllOrders();
	}

	public List<Place> getAllAdress() {
		return db_Sql.getAlPlaces();
	}

	public Orders isExists(int orderID) {
		Orders d = new Orders(orderID);
		return db_Sql.isExists(d)==null?null:(Orders) db_Sql.isExists(d);
	}
}