package com.rodd331.crud.impl.v1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserListResponse {

    private List<UserResponse> userResponseList;
    private int elementsPerPage;
    private int quantPages;
    private long quantTotalElements;
}