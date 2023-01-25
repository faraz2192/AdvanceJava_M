package beans;

import java.util.List;

import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.Employee;

public class EmployeeBean {
	//State: Client state (req parameters) ie salary and dept;
	
	private String dept;
	private double salary;
	private EmployeeDaoImpl empDao;
	public EmployeeBean() {
		empDao= new EmployeeDaoImpl();
		System.out.println("Emp BEAN Created !!");
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public EmployeeDaoImpl getEmpDao() {
		return empDao;
	}
	public void setEmpDao(EmployeeDaoImpl empDao) {
		this.empDao = empDao;
	}
	public EmployeeBean(String dept, double salary, EmployeeDaoImpl empDao) {
		super();
		this.dept = dept;
		this.salary = salary;
		this.empDao = empDao;
	}
	
	// Business Logic method to get emp list from dao layer
	public List<Employee> fetchEmpList(){
		System.out.println("In Java Bean Business Logic Method"+dept+""+salary);
		
		//invoke dao's method
		return empDao.getEmpsByDeptAndSalary(Department.valueOf(dept), salary);
	}
	

}
