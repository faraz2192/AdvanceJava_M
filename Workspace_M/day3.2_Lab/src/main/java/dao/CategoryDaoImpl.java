package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String addNewCategory(Category newCategory) {
		String mesg = "Adding category failed";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin a Tx
		Transaction tx = session.beginTransaction();
		try {
//			Transient to persistent
			session.persist(newCategory);
//			We will have to individually iterate through all products and
			tx.commit();
			mesg = "New category added with ID " + newCategory.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteCategoryName(Category categoryName) {
		String jpql="select c from Category c where c.categoryName=:nm";

		//		Delete query will not work here because the it will fail at
//		Database Level;
		
		String message="Deleting Category Failed";
//		Getting session from Session Factory;
		Session session = getFactory().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			Category category= session.createQuery(jpql,Category.class).
					setParameter("nm", categoryName).getSingleResult();
			
			session.delete(category);
			tx.commit();
//			Cascades delete operation to child table
			
			message="Deletion of Category successfull";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return message;
		
	}
	

	

}
