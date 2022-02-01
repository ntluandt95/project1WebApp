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
	public List<School> get(String... conditions) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		return schoolDB.get(conditions);
	}

	@Override
	public School insert(School school) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
		return schoolDB.insertInto(school);
	}

	@Override
	public School update(int id, School school) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
		return schoolDB.update(id, school);
	}

	@Override
	public School delete(int id) throws SQLException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		return schoolDB.delete(id);
	}

	public void dropTable() {
		schoolDB.executeStatement("drop table if exists school;");
	}
}
