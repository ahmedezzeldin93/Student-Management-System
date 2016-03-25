package com.ahmedezzleldin.spring.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ahmedezzeldin.spring.web.dao.Student;
import com.ahmedezzleldin.spring.web.service.StudentsService;

@Controller
public class StudentsController {
	
	private StudentsService studentsService;

	
	@Autowired
	public void setStudentService(StudentsService studentsService) {
		this.studentsService = studentsService;
	}

	@RequestMapping("/students")
	public String showHome(Model model){
		
		List<Student> students = studentsService.getCurrent();
		model.addAttribute("students",students);
		
		return "students";
	}
	
	@RequestMapping("/createstudent")
	public String createStudent() {
		
		return "createstudent";
	}

	@RequestMapping(value="/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Student student, BindingResult result) {
		if(result.hasErrors()){
			System.out.println("Form does not validate");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors){
				System.out.println(error.getDefaultMessage());
			}
		}else{
			System.out.println("Form Validated");
			System.out.println(student);
			studentsService.create(student);
		}
		
		
		return "studentcreated";
	}
	
	@RequestMapping(value = "/students/delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(Model model, @PathVariable int id) {
		
		String idAsString = Integer.toString(id);
	    model.addAttribute("student", studentsService.getStudent(idAsString));
	    
	    Student student = studentsService.getStudent(idAsString);
	    studentsService.deleteStudent(student);
	    
	    return "studentdeleted";
		
	}
	
	@RequestMapping(value = "/students/edit/{id}", method = RequestMethod.GET)
	public String updateMember(@PathVariable int id, HttpServletRequest request, Model model) {

		String idAsString = Integer.toString(id);
	    model.addAttribute("student", studentsService.getStudent(idAsString));
	    
	    Student student = studentsService.getStudent(idAsString);

	    return "editstudent";
	}
	
	@RequestMapping(value = "/students/update/{id}", method = RequestMethod.POST)
	public String updateMember(@PathVariable int id, @Valid Student student, BindingResult result) {

	    
	    if(result.hasErrors()){
			System.out.println("Form does not validate");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors){
				System.out.println(error.getDefaultMessage());
			}
		}else{
			System.out.println("Form Validated");
			System.out.println(student);
			studentsService.updateStudent(student);
		}
	    
	    return "studentUpdated";
	}
	
}
