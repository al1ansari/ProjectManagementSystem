package com.assignment.projectManagementSystem.repositories;

import com.assignment.projectManagementSystem.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}
