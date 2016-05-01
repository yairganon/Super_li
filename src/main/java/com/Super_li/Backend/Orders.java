package com.Super_li.Backend;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Orders implements IdB_Entity {
	private int orderId;
	private String sourcePlace;
	private Place source;
	private Place dest;
	private String destPlace;
	private int movingId;
	private Moving moving;
	private int itemsInOrderID;
	public Orders(int orderId){this.orderId = orderId;}
	public Orders(String sourcePlace, String destPlace, int movingId , int itemsInOrderID) {
		this.sourcePlace = sourcePlace;
		this.destPlace = destPlace;
		this.movingId = movingId;
		this.itemsInOrderID = itemsInOrderID;
		source= new Place(sourcePlace);
		dest= new Place(destPlace);
		moving = new Moving(movingId);
		moving.addNew();
		source.addNew();
		dest.addNew();
	}
	public Orders(int orderId,String sourcePlace, String destPlace, int movingId , int itemsInOrderID) {
		this.orderId=orderId;
		this.sourcePlace = sourcePlace;
		this.destPlace = destPlace;
		this.movingId = movingId;
		this.itemsInOrderID = itemsInOrderID;
	}
	public String getSourcePlace() {return sourcePlace;}
	public void setSourcePlace(String sourcePlace) {this.sourcePlace = sourcePlace;}
	public String getDestPlace() {return destPlace;}
	public void setDestPlace(String destPlace) {this.destPlace = destPlace;}
	public int getMovingId() {return movingId;}
	public void setMovingId(int movingId) {this.movingId = movingId;}
	public int getOrderId() {return orderId;}
	public void setItemsInOrderID(int itemsInOrderID) {this.itemsInOrderID = itemsInOrderID;}
	public int getItemsInOrderID() {return itemsInOrderID;}
	
	public String update() {return "UPDATE Orders SET SourcePlace ='"+sourcePlace+"',DestPlace ='"+destPlace+"',MovingID ="+movingId+",ItemsInOrderID ='"+itemsInOrderID+"' WHERE orderId="+orderId+";";}
	public String addNew() {
		return "INSERT INTO Orders (SourcePlace,DestPlace,MovingID,ItemsInOrderID) " +
                "VALUES ('"+sourcePlace+"','"+destPlace+"',"+movingId+","+itemsInOrderID+");";
	}
	public String delete() {return "DELETE FROM Orders WHERE OrderID="+orderId+";";}
	public String selectMe() {return "SELECT * FROM Orders WHERE OrderID="+orderId+";";}
	public void updateFileds(ResultSet rs) throws SQLException {
		this.orderId = rs.getInt("OrderID");
		this.sourcePlace = rs.getString("SourcePlace");
		this.destPlace =rs.getString("DestPlace");
		this.movingId = rs.getInt("MovingID");
		this.itemsInOrderID = rs.getInt("ItemsInOrderID");
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", sourcePlace=" + sourcePlace + ", destPlace=" + destPlace
				+ ", movingId=" + (movingId==-1?"Moving Not Set Yet":movingId ) + ", itemsInOrderID=" + itemsInOrderID +"]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	

}
