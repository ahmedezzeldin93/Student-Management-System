package com.ahmedezzleldin.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedezzeldin.spring.web.dao.Student;
import com.ahmedezzeldin.spring.web.dao.StudentsDao;

@Service("studentsService")
public class StudentsService {
	
	StudentsDao studentsDao;
	
	@Autowired
	public void setStudentsDao(StudentsDao studentsDao) {
		this.studentsDao = studentsDao;
	}

	public List<Student> getCurrent(){
		return studentsDao.getStudents();
	}
	
	public void create(Student student) {
		studentsDao.create(student);
	}
	
	public Student getStudent(String id) {

		return studentsDao.getStudent(Integer.parseInt(id));
	}
	
	public void updateStudent(Student student) {

		studentsDao.update(student);
	}

	public void deleteStudent(Student student) {
		studentsDao.delete(student.getId());
	}
	
}
