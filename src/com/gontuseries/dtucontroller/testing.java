package com.gontuseries.dtucontroller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Student student =  new GetStudent().getStudentInfo("anky", "anky8");
		System.out.println(student.getAggregate());

	}

}
