package ua.org.oa.balobanov.DAOInterfaces;

import java.util.List;
import ua.org.oa.balobanov.essences.User;

public interface DAOUserInt {
	boolean insert(User user);
	List<User> selectAll();
	boolean update(User user);
	User selectById(int id);
	User selectByLogin(String login);
	boolean delete(String login);
	boolean delete(int id);
	boolean delete(User user);
}
