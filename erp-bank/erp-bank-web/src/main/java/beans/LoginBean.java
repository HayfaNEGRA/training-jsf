package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.User;
import services.interfaces.UserServicesLocal;

@ManagedBean
@SessionScoped
public class LoginBean {
	private User user = new User();
	@EJB
	private UserServicesLocal userServicesLocal;

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = userServicesLocal.login(user.getLogin(),
				user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			navigateTo = "addUser";
		} else {
			navigateTo = "horror";
		}

		return navigateTo;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
