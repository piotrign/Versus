package cl.vs.versus2.service;


import java.util.List;

import cl.vs.versus2.entity.User;

public interface UserService {
		public User findUserByEmail(String email);
		public void saveUser(User user);
		public List<User> getAllUsers();
		public void updateUser(User entity);
		public User getLoggedUser();
	}
