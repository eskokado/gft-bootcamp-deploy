package com.eskcti.gft_bootcamp_deploy.services;

import com.eskcti.gft_bootcamp_deploy.domain.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);

    User update(Long id, User userToUpdate);

    void delete(Long id);

    List<User> findAll();
}
