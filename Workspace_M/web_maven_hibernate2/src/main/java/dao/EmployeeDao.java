package dao;
import java.util.List;

import pojos.Department;
import pojos.Employee;
public interface EmployeeDao {

	String addEmpDetails(Employee newEmp);
	
	List<Employee> getEmpsByDeptAndSalary(Department dept, double minSal);
	
}
