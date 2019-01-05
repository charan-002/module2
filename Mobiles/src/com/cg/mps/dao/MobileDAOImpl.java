package com.cg.mps.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.cg.mps.bean.Mobile;
import com.cg.mps.exception.MobilePurchaseSystemException;
import com.cg.mps.pl.MobileMain;
import com.cg.mps.util.DBConnection;

public class MobileDAOImpl implements IMobileDAO {
	static Logger logger=Logger.getLogger(MobileDAOImpl.class);
	@Override
	public String deleteMobile(Integer mobileId)
			throws MobilePurchaseSystemException {
	  logger.info("delete mobile");
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(QueryMapper.DELETE_MOBILE_QUERY);

				){
			System.out.println("deleted");
			preparedStatement.setInt(1, mobileId);
			int n=preparedStatement.executeUpdate();
			System.out.println(n);
			if(n>0){
				return "Your required mobile id data Deleted";
			}else{
				return "Error occured not deleted";
			}
		}catch(SQLException e){
			e.printStackTrace();

		}catch(Exception e){
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Mobile> viewAllMobiles() throws MobilePurchaseSystemException, ClassNotFoundException, IOException {
		logger.info("View mobiles");
		int mobileCount=0;
		try(
				Connection connection=DBConnection.getConnection();	
				Statement statement=connection.createStatement();
				){
			
			ResultSet resultSet = statement.executeQuery(QueryMapper.RETRIVE_ALL_MOBILES_QUERY);
			List<Mobile> mobileList1 = new ArrayList<>();
			while(resultSet.next()){
				mobileCount++;
				Mobile mobile = new Mobile();

				populateMobile(mobile,resultSet);
				mobileList1.add(mobile);
			}
			System.out.println(mobileCount);
			if(mobileCount!=0){
				return mobileList1;
			}else{
				return null;
			}

		}catch(SQLException e){
			throw new MobilePurchaseSystemException("Technical Error! Refer to log");

		}

	}

	private void populateMobile(Mobile mobile, ResultSet resultSet) throws SQLException {
		mobile.setMobileId(resultSet.getInt(1));
		mobile.setMobileName(resultSet.getString(2));
		mobile.setPrice(resultSet.getDouble(3));
		mobile.setQuantity(resultSet.getInt(4));

	}

	@Override
	public List<Mobile> getMobilesPriceRange(Double lowPrice, Double highPrice)
			throws MobilePurchaseSystemException, ClassNotFoundException, IOException {
		logger.info("Get mobiles");
		int mobileCount=0;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(QueryMapper.SEARCH_MOBILES_DETAILS_QUERY);

				){
			preparedStatement.setDouble(1,lowPrice);
			preparedStatement.setDouble(2,highPrice);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<Mobile> mobileList=new ArrayList<>();
			while(resultSet.next()){
				mobileCount++;
				Mobile mobile = new Mobile();

				populateMobile(mobile,resultSet);
				mobileList.add(mobile);
			}
			if(mobileCount!=0){
				return mobileList;
			}else{
				return null;
			}

		}catch(SQLException e){
			throw new MobilePurchaseSystemException("Technical Error! Contact to log ");
		}

	}


	@Override
	public String addMobile(Mobile mobile) throws MobilePurchaseSystemException {

		logger.info("add mobile");
		try {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
	Statement st=connection.createStatement(); 
		//int resultSet=0;
		preparedStatement=connection.prepareStatement(QueryMapper.ADD_MOBILE_QUERY);
		preparedStatement.setInt(1,mobile.getMobileId());
		preparedStatement.setString(2,mobile.getMobileName());
		preparedStatement.setDouble(3,mobile.getPrice());
		preparedStatement.setInt(4,mobile.getQuantity());
		int resultSet=preparedStatement.executeUpdate();	
		
		
	}catch(Exception e)
		{
	     System.out.println(e);	
		}
		return null;
	
	//return null;
    }
}