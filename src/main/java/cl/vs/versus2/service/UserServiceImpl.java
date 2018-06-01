package cl.vs.versus2.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.vs.versus2.entity.Role;
import cl.vs.versus2.entity.User;
import cl.vs.versus2.repository.RoleRepository;
import cl.vs.versus2.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	public List<User> getAllUsers() {
		Query query = entityManager.createQuery("SELECT u FROM User u");
		@SuppressWarnings("unchecked")
		List<User> allUsers = query.getResultList();
		System.out.println(allUsers.toString());
		return allUsers;
	}
	
	@Transactional
	public void updateUser(User entity) {
		entityManager.merge(entity);
		entityManager.flush();
	}

}
