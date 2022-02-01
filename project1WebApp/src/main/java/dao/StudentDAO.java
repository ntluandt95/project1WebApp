package dao;

import java.util.List;

import models.Student;

public interface StudentDAO {
	Student get(int id);
	List<Student> get(String... conditions);
	Student insert(Student student);
	Student update(int id, Student school);
	Student delete(int id);
}
