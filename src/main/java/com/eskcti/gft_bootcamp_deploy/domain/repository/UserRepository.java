package com.eskcti.gft_bootcamp_deploy.domain.repository;

import com.eskcti.gft_bootcamp_deploy.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumber(String accountNumber);
}
