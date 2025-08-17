package com.business.repositories;

import org.springframework.data.repository.CrudRepository;

import com.business.entities.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>
{
	Admin findByAdminEmailAndAdminPassword(String adminEmail, String adminPassword);
	Admin findByAdminEmail(String adminEmail);
}
