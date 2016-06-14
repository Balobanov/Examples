package diplom.ejbs.interfaces;

import diplom.entities.User;

public interface UserInt {
	public User insertOrUpdate(User user);
	public User findById(int id);
	public User findByLogin(String login);
	public void delete(User user);
}
