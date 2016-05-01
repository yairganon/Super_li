package com.Super_li.PL;


import java.util.List;

import com.Super_li.BL.OrderController;
import com.Super_li.Backend.Orders;
import com.Super_li.Backend.Place;

public class PL_CLI_Order extends PL_CLI_Main {
	private OrderController orderCont;
	public PL_CLI_Order(OrderController orderCont) {
		super();
		this.orderCont=orderCont;
	}
	public void run(){
		boolean flag = true;
		while(flag){
			System.out.println("\nOrder Menu:");
			System.out.println("Please choose one option-");
			System.out.println("1.\tAdd new order");
			System.out.println("2.\tShow all orders");
			System.out.println("3.\tBack");
	
			int option = getInt();
			switch (option){
				case 1:
					addNewOrder();
					break;
				case 2:
					showAllOrders();
					break;
				case 3:
					flag=false;
					break;
				default:
					System.out.println("Wrong number");
					break;
			}
		}
	}

	private void addNewOrder(){
		int choose;
		String sourcePlace, destPlaceRow;
		System.out.println("Add new order:");
		//System.out.println("order ID is: ");
		System.out.println("Choose one source place:");
		List<Place> placeLIst = orderCont.getAllAdress();
		if(placeLIst.size()!=0){
			choose = printAndSelectFromList(placeLIst);
			sourcePlace = placeLIst.remove(choose).getAdress();
		}
		else{
			System.out.println("No avilavble sources");
			return;
		}
		
		System.out.println("Choose destination place:");
		if(placeLIst.size()!=0){
			choose = printAndSelectFromList(placeLIst);
			destPlaceRow= placeLIst.remove(choose).getAdress();
		}
		else{
			System.out.println("No avilavble destonations");
			return;
		}
		int movingID=-1;
		System.out.println("Please insert this ID of the items list:");
		int itemsID = getInt();
		Orders order=new Orders(sourcePlace, destPlaceRow, movingID, itemsID);
		orderCont.addOrder(order);
	}


	private void showAllOrders(){
		System.out.println("Show all orders:");
		for(Orders o : orderCont.getAllOrders())
			System.out.println(o.toString());
	}
}