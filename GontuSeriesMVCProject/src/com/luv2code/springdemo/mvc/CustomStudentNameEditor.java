package com.luv2code.springdemo.mvc;

import java.beans.PropertyEditorSupport;
//custom editor class created by me
public class CustomStudentNameEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String studentName) throws IllegalArgumentException {
		
		if(studentName.contains("Mr.") || studentName.contains("Ms.")){
			setValue(studentName);
		}else{
			studentName = "Ms."+studentName;
			setValue(studentName);
		}
		
	}

	
	
}
