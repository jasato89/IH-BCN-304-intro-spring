package com.ironhack.university.controller;

import com.ironhack.university.controller.interfaces.SchoolControllerInterface;
import com.ironhack.university.model.School;
import com.ironhack.university.repository.SchoolRepository;
import com.ironhack.university.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class SchoolController implements SchoolControllerInterface {

    @Autowired
    SchoolService schoolService;



    @RequestMapping(method = RequestMethod.GET, value = "/students/find")
    @ResponseStatus(HttpStatus.OK)
    public List<School> findByName(@RequestParam Optional<String> name, @RequestParam Optional<String> address) {
        return schoolService.findByName(name, address);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/students/{id}")
    public School findSchoolById(@PathVariable Long id) {
        return schoolService.findSchoolById(id);
    }

    //Esto no es correcto aunque funcione
    @GetMapping("/new-school/{school-name}/{school-address}")
    public School saveSchool(@PathVariable(name = "school-name") String schoolName,
                             @PathVariable(name = "school-address")  String schoolAddress) {
        return schoolService.saveSchool(schoolName, schoolAddress);
    }

    //Esto lo veremos el martes
    @PostMapping("save-school")
    public School addSchool(School school) {
        return schoolService.addSchool(school);
    }
}
