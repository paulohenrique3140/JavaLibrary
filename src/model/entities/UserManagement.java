package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.entities.enums.UserStatus;

public class UserManagement {
	private List<User> userList;
	private List<User> inactiveUserList;
	
	// Starting the lists
	public UserManagement() {
		userList = new ArrayList<>();
		inactiveUserList = new ArrayList<>();
	}
	
	public List<User> getInactiveUserList() {
		return inactiveUserList;
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
	
	// show active users
	public List<User> showUsers(){
		List<User> auxList = new ArrayList<>();
		for (User x : userList) {
			if (x.getStatus() != UserStatus.Inactive) {
				auxList.add(x);
			} else {
				inactiveUserList.add(x);
			}
		}
		return auxList;
	}
	
	// Show vip users
	public List<User> showVip() {
		List<User> vip = userList.stream().filter(x -> x.getStatus() == UserStatus.Vip).collect(Collectors.toList());
		return vip;
	}
}