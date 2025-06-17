package com.CRM.Generic.BaseUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	@BeforeSuite
	public void configBS() {
		  System.out.println("=====execute BS ===============");
	}
	
	@BeforeClass
	public void configBC() {
		  System.out.println("=====execute BC ===============");
	}
	@BeforeMethod
	public void configBM() {
		  System.out.println("=====execute BM===============");
	}
	@AfterMethod
	public void configAM() {
		  System.out.println("=====execute AM===============");
	}
	@AfterClass
	public void configAC() {
		  System.out.println("=====executeAC ===============");
	}
	@AfterSuite
	public void configAS() {
		  System.out.println("=====execute As ===============");
	}
	

}
