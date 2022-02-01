package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.StudentDAOImpl;

public class StudentController {
	
	Gson gson = new Gson();
	StudentDAOImpl studentDAOImpl;
	public StudentController() {
		studentDAOImpl = new StudentDAOImpl();
	}
	public void getById(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	public void getByConditions(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
}
