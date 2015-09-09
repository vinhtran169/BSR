package brycen.salaryreport.service;

import brycen.salaryreport.model.Student;

public interface StudentService {
	void insertStudent(Student student);
	boolean getStudentByLogin(String userName, String password);
	boolean getStudentByUserName(String userName);
}
