package com.Super_li.Trucking;

import com.Super_li.DataBase.DB_Sql;
import com.Super_li.DataBase.SQLiteJDBC;
import com.Super_li.PL.PL_CLI;
import com.Super_li.PL.PL_CLI_Impl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	DB_Sql db_Sql = new SQLiteJDBC(); 
    	db_Sql.createConnection();
    	DriverController driverCont = new DriverController(db_Sql);
    	TrucksController trucksCont = new TrucksController(db_Sql);
    	TruckingController truckingCont = new TruckingController(db_Sql);
    	PL_CLI pl_Cli = new PL_CLI_Impl(driverCont , trucksCont , truckingCont);
    	pl_Cli.run();
    	db_Sql.closeConnection();
    }
}
