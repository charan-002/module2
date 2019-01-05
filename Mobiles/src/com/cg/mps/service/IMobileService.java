package com.cg.mps.service;

import java.io.IOException;
import java.util.List;

import com.cg.mps.bean.Mobile;
import com.cg.mps.exception.MobilePurchaseSystemException;

public interface IMobileService {
	public abstract String deleteMobile(Integer mobileId)throws MobilePurchaseSystemException;
	public abstract List<Mobile> viewAllMobiles()throws MobilePurchaseSystemException, ClassNotFoundException, IOException;
	public abstract List<Mobile> getMobilesPriceRange(Double lowPrice,Double highPrice)throws MobilePurchaseSystemException, ClassNotFoundException, IOException;
	//public boolean isValidMobileId(Integer mobileId)throws MobilePurchaseSystemException, ClassNotFoundException, IOException;
	public String addMobile(Mobile mobile) throws MobilePurchaseSystemException;
	//Integer updateMobileQuantity(Integer quantity, Integer id1) throws MobilePurchaseSystemException, ClassNotFoundException, IOException;
	}