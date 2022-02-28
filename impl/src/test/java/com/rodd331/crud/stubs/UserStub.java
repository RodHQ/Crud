package com.rodd331.crud.stubs;

import com.rodd331.crud.impl.domain.entity.UserEntity;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class UserStub {

    public static UserEntity generationUserEntity() {
        return UserEntity.builder()
                .id("someid")
                .userName("teste")
                .email("teste@live.com")
                .userPassword("123456")
                .build();
    }

    public static UserEntity generationUserEntity2() {
        return UserEntity.builder()
                .id("genericId2")
                .userName("Chapolin")
                .email("chapolin@live.com")
                .userPassword("123456")
                .build();
    }

    public static PageImpl<UserEntity> generationPageUserEntity() {
        List <UserEntity> collect = new ArrayList<>();
        collect.add(generationUserEntity());
        return new PageImpl<>(collect);
    }

    public static List<UserEntity> generationListUserEntity() {
        List <UserEntity> collect = new ArrayList<>();
        collect.add(generationUserEntity());
        return collect;
    }
}