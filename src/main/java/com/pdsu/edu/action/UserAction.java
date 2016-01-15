package com.pdsu.edu.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pdsu.edu.domain.User;
import com.pdsu.edu.service.UserService;

/**
 * ��˵�����û�Action
 * 
 * @author ����: LiuJunGuang
 * @version ����ʱ�䣺2012-3-25 ����03:29:52
 */
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5939499645981127614L;
	
	@Autowired
	private UserService userService;
	private User user;
	private List<User> userList;
	private Map<String, Object> session; 

	public String execute() throws Exception {
		return null;
	}
	
	public void validate(){
		if (user != null) {
			User user2 = userService.login(user);
			if (user2 == null) {
				this.addFieldError("user.username", "user name or password is not correct!");
			}
		}
	}

	public String login() {
		if (user != null) {
			User user2 = userService.login(user);
			if (user2 != null) {
				user2.setPassword(null);
				session.put("cur_user", user2); 
				return SUCCESS;
			}
		}
		this.addFieldError("user.username", "user name or password is not correct!");
		return INPUT;
	}

	public String addUI() {
		return "addUser";
	}

	public String updateUI() {
		user = userService.findUserById(user.getId());
		return "updateUser";
	}

	public String add() {
		userService.addUser(user);
		return SUCCESS;
	}

	public String delete() {
		userService.deleteUser(user.getId());
		return SUCCESS;
	}

	public String update() {
		userService.updateUser(user);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String queryAllUser() {
		userList = userService.findAllUser();
		return "userList";
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

}
