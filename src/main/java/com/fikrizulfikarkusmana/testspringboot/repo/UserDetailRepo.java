package com.fikrizulfikarkusmana.testspringboot.repo;

import com.fikrizulfikarkusmana.testspringboot.entity.UserDetail;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailRepo extends CrudRepository<UserDetail, Long> {
}
