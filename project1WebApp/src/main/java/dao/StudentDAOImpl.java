package dao;

import java.util.List;

import models.Student;
import revature.orm.entitymanager.DBTable;

public class StudentDAOImpl implements StudentDAO{

	private DBTable<Student> studentDB;
	public StudentDAOImpl() {
		studentDB = new DBTable<>(Student.class);
	}
	@Override
	public Student get(int id) {
		return studentDB.get(id);
		
	}

	@Override
	public List<Student> get(String... conditions) {
		return studentDB.get(conditions);
	}

	@Override
	public Student insert(Student student) {
		return studentDB.insertInto(student);
	}

	@Override
	public Student update(int id, Student school) {
		return studentDB.update(id, school);
	}

	@Override
	public Student delete(int id) {
		return studentDB.delete(id);
	}

}
