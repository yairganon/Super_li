package com.Super_li.Main;

import java.sql.SQLException;

import com.Super_li.BL.DriverController;
import com.Super_li.BL.OrderController;
import com.Super_li.BL.PlaceController;
import com.Super_li.BL.TruckingController;
import com.Super_li.BL.TrucksController;
import com.Super_li.DataBase.SQLiteJDBC;
import com.Super_li.PL.PL_CLI_Driver;
import com.Super_li.PL.PL_CLI_Main;
import com.Super_li.PL.PL_CLI_Order;
import com.Super_li.PL.PL_CLI_Place;
import com.Super_li.PL.PL_CLI_Truck;
import com.Super_li.PL.PL_CLI_Trucking;

public class App 
{
    public static void main( String[] args )
    {
    	SQLiteJDBC db_Sql;
		try {
			db_Sql = SQLiteJDBC.getSQLiteJDBC();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} 
		
    	/* Controllers*/
    	DriverController driverCont = new DriverController(db_Sql);
    	TrucksController trucksCont = new TrucksController(db_Sql);
    	PlaceController  placeCont = new PlaceController(db_Sql);
    	TruckingController truckingCont = new TruckingController(db_Sql);
    	OrderController orderCont = new OrderController(db_Sql);
    	/* Controllers*/

    	
    	/*PL_CLI*/
    	PL_CLI_Driver cli_Worker = new PL_CLI_Driver(driverCont);
    	PL_CLI_Truck cli_Truck = new PL_CLI_Truck(trucksCont);
    	PL_CLI_Place cli_Place = new PL_CLI_Place(placeCont);
    	PL_CLI_Trucking cli_Trucking = new PL_CLI_Trucking(truckingCont);
    	PL_CLI_Order cli_Order = new PL_CLI_Order(orderCont);
    	/*PL_CLI*/
    	
    	/*Main GUI*/
    	PL_CLI_Main pl_Cli = new PL_CLI_Main(cli_Worker , cli_Truck ,cli_Place ,cli_Trucking ,cli_Order);
    	pl_Cli.run();
    	db_Sql.closeConnection();
    }
}
