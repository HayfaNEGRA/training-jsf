package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import persistence.User;

@Remote
public interface UserServicesRemote {
	void addUser(User user);

	List<User> findAllUsers();

	User login(String login, String password);

}
