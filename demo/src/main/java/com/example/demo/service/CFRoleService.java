package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CFRoleDto;
import com.example.demo.dto.RoleNoDto;

public interface CFRoleService {


	List<CFRoleDto> findAllRoles();

	List<RoleNoDto> findRoleNoAndRoleName();

}
