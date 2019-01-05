package com.cg.mps.dao;

public interface QueryMapper {

	public static final String RETRIVE_ALL_MOBILES_QUERY="SELECT * FROM mobiles ";
	public static final String SEARCH_MOBILES_DETAILS_QUERY=" SELECT * FROM mobiles WHERE price >=? AND price<=?";
	public static final String DELETE_MOBILE_QUERY="DELETE FROM mobiles WHERE mobileid=? ";
	public static final String ADD_MOBILE_QUERY=" INSERT into mobiles values(?,?,?,?)";
}
