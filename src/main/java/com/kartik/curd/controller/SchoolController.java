package com.kartik.curd.controller;

import com.kartik.curd.entity.ResponseModel;
import com.kartik.curd.entity.school.Supervisor;
import com.kartik.curd.entity.school.Teacher;
import com.kartik.curd.repository.SchoolRepository;
import com.kartik.curd.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("school/")
public class SchoolController {


    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;


    @PostMapping
    ResponseModel<Teacher> addTeacher(@RequestBody Teacher teacher) {
        System.out.println(teacher.toString());
        return new ResponseModel<Teacher>(schoolRepository.save(teacher), HttpStatus.CREATED);
    }

    @PutMapping("{id}/")
    ResponseModel<Teacher> updateTeacher(@RequestBody Teacher teacher, @PathVariable Long id) {
        System.out.println(teacher.toString());
        return new ResponseModel<Teacher>(schoolRepository.save(teacher), HttpStatus.CREATED);
    }


    @DeleteMapping("{s_id}/supervisor/{id}/")
    ResponseModel<Teacher> deleteSupervisor(@PathVariable("s_id") Long supId, @PathVariable Long id) {


        Optional<Teacher> teacher = schoolRepository.findById(supId);

        if (teacher.isPresent() && teacher.get().getSupervisor() != null) {
            if (teacher.get().getSupervisor().getId().equals(id)) {
                teacher.get().removeSupervisor();
                return new ResponseModel<Teacher>(schoolRepository.save(teacher.get()), HttpStatus.OK);
            }
        }
        return new ResponseModel<Teacher>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("supervisor/{id}/")
    ResponseModel<Supervisor> getSupervisorById(@PathVariable Long id) {

        return new ResponseModel<Supervisor>(supervisorRepository.findById(id).get(), HttpStatus.CREATED);
    }


    @DeleteMapping("{id}/")
    ResponseModel<Teacher> deleteTeacher(@PathVariable Long id) {
        schoolRepository.deleteById(id);

        return new ResponseModel<Teacher>(HttpStatus.CREATED);
    }


    @GetMapping("{id}/")
    ResponseModel<Teacher> getTeacherById(@PathVariable Long id) {
        return new ResponseModel<Teacher>(schoolRepository.findById(id).get(), HttpStatus.CREATED);
    }


}
