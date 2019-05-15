package com.gjsyoung.SpringCloudTest_UserProvider.dao;

import com.gjsyoung.SpringCloudTest_UserProvider.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
