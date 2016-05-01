package com.Super_li.PL;

import java.util.LinkedList;
import java.util.List;

import com.Super_li.BL.TruckingController;
import com.Super_li.Backend.Driver;
import com.Super_li.Backend.Moving;
import com.Super_li.Backend.Orders;
import com.Super_li.Backend.Place;
import com.Super_li.Backend.Truck;

public class PL_CLI_Trucking extends PL_CLI_Main {
	TruckingController truckingCont;
	public PL_CLI_Trucking(TruckingController truckingCont) {
		this.truckingCont=truckingCont;
	}
	public void run(){
		int choose;
		boolean flag = true;
		while(flag){
			System.out.println("1.\tMoving Menu");
			System.out.println("1.\tAdd new Moving");
			System.out.println("2.\tShow All Movings");
			System.out.println("3.\tBack");
			choose = getInt();
			switch (choose) {
			case 1: addNewMoving();
					break;
			case 2: ShowAllMovings();
					break;
			case 3: flag = !flag;
					break;
			default: 		
					System.out.println("Wrong number");
					break;
			}
		}
	}
	private void ShowAllMovings() {
		for(Moving m : truckingCont.getAllTruckings())
			System.out.println(m.toString());		
	}
	private void addNewMoving() {
		String truckLicense="";
		int choose, truckID, driverID;
		System.out.println("Add new moving:");
		System.out.println("Choose Truck:");
		List<Truck> truckList = truckingCont.getAllTrucks();
		if(truckList.size()!=0){
			choose = printAndSelectFromList(truckList);
			truckID = truckList.get(choose).getTruckId();
			truckLicense = truckList.get(choose).getLicense();
		}
		else{
			System.out.println("No avilable trucks");
			return;
		}
		System.out.println("Choose Driver:");
		List<Driver> drivers =truckingCont.getAllDrivers(truckLicense); 
		if(drivers.size()!=0){
			choose = printAndSelectFromList(drivers);
			driverID = drivers.get(choose).getID();
		}
		else{
			System.out.println("No avilable drivers\n");
			return;
		}
		System.out.println("Choose Source place:");
		List<Place> placeLIst = truckingCont.getAllAdress();
		choose = printAndSelectFromList(placeLIst);
		String sourcePlace = placeLIst.remove(choose).getAdress();
		int cont=1;
		List<Orders> listOrders = truckingCont.getOrders(sourcePlace);
		List<Orders> orderToUpdate=new LinkedList<Orders>();
		while(cont==1){
			choose = printAndSelectFromList(listOrders);
			orderToUpdate.add(listOrders.remove(choose));
			if(listOrders!=null)
				System.out.println("In order to choose more press 1");
			cont=getInt();
		}
		System.out.println("Insert date:");
		String date=getDateFormat();
		
		System.out.println("Insert hour out:");
		String hour=getHourFromat();
		
		Moving move=new Moving(date, truckID, driverID, hour);
		truckingCont.addMoving(move);
		for (Orders o :orderToUpdate){
			o.setMovingId(move.getMovingId());
			truckingCont.update(o);
		}
	}
}
