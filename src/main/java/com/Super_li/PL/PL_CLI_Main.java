package com.Super_li.PL;

import java.util.List;
import java.util.Scanner;

import com.Super_li.Backend.IdB_Entity;

public class PL_CLI_Main  {
	private Scanner in = new Scanner(System.in);
	PL_CLI_Driver cli_Worker;
	PL_CLI_Truck cli_Truck;
	PL_CLI_Place cli_Place;
	PL_CLI_Trucking cli_Trucking;
	PL_CLI_Order cli_Order;
	
	public PL_CLI_Main() {}
	public PL_CLI_Main(PL_CLI_Driver cli_Worker2, PL_CLI_Truck cli_Truck2, PL_CLI_Place cli_Place,
			PL_CLI_Trucking cli_Trucking, PL_CLI_Order cli_Order) {
		this.cli_Worker=cli_Worker2;
		this.cli_Truck=cli_Truck2;
		this.cli_Place=cli_Place;
		this.cli_Trucking=cli_Trucking;
		this.cli_Order=cli_Order;
		
	}
	public void run() {
		int choose;
		boolean flag =true;
		while(flag){
			System.out.println("1.\tDriver Menu");
			System.out.println("2.\tTruck Menu");
			System.out.println("3.\tPlace Menu");
			System.out.println("4.\tMoving Menu");
			System.out.println("5.\tOrder Menu");
			System.out.println("6.\tExit");
			choose = getInt();
			switch (choose) {
			case 1: cli_Worker.run();
					break;
			case 2: cli_Truck.run();
					break;
			case 3: cli_Place.run();
					break;
			case 4: cli_Trucking.run();
					break;
			case 5: cli_Order.run();
					break;
			case 6: flag= !flag;
					break;
			default: 
					System.out.println("Wrong number");
					break;
			}
		}
	}
	public int getInt(){
		int ret ;
		String s;
		try{
			s = in.nextLine();
			ret = Integer.parseInt(s);
			return ret;
		}
		catch(Exception e){
			System.out.println("Enter a INT");
			return getInt();
		}
	}
	public String getString(){
		return in.nextLine();
	}
	public double getDouble(){
		double ret =-1;
		String s;
		try{
			s = in.nextLine();
			ret = Double.parseDouble(s);
			return ret;
		}
		catch(Exception e){
			System.out.println("Enter a Number");
			return  getDouble();
		}
	}
	public String getOneLengthString(){
		String s = in.nextLine();
		if(s.length()>1 || s.length()==0){
			System.out.println("Enter One char");
			return getOneLengthString();
		}
		return s;
	}
	public String getDateFormat(){
		int year=0 , month=0 , day=0 ;
		while(year<2000 || year>2050){
			System.out.println("Enter year(yyyy): ");
			year = getInt();
		}
		while(month<1 || month>12){
			System.out.println("Enter month(mm): ");
			month = getInt();
		}
		while(day<1 || day>31){
			System.out.println("Enter day(dd): ");
			day = getInt();
		}
		return year+"/"+month+"/"+day;
	}
	public String getHourFromat(){
		int hour=-1,min=-1;
		while(hour<0 || hour>24){
			System.out.println("Enter hour(HH): ");
			hour = getInt();
		}
		while(min<0 || min>59){
			System.out.println("Enter min(MM): ");
			min = getInt();
		}
		return String.format("%02d", hour)+":"+String.format("%02d", min);
	}
	protected int printAndSelectFromList(List<? extends IdB_Entity> lEntity) {
		int i = 0;
		for(IdB_Entity p : lEntity)
			System.out.println(i++ +".\t"+p.toString());
		int choose = -1;
		while (choose<0 || choose>=lEntity.size() ){
			System.out.println("Select Number");
			choose = getInt();
		}	
		return choose;
	}
}