package com.Super_li.PL;
import com.Super_li.BL.TrucksController;
import com.Super_li.Backend.Truck;

public class PL_CLI_Truck extends PL_CLI_Main {
	private int choose; 
	TrucksController trucksCont;
	public PL_CLI_Truck(TrucksController trucksCont) {
		super();
		this.trucksCont=trucksCont;
	}
	public void run(){
		boolean flag = true;
		while(flag){
			System.out.println("1.\tAdd new Truck");
			System.out.println("2.\tUpdate Truck");
			System.out.println("3.\tRemove Truck");
			System.out.println("4.\tShow Trucks");
			System.out.println("5.\tBack");
			choose = getInt();
			switch (choose) {
			case 1: addNewTruck();
					break;
			case 2: UpdateTruck();
					break;
			case 3: RemoveTruck();
					break;
			case 4: ShowTruck();
					break;
			case 5: flag = !flag;
					break;
			default: 		
					System.out.println("Wrong number");
					break;
			}
		}
	}
	private void ShowTruck() {
		for(Truck t : trucksCont.getAll())
			System.out.println(t.toString());		
	}
	private void RemoveTruck() {
		int truckId;	
		System.out.println("\tTruck Id:");
		truckId = getInt();
		Truck t = trucksCont.isExists(truckId);
		if(t==null){
			System.out.println("Truck not found");
			return;
		}
		trucksCont.delete(t);
	}
	private void UpdateTruck() {
		int truckId;	
		System.out.println("\tTruck Id:");
		truckId = getInt();
		Truck t = trucksCont.isExists(truckId);
		if(t==null){
			System.out.println("Truck not found");
			return;
		}
		System.out.println("\tTruck paint:");
		t.setPaint( getString());
		System.out.println("\tTruck license:");
		t.setLicense( getOneLengthString());
		System.out.println("\tTruck moudle:");
		t.setMoudle( getString());
		System.out.println("\tTruck weight:");
		t.setWeight( getDouble());
		System.out.println("\tTruck maxWeight:");
		t.setMaxWeight( getDouble());
		trucksCont.update(t);		
	}
	private void addNewTruck() {
		int truckId;
		String paint,license,moudle;
		double weight,maxWeight;
		System.out.println("\tTruck Id:");
		truckId = getInt();
		Truck t = trucksCont.isExists(truckId);
		if(t!=null){
			System.out.println("Id in Use");
			return;
		}
		System.out.println("\tTruck paint:");
		paint = getString();
		System.out.println("\tTruck license:");
		license = getOneLengthString();
		System.out.println("\tTruck moudle:");
		moudle = getString();
		System.out.println("\tTruck weight:");
		weight = getDouble();
		System.out.println("\tTruck maxWeight:");
		maxWeight = getDouble();
		Truck newTruck = new Truck(truckId,paint,license,moudle,weight,maxWeight);
		trucksCont.addNewTruck(newTruck);
				
	}

}
