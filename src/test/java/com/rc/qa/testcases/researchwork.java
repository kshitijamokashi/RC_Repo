package com.rc.qa.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class researchwork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println(formatter.format(date));
		
	}

}
