package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dao.SchoolDAOImpl;
import dao.StudentDAOImpl;
import models.School;
import models.Student;

public class SchoolController {

	Gson gson = new Gson();
	SchoolDAOImpl schoolDAOImpl = new SchoolDAOImpl();
	StudentDAOImpl studentDAOImpl = new StudentDAOImpl();

	public void getById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getAttribute("id").toString();
		int id = 0;
		if (input.matches("[0-9]+")) {
			id = Integer.parseInt(input);
		} else {
			response.sendError(400, "ID is not a number");
			return;
		}

		School m = schoolDAOImpl.get(id);

		response.getWriter().append((m != null) ? gson.toJson(m) : "{}");

	}

	public void getByConditions(HttpServletRequest request, HttpServletResponse response) {

	}

	public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<School> schools = new ArrayList<>();
		schools = schoolDAOImpl.get("true");
		response.getWriter().append(gson.toJson(schools));
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader reader = request.getReader();
		School school = gson.fromJson(reader, School.class);

		// Call some service(s) to process the data/information
		school = schoolDAOImpl.insert(school);

		// Generate a response from that processed data.
		if (school != null) {
			response.setStatus(201);
			response.getWriter().append(gson.toJson(school));
		} else {
			response.getWriter().append("{}");
		}

	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		School school = gson.fromJson(request.getReader(), School.class);
		school.setId((int) request.getAttribute("id"));
		int id = (int) request.getAttribute("id");
		school = schoolDAOImpl.update(id, school);

		response.getWriter().append((school != null) ? gson.toJson(school) : "{}");

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = (int) request.getAttribute("id");

        School school = schoolDAOImpl.delete(id);
        response.setStatus(201);
        response.getWriter().append((school != null) ? gson.toJson(school) : "{}");
	}

}
