package com.Super_li.Backend;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IdB_Entity {
	public String update();
	public String addNew();
	public String delete();
	public String selectMe();
	public void updateFileds(ResultSet rs) throws SQLException;
}