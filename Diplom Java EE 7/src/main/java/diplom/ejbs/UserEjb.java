package diplom.ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import diplom.ejbs.interfaces.UserInt;
import diplom.entities.Address;
import diplom.entities.User;

@Stateless
@LocalBean
public class UserEjb implements UserInt{

	@PersistenceContext(unitName = "DATASOURCE")
	private EntityManager em;
	
	public User insertOrUpdate(User user)
	{
		if(user.getUser_id() <= 0)
			em.persist(user);
		else
			em.merge(user);
		
		return user;
	}
	
	public User findById(int id)
	{
		User user = null;
		user = em.find(User.class, id);
		return user;
	}
	
	public User findByLogin(String login)
	{
		User user = null;
		
		user = (User) em.createQuery("select u from User u where u.login = :login").setParameter("login", login).getSingleResult();
		
		return user;
	}
	
	public void delete(User user)
	{
		user = em.merge(user);
		em.remove(user);
	}
}
