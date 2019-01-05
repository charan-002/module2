package com.cg.mps.pl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.mps.bean.Mobile;
import com.cg.mps.exception.MobilePurchaseSystemException;
import com.cg.mps.service.IMobileService;
import com.cg.mps.service.MobileServiceImpl;


public class MobileMain {
	static Logger logger = Logger.getRootLogger();
	private static Scanner scanner=new Scanner(System.in);
	private static  IMobileService mobileService = new MobileServiceImpl();
	static MobileServiceImpl mobileServiceImpl=null;
	static Mobile mobile=null;
	static String mobileId=null;
	static String mobileName=null;
	static String price=null;
	static String quantity=null;
	public static void main(String[] args) throws ClassNotFoundException,IOException, MobilePurchaseSystemException {
		
		PropertyConfigurator.configure("resources//log4j.properties");
		int option;
		while (true) {

			System.out.println();
			System.out.println();
			System.out.println("   Admin System   ");
			System.out.println("_______________________________\n");

			
			System.out.println("1.Search Mobiles");
			System.out.println("2.Retrive All Mobiles");
			System.out.println("3.Delete Mobile");
			System.out.println("4.Add Mobile");
			System.out.println("5.Exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");

			try {
				option = scanner.nextInt();

				switch (option) {
				
				case 1:
					System.out.println("-----------Enter the price range-----------:");
					System.out.println("Enter lowest price");
					Double lowPrice = scanner.nextDouble();
					System.out.println("Enter highest price");
					Double highPrice = scanner.nextDouble();
					List<Mobile> mobileSearchList=getMobilesPriceRange(lowPrice,highPrice);
					showMobiles(mobileSearchList);
					break;
				case 2:
						List<Mobile> mobileList=viewAllMobiles();
						//System.out.println(mobileList);
						showMobiles(mobileList);
						break;
				case 3:
					System.out.println("Enter mobile id you want to delete:");
					int id=scanner.nextInt();
					String message=deleteMobile(id);
					System.out.println(message);
					break;
				case 4:
					while(mobile==null)
					{
						mobile=populatemobile();
					}
					mobileService=new MobileServiceImpl();
					mobileId=mobileService.addMobile(mobile);
				
					break;

				case 5:

					System.out.print("Exit Mobile Purchase System ");
					System.exit(0);
					break;
				default:
					System.out.println("Enter a valid option[1-6]");
				}
			}

			catch (InputMismatchException e) {
				scanner.nextLine();
				System.err.println("Please enter a numeric value, try again");
			}
		}
	}
	
	private static Mobile populatemobile() {

		Mobile mobile=new Mobile();
		System.out.println("Enter mobile id");
		mobile.setMobileId(scanner.nextInt());
		System.out.println("Enter mobile name");
		mobile.setMobileName(scanner.next());
		System.out.println("Enter price");
		mobile.setPrice(scanner.nextDouble());
		System.out.println("Enter Quantity");
		mobile.setQuantity(scanner.nextInt());
//		try {
//			mobileServiceImpl.validateMobile(mobile);
//		}catch(Exception e){
//			System.err.println("Invalid data.... Try again");
//			System.exit(0);
//		}
		return mobile;
		
	}


	private static List<Mobile> getMobilesPriceRange(Double lowPrice,
			Double highPrice) throws ClassNotFoundException, IOException {
		List<Mobile> mobileList = new ArrayList<>();
		try {
			mobileList = mobileService.getMobilesPriceRange(lowPrice, highPrice);
			return mobileList;
		} catch (MobilePurchaseSystemException e) {
			System.out.println("Exception occured:");
			e.printStackTrace();
		}
		return null;
	}
	private static String deleteMobile(int id) {
		try {
			String message=mobileService.deleteMobile(id);
			return message;
		} catch (MobilePurchaseSystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	private static void showMobiles(List<Mobile> mobileList) {
		if (mobileList != null) {
			Iterator<Mobile> iterator = mobileList.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			
		} else {
			System.out.println("No data of mobiles");
		}	
	}
	private static List<Mobile> viewAllMobiles() throws ClassNotFoundException, IOException  {
		List<Mobile> mobileList = new ArrayList<>();
		try {
			mobileList = mobileService.viewAllMobiles();
			System.out.println(mobileList);
			return mobileList;
		} catch (MobilePurchaseSystemException e) {
			System.out.println("Exception occured:");
			e.printStackTrace();
		}
		return null;
	}

	}
