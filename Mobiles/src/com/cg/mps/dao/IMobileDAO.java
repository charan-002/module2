package com.cg.mps.dao;

import java.io.IOException;
import java.util.List;

import com.cg.mps.bean.Mobile;
import com.cg.mps.exception.MobilePurchaseSystemException;

public interface IMobileDAO {
	public  String deleteMobile(Integer mobileId)throws MobilePurchaseSystemException;
	public  List<Mobile> viewAllMobiles()throws MobilePurchaseSystemException, ClassNotFoundException, IOException;
	public  List<Mobile> getMobilesPriceRange(Double lowPrice,Double highPrice)throws MobilePurchaseSystemException, ClassNotFoundException, IOException;
	//public Integer updateMobileQuantity(Integer mobileId,Integer quantity)throws MobilePurchaseSystemException, ClassNotFoundException, IOException;
	public String addMobile(Mobile mobile) throws MobilePurchaseSystemException;
}