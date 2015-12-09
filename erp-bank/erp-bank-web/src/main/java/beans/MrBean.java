package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import persistence.User;
import services.interfaces.UserServicesLocal;

@ManagedBean
@SessionScoped
public class MrBean {
	// models
	private User user = new User();
	private List<User> users;
	private User userSelected = new User();
	private Boolean displayform = false;
	private String loginOfTheSelectedUser;
	// injection of the proxy
	@EJB
	private UserServicesLocal userServicesLocal;
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;

	// methods
	public String doAddUser() {
		userServicesLocal.addUser(user);
		return "listUsers";
	}

	public String doDeleteUser() {
		userServicesLocal.deleteUser(user);
		displayform = false;
		System.out.println("the user who deleted this user is : "
				+ loginBean.getUser().getLogin());
		return "";
	}

	public String doUpdateUser() {
		userServicesLocal.updateUser(user);
		displayform = false;
		return "";
	}

	public void doSelect() {
		displayform = true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		users = userServicesLocal.findAllUsers();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(User userSelected) {
		this.userSelected = userSelected;
	}

	public Boolean getDisplayform() {
		return displayform;
	}

	public void setDisplayform(Boolean displayform) {
		this.displayform = displayform;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String getLoginOfTheSelectedUser() {
		return loginOfTheSelectedUser;
	}

	public void setLoginOfTheSelectedUser(String loginOfTheSelectedUser) {
		this.loginOfTheSelectedUser = loginOfTheSelectedUser;
	}

}
