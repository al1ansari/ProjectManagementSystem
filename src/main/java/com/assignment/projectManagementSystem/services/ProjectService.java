package com.assignment.projectManagementSystem.services;

import com.assignment.projectManagementSystem.exception.GlobalExceptionHandler;
import com.assignment.projectManagementSystem.exception.ResourceNotFoundException;
import com.assignment.projectManagementSystem.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import com.assignment.projectManagementSystem.repositories.ProjectRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepo repo;
    //retrieve all projects
    public List<Project> getAllProjects() {
            return repo.findAll();
    }
    public Project getProjectById(Long id) {
        return repo.findById(id)
                .orElseThrow(
                        ()->new ResourceNotFoundException("Project not found with id:"+id)
                );
    }

    public Project createProject(Project project) {
        return repo.save(project);
    }

    public Project updateProject(Long id, Project project) {
        Optional<Project> existingProjectOptional = repo.findById(id);
        if(existingProjectOptional.isPresent()){
            Project existingProject = existingProjectOptional.get();
            existingProject.setName(project.getName());
            existingProject.setDescription(project.getDescription());
            existingProject.setStartDate(project.getStartDate());
            existingProject.setEndDate(project.getEndDate());
            return repo.save(existingProject);
        }else{
            throw new ResourceNotFoundException("Project not found with id:"+id);
        }
    }

    public String deleteProject(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Success";
        }else{
            throw new ResourceNotFoundException("Project not found with id:"+id);
        }
    }
}
