package com.login.dao;

import java.util.List;

import com.login.pojo.Login;

public interface RegistrationInterface {

	public boolean signup(Login l);

	public Login login(Login login);

	public List<Login> getAllDoctors();

	public List<Login> getAllNewUersListForApproval(String role);

	public boolean updateApprovalStatus(long id, String status);

	public List<Login> getBlockedList(String role);

	public boolean updateBlockUserStatus(long id, String status);

}
