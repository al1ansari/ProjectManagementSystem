package com.assignment.projectManagementSystem.controllers;

import com.assignment.projectManagementSystem.models.Project;
import com.assignment.projectManagementSystem.services.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProjectControllerTest {
    @Mock
    private ProjectService projectService;

    @InjectMocks
    private ProjectController projectController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProjects() {

        List<Project> projects = Arrays.asList(new Project(), new Project());
        when(projectService.getAllProjects()).thenReturn(projects);


        List<Project> result = projectController.getAllProjects();


        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void getProjectById() {
        Project project = new Project();
        project.setId(1L);
        when(projectService.getProjectById(1L)).thenReturn(project);


        Project result = projectController.getProjectById(1L);


        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void createProject() {


        LocalDate localStartDate = LocalDate.of(2024, 4, 28);
        LocalDate localEndDate = LocalDate.of(2024, 5, 28);
        Date startDate = Date.from(localStartDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(localEndDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Project project = new Project();
        project.setName("Test Project");
        project.setDescription("This is a test project");

        project.setStartDate(startDate);
        project.setEndDate(endDate);

        when(projectService.createProject(any())).thenReturn(project);

        Project project1 = projectController.createProject(project);


        verify(projectService, times(1)).createProject(any());

        assertEquals("Test Project",project1.getName());
        assertEquals("This is a test project",project1.getDescription());
        assertEquals(startDate,project1.getStartDate());
        assertEquals(endDate,project1.getEndDate());


    }

    @Test
    void updateProject() {
        Project project = new Project();
        project.setId(1L);
        project.setName("Updated Project");
        when(projectService.updateProject(eq(1L), any())).thenReturn(project);

        Project project1 = projectController.updateProject(1L, project);


        assertNotNull(project1);
        assertEquals("Updated Project", project1.getName());
    }

    @Test
    void deleteProject() {
        Long projectId = 1L;


        when(projectService.deleteProject(projectId)).thenReturn("Success");


        String result = projectController.deleteProject(projectId);


        assertEquals("Success", result);


        verify(projectService, times(1)).deleteProject(projectId);
    }
}