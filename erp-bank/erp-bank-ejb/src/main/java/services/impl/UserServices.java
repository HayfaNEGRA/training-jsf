package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.User;
import services.interfaces.UserServicesLocal;
import services.interfaces.UserServicesRemote;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);

	}

	@Override
	public List<User> findAllUsers() {
		return entityManager.createQuery("select u from User u")
				.getResultList();
	}

	@Override
	public User login(String login, String password) {
		User userLogedIn = null;
		String jpql = "select u from User u where u.login=:param1 and u.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);

		try {
			userLogedIn = (User) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("user not found");
		}
		return userLogedIn;
	}

	@Override
	public void deleteUser(User userSelected) {
		entityManager.remove(entityManager.find(User.class,
				userSelected.getId()));

	}

	@Override
	public void updateUser(User userSelected) {
		entityManager.merge(userSelected);
	}

}
