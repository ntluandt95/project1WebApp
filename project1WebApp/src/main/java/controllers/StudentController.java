package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dao.StudentDAOImpl;
import models.School;
import models.Student;

public class StudentController {
	
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();;
	StudentDAOImpl studentDAOImpl;
	public StudentController() {
		studentDAOImpl = new StudentDAOImpl();
	}
	public void getById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getAttribute("id").toString();
        int id = 0;
        if(input.matches("[0-9]+")) {
            id = Integer.parseInt(input);
        } else {
            response.sendError(400, "ID is not a number");
            return;
        }

        Student m = studentDAOImpl.get(id);

        response.getWriter().append((m != null) ? gson.toJson(m): "{}");
	}
	
	public void getByConditions(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Student> students = new ArrayList<>();
		students = studentDAOImpl.get("true");
		response.getWriter().append(gson.toJson(students));
	}
	
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader reader = request.getReader();
        Student student = gson.fromJson(reader, Student.class);

        //Call some service(s) to process the data/information
        student = studentDAOImpl.insert(student);

        //Generate a response from that processed data.
        if(student != null) {
            response.setStatus(201);
            response.getWriter().append(gson.toJson(student));
        } else {
            response.getWriter().append("{}");
        }
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		Student student = gson.fromJson(request.getReader(), Student.class);
		student.setId((int) request.getAttribute("id"));
		int id = (int) request.getAttribute("id");
		student = studentDAOImpl.update(id, student);

		response.getWriter().append((student != null) ? gson.toJson(student) : "{}");
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		int id = (int) request.getAttribute("id");

        Student student = studentDAOImpl.delete(id);
        response.setStatus(201);
        response.getWriter().append((student != null) ? gson.toJson(student) : "{}");

	}
}
