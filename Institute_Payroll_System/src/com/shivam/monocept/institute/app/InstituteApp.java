package com.shivam.monocept.institute.app;

import com.shivam.monocept.institute.service.StudentService;

public class InstituteApp {

	public static void main(String[] args) {
		StudentService service=new StudentService();
       service.showMenu();
	}

}
