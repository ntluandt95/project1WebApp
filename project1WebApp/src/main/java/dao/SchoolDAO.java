package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import models.School;

public interface SchoolDAO {
	School get(int id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException, SQLException ;
	List<School> get(String... conditions) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
	School insert(School school) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;
	School update(int id, School school) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;
	School delete(int id) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
