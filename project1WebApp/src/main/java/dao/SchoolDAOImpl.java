package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import models.School;
import revature.orm.entitymanager.DBTable;

public class SchoolDAOImpl implements SchoolDAO{

	private DBTable<School> schoolDB;
	public SchoolDAOImpl() throws ClassNotFoundException, NoSuchFieldException, SQLException {
		schoolDB = new DBTable<School>(School.class);
	}
	@Override
	public School get(int id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException, SQLException {
		return schoolDB.get(id);
	}

	@Override
	public List<School> get(String... conditions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public School insert(School school) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public School update(int id, School school) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public School delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
