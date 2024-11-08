package co.edu.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.entities.ProjectAssignmentKey;
public interface ProjectAssignmentRepository extends JpaRepository<ProjectAssignment, ProjectAssignmentKey> {

}
