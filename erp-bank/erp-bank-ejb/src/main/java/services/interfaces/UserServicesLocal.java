package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import persistence.User;

@Local
public interface UserServicesLocal {
	void addUser(User user);

	List<User> findAllUsers();

	User login(String login, String password);

	void deleteUser(User userSelected);

	void updateUser(User userSelected);
}
