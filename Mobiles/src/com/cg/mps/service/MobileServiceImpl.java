package com.cg.mps.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.mps.bean.Mobile;
import com.cg.mps.dao.IMobileDAO;
import com.cg.mps.dao.MobileDAOImpl;
import com.cg.mps.exception.MobilePurchaseSystemException;

public class MobileServiceImpl implements IMobileService{

	private IMobileDAO mobileDAO=new MobileDAOImpl();

	@Override
	public String deleteMobile(Integer mobileId)
			throws MobilePurchaseSystemException {
		String message=mobileDAO.deleteMobile(mobileId);
		return message;
	}

	@Override
	public List<Mobile> viewAllMobiles() throws MobilePurchaseSystemException, ClassNotFoundException, IOException {
		List<Mobile> mobileList=mobileDAO.viewAllMobiles();
		return mobileList;
	}

	@Override
	public List<Mobile> getMobilesPriceRange(Double lowPrice, Double highPrice)
			throws MobilePurchaseSystemException, ClassNotFoundException, IOException {
		List<Mobile> mobileList=mobileDAO.getMobilesPriceRange(lowPrice, highPrice);
		return mobileList;
		
	}

	@Override
	public String addMobile(Mobile mobile) throws MobilePurchaseSystemException {
		String mobileSeq;
		mobileSeq=mobileDAO.addMobile(mobile);
		return mobileSeq;
		
	}
  public void validateMobile(Mobile mobile)
  {
	  List<String> validationErrors=new ArrayList<String>();
	  if(!(isValidId(mobile.getMobileId()))) {
		  validationErrors.add("\n Mobile id should be numerical");
	  }
	  if(!isValidName(mobile.getMobileName()))
	  {
		  validationErrors.add("\n enter valid name and should contain minimum 3 characters ");
	  }
	  if(!isValidPrice(mobile.getPrice()))
	  {
		  validationErrors.add("\n enter valid price");
	  }
	  if(!isValidateQuantity(mobile.getQuantity()))
	  {
		  validationErrors.add("\n enter valid Quantity");
	  }
  }

private boolean isValidateQuantity(Integer quantity) {

	return quantity>0;
}

private boolean isValidPrice(Double price) {
	
	return price>0;
}

private boolean isValidName(String mobileName) {
	Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
	Matcher nameMatcher=namePattern.matcher(mobileName);
	return nameMatcher.matches();
}

private boolean isValidId(Integer mobileId) {

	return mobileId>3;
}
}
