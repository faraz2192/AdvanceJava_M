package tester;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.Employee;

public abstract class GetEmpByDeptAndSal {

	public static void main(String[] args) {
		
		
		try(SessionFactory sf=getFactory(); Scanner sc=new Scanner (System.in))
		{
			//Create emp dao instance
			EmployeeDaoImpl empDao= new EmployeeDaoImpl();
			
			System.out.println("Enter Dept name and Min Salary");
			
			empDao.getEmpsByDeptAndSalary(Department.valueOf(sc.next().toUpperCase()), sc.nextDouble()).forEach(System.out::println);
			//create transient emp
			Employee emp= new Employee(sc.next(), sc.next(), null, 0, null, false);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
