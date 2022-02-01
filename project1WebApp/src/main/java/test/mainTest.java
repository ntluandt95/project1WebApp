package test;

import dao.SchoolDAOImpl;
import dao.StudentDAOImpl;
import models.School;
import models.Student;


import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;

public class mainTest {

	public static void main(String[] args) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

		//Creates school and student tables
		SchoolDAOImpl schoolDAOImpl = new SchoolDAOImpl();
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();

		//Create School and Student objects from models package
		School school = new School(1,"BERKELEY");
		Student student = new Student("First","Last",20, Date.valueOf("2000-11-20"),"Male",10,school);

		//Insert objects into tables
		schoolDAOImpl.insert(school);
		studentDAOImpl.insert(student);

		//Test get and update methods
		student = studentDAOImpl.get(1);
		student.setAge(29);
		studentDAOImpl.update(1, student);

		//Test delete method
		studentDAOImpl.delete(1);

		//Drop tables to reset test
		studentDAOImpl.dropTable();
		schoolDAOImpl.dropTable();

	}
}