package tester;
import static utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

public abstract class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(SessionFactory sf=getFactory())
		{
			System.out.println("Hibernate UP and RUNNING.....!!!!!!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
