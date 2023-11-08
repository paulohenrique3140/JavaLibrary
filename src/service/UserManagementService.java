package service;

import java.util.List;
import java.util.stream.Collectors;

import model.entities.User;

public class UserManagementService {
	
	// Method to check if exist a user in register
	public boolean isThereAnUser(List<User> userList, String email) {
		User user = userList.stream().filter(x -> x.getEmail().equals(email)).findFirst().orElse(null);
		return user != null;
	}
	
	// Method to return a user object by email
	public User findByEmail(List<User> userList, String email) {
		List<User> list = userList.stream().filter(x -> x.getEmail().equals(email)).collect(Collectors.toList());
		User user = list.get(0);
		return user;
	}
}
