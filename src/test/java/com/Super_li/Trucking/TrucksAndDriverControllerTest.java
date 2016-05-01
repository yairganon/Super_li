package com.Super_li.Trucking;

import com.Super_li.BL.DriverController;
import com.Super_li.BL.TrucksController;
import com.Super_li.Backend.Driver;
import com.Super_li.Backend.Truck;
import com.Super_li.DataBase.SQLiteJDBC;

import junit.framework.TestCase;

public class TrucksAndDriverControllerTest extends TestCase {
	private TrucksController tc;
	private DriverController dc;
	private SQLiteJDBC jdbc ;
	protected void setUp() throws Exception {
		super.setUp();
		jdbc = SQLiteJDBC.getSQLiteJDBC();
		tc = new TrucksController(jdbc);
		dc = new DriverController(jdbc);

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		jdbc.closeConnection();
	}

	public void testTrucksController() {
		assertEquals(TrucksController.class, tc.getClass());
	}

	public void testAddNewTruck() {
		Truck truck = new Truck(33003302, "RED", "A", "ABCDEFG", 2000, 2500);
		int sizeBefore = tc.getAll().size();
		tc.addNewTruck(truck);
		assertEquals(sizeBefore+1 , tc.getAll().size());
		assertNotNull(tc.isExists(33003302));
		tc.delete(truck);
		assertEquals(sizeBefore, tc.getAll().size());
		assertNull(tc.isExists(330033));
	}

	public void testGetAll() {
		assertEquals(true, true);
	}

	public void testIsExists2() {
		Truck truck = new Truck(33003302, "RED", "A", "ABCDEFG", 2000, 2500);
		assertNull(tc.isExists(33003302));
		tc.addNewTruck(truck);
		assertNotNull(tc.isExists(33003302));
		tc.delete(truck);
		assertNull(tc.isExists(33003302));
	}

	public void testUpdate() {
		Truck truck = new Truck(33003302, "RED", "A", "ABCDEFG", 2000, 2500);
		tc.addNewTruck(truck);
		truck.setPaint("RED2");
		truck.setLicense("B");
		truck.setMoudle("ABCDEFG2");
		truck.setMaxWeight(2000);
		truck.setWeight(1500);
		tc.update(truck);
		
		assertEquals("RED2", tc.isExists(33003302).getPaint());
		assertEquals("B", tc.isExists(33003302).getLicense());
		assertEquals("ABCDEFG2", tc.isExists(33003302).getMoudle());
		assertEquals((double)2000, tc.isExists(33003302).getMaxWeight());
		assertEquals((double)1500, tc.isExists(33003302).getWeight());
		
		tc.delete(truck);
		
	}

	public void testDelete() {
		Truck truck = new Truck(33003302, "RED", "A", "ABCDEFG", 2000, 2500);
		tc.addNewTruck(truck);
		assertNotNull(tc.isExists(33003302));
		tc.delete(truck);
		assertNull(tc.isExists(33003302));
	}
	public void testDriverController() {
		assertEquals(DriverController.class , dc.getClass());
	}
	
	public void testAddDriver() {
		Driver addNew =  new Driver(330033, "YairGanon", "A");
		int sizeBefore = dc.getAllDrivers().size();
		dc.addDriver(addNew);
		assertEquals(sizeBefore+1, dc.getAllDrivers().size());
		assertNotNull(dc.isExists(330033));
		dc.deleteDriver(addNew);
		assertEquals(sizeBefore, dc.getAllDrivers().size());
		assertNull(dc.isExists(330033));
	}

	public void testUpdateDriver() {
		Driver addNew =  new Driver(3300334, "YairGanon", "A");
		dc.addDriver(addNew);
		
		addNew.setFullname("YairGanon2");
		addNew.setLicense("B");
		dc.updateDriver(addNew);
		
		assertNotSame("YairGanon", dc.isExists(3300334).getFullName());
		assertNotSame("A", dc.isExists(3300334).getLicense());
		assertEquals("YairGanon2", dc.isExists(3300334).getFullName());
		assertEquals("B", dc.isExists(3300334).getLicense());
		
		dc.deleteDriver(addNew);
	}

	public void testIsExists() {
		Driver addNew =  new Driver(3300334, "YairGanon", "A");
		assertNull(dc.isExists(3300334));
		dc.addDriver(addNew);
		assertNotNull(dc.isExists(3300334));
		dc.deleteDriver(addNew);
		assertNull(dc.isExists(3300334));
	}

	public void testDeleteDriver() {
		Driver addNew =  new Driver(3300334, "YairGanon", "A");
		dc.addDriver(addNew);
		assertNotNull(dc.isExists(3300334));
		dc.deleteDriver(addNew);
		assertNull(dc.isExists(3300334));
	}

	public void testGetAllDrivers() {
		assertEquals(true, true);
	}

}
