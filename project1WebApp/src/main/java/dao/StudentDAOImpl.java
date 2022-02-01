package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import models.Student;
import revature.orm.entitymanager.DBTable;

public class StudentDAOImpl implements StudentDAO{

	private DBTable<Student> studentDB;
	public StudentDAOImpl() throws ClassNotFoundException, NoSuchFieldException, SQLException {
		studentDB = new DBTable<>(Student.class);
	}

	@Override
	public Student get(int id) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		return studentDB.get(id);
	}

	@Override
	public List<Student> get(String... conditions) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		return studentDB.get(conditions);
	}

	@Override
	public Student insert(Student student) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
		return studentDB.insertInto(student);
	}

	@Override
	public Student update(int id, Student school) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
		return studentDB.update(id, school);
	}

	@Override
	public Student delete(int id) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		return studentDB.delete(id);
	}

	public void dropTable() {
		studentDB.executeStatement("drop table if exists student;");
	}

}
