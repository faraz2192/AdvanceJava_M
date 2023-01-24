package DAO;

import pojo.Role;
import pojo.Employee;
import java.util.List;
import java.io.File;
import java.io.IOException;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import pojo.Employee;

public class EmpDao_Implement implements EmpDao {
	
//	2)Save Employee	Details
	@Override
	public String saveEmployeeDetails(Employee newEmp) {

		String mesg="Employee Registration Failed !!";
//		Getting session from Session Factory
		Session session = getFactory().getCurrentSession();
		Transaction tx= session.beginTransaction();
		
		try {
			Integer Id = (Integer) session.save(newEmp);
			tx.commit();
			mesg="User Registered Successfully";
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return mesg;
	}
	
//	2)List All Employee
	public List<Employee> displayAllEmp() {
		List<Employee> emps=null;
		String jpql = "select u from Employee e";
		//Get current Session from session Factory
		Session session= getFactory().getCurrentSession();

		//Begin a Transaction
		Transaction tx= session.beginTransaction();
			try {
					emps = session.createQuery(jpql,
							Employee.class).getResultList();
					
					tx.commit();
				}catch (RuntimeException e) {
					if (tx!=null)
						tx.rollback();
					throw e;
				}
		
		return emps;
	}

	
	

}
