package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import models.Student;

public interface StudentDAO {
	Student get(int id) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
	List<Student> get(String... conditions) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
	Student insert(Student student) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;
	Student update(int id, Student school) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;
	Student delete(int id) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
