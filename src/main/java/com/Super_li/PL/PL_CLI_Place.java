package com.Super_li.PL;

import com.Super_li.BL.PlaceController;
import com.Super_li.Backend.Place;

public class PL_CLI_Place extends PL_CLI_Main {
	PlaceController placeCont;
	public PL_CLI_Place(PlaceController placeCont) {
		this.placeCont=placeCont;
	}
	public void run(){
		boolean flag = true;
		while(flag){
			System.out.println("\nPlace Menu:");
			System.out.println("Please choose one option-");
			System.out.println("1.\tAdd new place");
			System.out.println("2.\tRemove place");
			System.out.println("3.\tShow all places");
			System.out.println("4.\tBack");
			int option = getInt();
			switch (option){
				case 1:
					addNewPlace();
					break;
				case 2:
					removePlace();
					break;
				case 3:
					showAll();
					break;
				case 4:
					flag=false;
					break;
				default:
					System.out.println("Wrong number");
					break;
			}
		}
	}
	private void addNewPlace() {
		System.out.println("Add new place:");
		System.out.println("Adress:");
		String adress = getString();
		Place p = placeCont.isExists(adress);
		if(p!=null){
			System.out.println("Adress in Use");
			return;
		}
		int chooese = 0;
		while(chooese<1 ||chooese>3 ){
			System.out.println("Area:");
			System.out.println("1.\t"+Place.Area.NORTH);
			System.out.println("2.\t"+Place.Area.SOUTH);
			System.out.println("3.\t"+Place.Area.CENTER);
			chooese = getInt();
		}
		String area = chooese==1?Place.Area.NORTH.name() : chooese==2?Place.Area.SOUTH.name() : Place.Area.CENTER.name();
		
		System.out.println("Phone:");
		String phone = getString();
		
		System.out.println("Contact:");
		String contact = getString();
		
		p=new Place(adress, area, phone,contact);
		placeCont.addPlace(p);
		
	}
	private void removePlace() {
		System.out.println("Remove place:");
		System.out.println("Please enter place adress:");
		String adress = getString();
		Place d = placeCont.isExists(adress);
		if(d==null){
			System.out.println("place not found");
			return;
		}
		placeCont.deletePlace(d);
		
	}
	private void showAll() {
		System.out.println("Show all places:");
		for(Place p : placeCont.getAllDrivers())
			System.out.println(p.toString());
	}

}
