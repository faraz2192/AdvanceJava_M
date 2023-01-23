package dao;
import pojos.Employee;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String addEmpDetails(Employee newEmp) {
		//newEmp: Here it will be TRANSIENT  
		
		String message=("Adding Employee FAILED");
		
		// 1) Get Session from Session Factory(SF)/
		Session session=getFactory().getCurrentSession();
		
		// 2) Begin Transaction
		Transaction tx= session.beginTransaction();
		
		// 3) Try Catch to get unchecked Exception
		try {
			//Session API : public Serializable save(Object transientObjRef) throws HibernateExc.
			//									method_name
			
			Long empId= (Long) session.save(newEmp);
			//newEmp: Here it will be PERSISTENT => Entity Ref added to L1 Cache
			
			tx.commit();
			//Hibernate perform Dirty CHecking => Session.flush()
			//DML operation; Insert will be fired.
			//Session will be closed.
//			1) L1 CACHE is destroyed
//			2) Returns Database connection to the (DBCP)Database Connection Pool
//			State of new Emp
//			newEmp : DETACHED (from L1 Cache)
			message="Added Employee Details; ID ="+empId;
			
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// Re throw the same exception to the caller so that the 
			// caller will know about the exception
			throw e;
		}
		return null;
	}

}
