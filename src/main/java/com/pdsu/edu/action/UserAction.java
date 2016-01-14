package com.pdsu.edu.action;

import java.util.List;

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
public class UserAction extends ActionSupport {
	@Autowired
	private UserService userService;
	private User user;
	private List<User> userList;

	public String execute() throws Exception {
		return null;
	}

	public String login() {
		if (user != null) {
			User user2 = userService.login(user);
			if (user2 != null) {
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

}
