package test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import dao.SchoolDAOImpl;
import models.School;
import revature.orm.entitymanager.DBTable;

public class mainTest {

	public static void main(String[] args){
		SchoolDAOImpl schoolDAOImpl = new SchoolDAOImpl();
		//schoolDAOImpl.insert(new School("NDSU"));
		System.out.println(schoolDAOImpl.get(1).toString());
		DBTable<School> school = new DBTable<School>(School.class);
		System.out.println(school.get(1));
		System.out.println("gasdasdsa");
	}
}
