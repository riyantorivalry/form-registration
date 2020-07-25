package com.technolins.registrationform.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.technolins.registrationform.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query(value = "FROM User u WHERE u.mobileNumber =:mobileNumber")
	User findOneByMobileNumber(@Param ("mobileNumber") String mobileNumber);

	@Query(value = "FROM User u WHERE u.email =:email")
	User findOneByEmail(@Param ("email") String email);

	@Query(value = "SELECT new java.lang.Boolean(count(*) > 0) FROM User u WHERE u.mobileNumber =:mobileNumber")
	Boolean isExistByMobileNumber(@Param ("mobileNumber") String mobileNumber);

	@Query(value = "SELECT new java.lang.Boolean(count(*) > 0) FROM User u WHERE u.email =:email")
	Boolean isExistByEmail(@Param ("email") String email);

}
