package com.rodd331.crud.impl.domain.repository;

import com.rodd331.crud.impl.domain.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    Optional<UserEntity> findById(String id);
    Optional<UserEntity> findByUserName(String userName);
    Optional<UserEntity> findByEmail(String email);
}