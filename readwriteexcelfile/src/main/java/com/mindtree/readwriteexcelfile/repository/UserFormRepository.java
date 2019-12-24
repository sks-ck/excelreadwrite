package com.mindtree.readwriteexcelfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.readwriteexcelfile.entity.UserForm;

@Repository
public interface UserFormRepository extends JpaRepository<UserForm, Integer>{

}
