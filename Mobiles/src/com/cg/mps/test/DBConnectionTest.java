package com.cg.mps.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mps.dao.MobileDAOImpl;
import com.cg.mps.exception.MobilePurchaseSystemException;
import com.cg.mps.util.DBConnection;

public class DBConnectionTest {
	static MobileDAOImpl daotest;
	static Connection dbCon;

	@BeforeClass
	public static void initialise() {
		daotest = new MobileDAOImpl();
		dbCon = null;
	}

	@Before
	public void beforeEachTest() {
		System.out.println("----Starting DBConnection Test Case----\n");
	}

	/**
	 * Test case for Establishing Connection
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * 
	 * @throws DonorException
	 **/
	@Test
	public void test() throws MobilePurchaseSystemException, ClassNotFoundException, IOException, SQLException {
		Connection dbCon = DBConnection.getConnection();
		Assert.assertNotNull(dbCon);
	}

	@After
	public void afterEachTest() {
		System.out.println("----End of DBConnection Test Case----\n");
	}

	@AfterClass
	public static void destroy() {
		System.out.println("\t----End of Tests----");
		daotest = null;
		dbCon = null;
	}

}
