package com.symbolic.student.controller;

import com.symbolic.student.entity.StudentEntity;
import com.symbolic.student.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    StudentRepository objStudentRepository;
    /********** List of Student S T A R T **********/
    @GetMapping("/api/students")
    public List<StudentEntity> getAllStudent()
    {
        List<StudentEntity> lstStudent = objStudentRepository.findAll();
        return lstStudent;
    }
    /********** List of Student E N D **********/

    /********** List of Student By ID S T A R T **********/
    @GetMapping("/api/students/{lngstudID}")
    public StudentEntity lstStudentbyID(@PathVariable Long lngstudID)
    {
        StudentEntity objStudentEntity = objStudentRepository.findById(lngstudID).get();
        return objStudentEntity;
    }
    /********** List of Student By ID E N D **********/

    /********** Create Student S T A R T **********/
    @PostMapping("/api/students/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentEntity objStudentEntity)
    {
        objStudentRepository.save(objStudentEntity);
    }
    /********** Create Student E N D **********/

    /********** Update Student S T A R T **********/
    @PutMapping("/api/students/update/{lngstudID}")
    public StudentEntity updateStudent(@PathVariable Long lngstudID)
    {
        StudentEntity objStudentEntity = objStudentRepository.findById(lngstudID).get();
        objStudentEntity.setStrStudName("Symbolic");
        objStudentEntity.setStrStudClass("8");
        objStudentEntity.setStrStudDiv("C");
        objStudentRepository.save(objStudentEntity);
        return objStudentEntity;
    }
    /********** Update Student E N D **********/

    /********** Delete Student S T A R T **********/
    @DeleteMapping("/api/students/delete/{lngstudID}")
    public void deleteStudentbyID(@PathVariable Long lngstudID)
    {
        StudentEntity objStudentEntity = objStudentRepository.findById(lngstudID).get();
        objStudentRepository.delete(objStudentEntity);
    }
    /********** Delete Student E N D **********/


}
