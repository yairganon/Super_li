package com.Super_li.PL;

import com.Super_li.BL.DriverController;
import com.Super_li.Backend.Driver;
public class PL_CLI_Driver extends PL_CLI_Main {
	DriverController driverCont;
	public PL_CLI_Driver(DriverController driverCont) {
		super();
		this.driverCont=driverCont;
	}
	public void run(){
		boolean flag = true;
		while(flag){
			System.out.println("Driver Menu:");
			System.out.println("Please choose one option-");
			System.out.println("1.\tAdd new driver");
			System.out.println("2.\tUpdate driver");
			System.out.println("3.\tRemove driver");
			System.out.println("4.\tShow all drivers");
			System.out.println("5.\tBack");
			int option = getInt();
			switch (option){
				case 1:
					addNewDriver();
					break;
				case 2:
					updateDriver();
					break;
				case 3:
					removeDriver();
					break;
				case 4:
					showAll();
					break;
				case 5:
					flag=false;
					break;
				default:
					System.out.println("Wrong number");
					break;
			}
		}
	}
	
	private void addNewDriver(){
		System.out.println("Add new driver:");
		System.out.println("ID:");
		int ID = getInt();
		Driver d = driverCont.isExists(ID);
		if(d!=null){
			System.out.println("Id in Use");
			return;
		}
		System.out.println("Full Name:");
		String fullName = getString();
		
		System.out.println("Driver License:");
		String driverLicense = getOneLengthString();
		
		d=new Driver(ID, fullName, driverLicense);
		driverCont.addDriver(d);
	}
	
	private void updateDriver(){
		System.out.println("Update driver:");
		System.out.println("Please enter driver's ID:");
		int id = getInt();
		
		Driver d = driverCont.isExists(id);
		if(d==null){
			System.out.println("Driver not found");
			return;
		}
		
		System.out.println("New full name:");
		String idUpdate=getString();
		if(idUpdate.length()>0)
			d.setFullname(idUpdate);
		
		System.out.println("New driver license:");
		String licenseUpdate=getOneLengthString();
		if(licenseUpdate.length()>0)
			d.setLicense(licenseUpdate);
		
		driverCont.updateDriver(d);
	}
	
	private void removeDriver(){
		System.out.println("Remove driver:");
		System.out.println("Please enter driver's ID:");
		int id = getInt();
		Driver d = driverCont.isExists(id);
		if(d==null){
			System.out.println("Driver not found");
			return;
		}
		driverCont.deleteDriver(d);
	}
	
	private void showAll(){
		System.out.println("Show all drivers:");
		for(Driver d : driverCont.getAllDrivers())
			System.out.println(d.toString());
	}

}