package com.report.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.report.entities.Student;


public interface StudentRepo extends JpaRepository<Student, Integer> {

	 List<Student> findByYearAndBranch(String year, String branch);
	
}

