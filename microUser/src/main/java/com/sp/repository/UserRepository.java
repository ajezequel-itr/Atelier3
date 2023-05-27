package com.sp.repository;
import org.springframework.data.repository.CrudRepository;
import com.sp.model.UserDB;

public interface UserRepository extends CrudRepository<UserDB, Integer>{
	public UserDB findByUsername(String username);
}