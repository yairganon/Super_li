package com.Super_li.PL;

import com.Super_li.Trucking.DriverController;
import com.Super_li.Trucking.TruckingController;
import com.Super_li.Trucking.TrucksController;

public class PL_CLI_Impl implements PL_CLI {
	DriverController driverCont ;
	TrucksController trucksCont ;
	TruckingController truckingCont ;
	public PL_CLI_Impl(DriverController driverCont, TrucksController trucksCont, TruckingController truckingCont) {
		this.driverCont=driverCont;
		this.trucksCont=trucksCont;
		this.truckingCont=truckingCont;
	}
	public void run() {
		driverCont.addDriver("Ofek", 1234567, 'A');
	}
}