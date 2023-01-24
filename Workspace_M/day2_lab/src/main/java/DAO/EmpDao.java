package DAO;
import java.util.List;

import pojo.Employee;
public interface EmpDao {
	
//	1)
	List<Employee>displayAllEmp();
	
//	2)
	String saveEmployeeDetails(Employee newEmp);
}
