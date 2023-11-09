package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.entities.enums.UserStatus;
import model.exceptions.UserManagementException;
import service.UserManagementService;

public class UserManagement {
	private List<User> userList;
	private List<User> inactiveUserList;
	
	// Instanciating an object of the UserManagementService class to handle the class's utilities
	UserManagementService userService = new UserManagementService();
	
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
		if (user.getStatus() == UserStatus.Inactive) {
			inactiveUserList.add(user);
		}
	}
	
	public List<User> getUserList() {
		return userList;
	}
	
	// show active users and validate inactive users
	public List<User> showUsers(){
		List<User> auxList = new ArrayList<>();
		for (User x : userList) {
			if (x.getStatus() != UserStatus.Inactive) {
				auxList.add(x);
			} 
		}
		if (auxList.size() == 0) {
			throw new UserManagementException("There're no registrered users");
		}
		return auxList;
	}
	
	// Show vip users
	public List<User> showVip() {
		List<User> vip = userList.stream().filter(x -> x.getStatus() == UserStatus.Vip).collect(Collectors.toList());
		if (vip.size() == 0) {
			throw new UserManagementException("There're no vip users");
		}
		return vip;
	}
	
	// Method to search a user by email
	public User searchUser(String email) {
		if (!userService.isThereAnUser(userList, email)) {
			throw new UserManagementException("User's not found");
		}
		return userService.findByEmail(userList, email);
	} 
	
	// Method to change a User Status
	public void changeStatus(String email, int status) {
		if (status == 0) {
			if (userService.findByEmail(userList, email).getStatus() == UserStatus.Inactive) {
				throw new UserManagementException("User's already inactive");
			}
			inactiveUserList.add(userService.findByEmail(userList, email));
			userService.findByEmail(userList, email).setStatus(UserStatus.Inactive);
		} else if (status == 1) {
			if (userService.findByEmail(userList, email).getStatus() == UserStatus.Active) {
				throw new UserManagementException("User's already in Active status");
			} else if (userService.findByEmail(userList, email).getStatus() == UserStatus.Inactive) {
				inactiveUserList.remove(userService.findByEmail(inactiveUserList, email));
			}
			userService.findByEmail(userList, email).setStatus(UserStatus.Active);
			
		} else {
			if (userService.findByEmail(userList, email).getStatus() == UserStatus.Vip) {
				throw new UserManagementException("User's already in Vip status");
			} else if (userService.findByEmail(userList, email).getStatus() == UserStatus.Inactive) {
				inactiveUserList.remove(userService.findByEmail(inactiveUserList, email));
			}
			userService.findByEmail(userList, email).setStatus(UserStatus.Vip);
		}
	}
}