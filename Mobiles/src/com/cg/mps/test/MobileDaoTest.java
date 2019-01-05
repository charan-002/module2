package com.cg.mps.test;


import static org.junit.Assert.*;

import java.io.IOException;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.cg.mps.bean.Mobile;
import com.cg.mps.dao.MobileDAOImpl;
import com.cg.mps.exception.MobilePurchaseSystemException;
import com.cg.mps.service.MobileServiceImpl;
import com.cg.mps.service.IMobileService;

public class MobileDaoTest {

	static MobileDAOImpl dao;
	static Mobile mobile;

	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		dao = new MobileDAOImpl();
		mobile = new Mobile();
	}

	@Test
	public void testAddMobiles() throws MobilePurchaseSystemException {

		assertNotNull(dao.addMobile(mobile));

	}


	@Ignore
	@Test
	public void testAddMobileDetails1() throws MobilePurchaseSystemException {
		
		assertEquals(1001, dao.addMobile(mobile));
	}

	

	@Test
	public void testAddMobileDetails2() throws MobilePurchaseSystemException {

		mobile.setMobileId(1008);
		mobile.setMobileName("Xtel");
		mobile.setPrice(2500.0);
		mobile.setQuantity(2);
		assertTrue("Data Inserted successfully",
				Integer.parseInt(dao.addMobile(mobile)) > 1000);

	}

	
	@Test
	public void testViewAll() throws MobilePurchaseSystemException, ClassNotFoundException, IOException {
		assertNotNull(dao.viewAllMobiles());
	}

	

//	@Test
//	public void testById() throws MobilePurchaseSystemException {
//		assertNotNull(dao.viewAllMobiles(1002));
//	}
//
//	@Ignore
//	@Test
//	public void testById1() throws MobilePurchaseSystemException {
//		assertEquals("TestName", dao.viewAllMobiles(1010).getMobileName());
//	}

}


