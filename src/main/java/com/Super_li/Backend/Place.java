package com.Super_li.Backend;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Place implements IdB_Entity {
	public static enum Area {
	    NORTH, CENTER, SOUTH
	}
	private String adress;
	private String area;
	private String phone;
	private String contact;
	public Place(String adress){this.adress=adress;}
	public Place(String adress, String area, String phone, String contact) {
		this.adress = adress;
		this.area = area;
		this.phone = phone;
		this.contact = contact;
	}
	
	public String getAdress() {return adress;}
	public String getArea() {return area;}
	public void setArea(String area) {this.area = area;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getContact() {return contact;}
	public void setContact(String contact) {this.contact = contact;}
	
	public String addNew() {
		return "INSERT INTO Place (Adress,Area,Phone,Contact) " +
                "VALUES ('"+adress+"','"+area+"','"+phone+"','"+contact+"');";
	}
	public String delete() {return "DELETE FROM Place WHERE Adress='"+adress+"';";}
	public String update() {return "UPDATE Place SET Area ='"+area+"',Phone ='"+phone+"',Contact ='"+contact+"' WHERE Adress='"+adress+"';";}
	public String selectMe() {return "SELECT * FROM Place WHERE Adress='"+adress+"';";}
	public void updateFileds(ResultSet rs) throws SQLException {
		this.adress = rs.getString("Adress");
		this.area = rs.getString("Area");
		this.phone =rs.getString("Phone");
		this.contact = rs.getString("Contact");
	}
	
	@Override
	public String toString() {
		return "Place [adress=" + adress + ", area=" + area + ", phone=" + phone + ", contact=" + contact + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		return true;
	}
}
