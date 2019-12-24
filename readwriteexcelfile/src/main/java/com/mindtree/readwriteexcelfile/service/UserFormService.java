package com.mindtree.readwriteexcelfile.service;

import java.util.List;

import com.mindtree.readwriteexcelfile.entity.UserForm;

public interface UserFormService {

	/**
	 * @param userForm
	 */
	void insertFormToDB(UserForm userForm);

	List<UserForm> readFromFile();

}
