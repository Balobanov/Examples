package ua.org.oa.balobanov.DAOInterfaces;

import java.util.List;

import ua.org.oa.balobanov.essences.Role;

public interface DAORoleInt {
	boolean insert(Role role);
	List<Role> selectAll();
	boolean update(Role role);
	Role selectById(int id);
	boolean delete(Role role);
}
