package com.cy.repo;

import com.cy.model.Users
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepo: CrudRepository<Users, Long>;
