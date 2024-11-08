package co.edu.ufps.services;
import co.edu.ufps.entities.Department;
import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.entities.ProjectAssignmentKey;
import co.edu.ufps.repositories.EmployeeRepository;
import co.edu.ufps.repositories.ProjectAssignmentRepository;
import co.edu.ufps.repositories.DepartmentRepository;
import co.edu.ufps.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectAssignmentRepository projectAssignmentRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Object> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return (Employee) employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstName(updatedEmployee.getFirstName());
                    employee.setLastName(updatedEmployee.getLastName());
                    employee.setBirthDate(updatedEmployee.getBirthDate());
                    employee.setSex(updatedEmployee.getSex());
                    return employeeRepository.save(employee);
                }).orElseThrow();
    }

    public void addDepartmentToEmployee(Long employeeId, Long departmentId) {
        Employee employee = (Employee) employeeRepository.findById(employeeId)
                .orElseThrow();
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow();
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    public void removeDepartmentFromEmployee(Long employeeId) {
        Employee employee = (Employee) employeeRepository.findById(employeeId)
                .orElseThrow();
        employee.setDepartment(null);
        employeeRepository.save(employee);
    }

    public void assignEmployeeToProject(Long employeeId, Long projectId, int hours) {
        ProjectAssignment assignment = new ProjectAssignment();
        ProjectAssignmentKey key = new ProjectAssignmentKey();
        assignment.setId(key);
        assignment.setHours(hours);
        projectAssignmentRepository.save(assignment);
    }

    public List<ProjectAssignment> listEmployeesInProject(Long projectId) {
        return projectAssignmentRepository.findByProjectId(projectId);
    }
}
