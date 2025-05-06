package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.CFRoleDto;
import com.example.demo.Dto.RoleNoDto;

public interface CFRoleService {

	List<RoleNoDto> findAllRoles();

}
