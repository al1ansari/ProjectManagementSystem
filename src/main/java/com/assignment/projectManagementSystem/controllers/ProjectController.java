package com.assignment.projectManagementSystem.controllers;

import com.assignment.projectManagementSystem.models.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.assignment.projectManagementSystem.services.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService service;

    //retrieve all projects
    @GetMapping()
    public List<Project> getAllProjects(){

        return service.getAllProjects();
    }

    //retrieve project by id
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id){

        return service.getProjectById(id);

    }

    //create a project
    @PostMapping()
    public Project createProject(@RequestBody Project project){
        return service.createProject(project);
    }

    //update project
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project){
       return service.updateProject(id,project);
    }
    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id){
        return service.deleteProject(id);

    }


}
