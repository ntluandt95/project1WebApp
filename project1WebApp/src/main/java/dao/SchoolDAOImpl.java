package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import controllers.SchoolController;
import models.School;
import revature.orm.entitymanager.DBTable;

public class SchoolDAOImpl implements SchoolDAO{

	private DBTable<School> schoolDB;
	
	public SchoolDAOImpl(){
		schoolDB = new DBTable<School>(School.class);
	}
	@Override
	public School get(int id){
		return schoolDB.get(id);
	}

	@Override
	public List<School> get(String... conditions) {
		return schoolDB.get(conditions);
	}

	@Override
	public School insert(School school) {
		return schoolDB.insertInto(school);
	}

	@Override
	public School update(int id, School school) {
		return schoolDB.update(id, school);
	}

	@Override
	public School delete(int id) {
		return schoolDB.delete(id);
	}

}
