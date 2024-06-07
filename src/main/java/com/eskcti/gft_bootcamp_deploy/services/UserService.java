package com.eskcti.gft_bootcamp_deploy.services;

import com.eskcti.gft_bootcamp_deploy.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
