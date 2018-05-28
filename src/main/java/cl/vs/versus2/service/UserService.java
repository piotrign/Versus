package cl.vs.versus2.service;


import cl.vs.versus2.entity.User;

public interface UserService {
		public User findUserByEmail(String email);
		public void saveUser(User user);
	}
