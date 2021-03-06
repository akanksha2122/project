package com.akku.Spring_Hibernate.DAO.Impl;



	import java.util.List;

	import org.hibernate.SessionFactory;
	import org.hibernate.query.Query;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.akku.Spring_Hibernate.DAO.SupplierDAO;
	import com.akku.Spring_Hibernate.model.Supplier;

	@Repository("supplierDAO")
	@Transactional
	public class SupplierDAOImpl implements SupplierDAO {
		@Autowired
		private SessionFactory sessionFactory;

		@Override
		public boolean insertSupp(Supplier supplier) {
			try {
				sessionFactory.getCurrentSession().persist(supplier);
				return true;
			} catch (Exception ex) {
				return false;
			}
		}

		@Override
		public boolean updateSupp(Supplier supplier) {
			try {
				sessionFactory.getCurrentSession().update(supplier);
				return true;
			} catch (Exception ex) {
				return false;
			}
		}

		@Override
		public boolean deleteSupp(int sid) {
			try {
				sessionFactory.getCurrentSession().delete(getSupplierById(sid));
				return true;
			} catch (Exception ex) {
				return false;
			}
		}

		@Override
		public Supplier getSupplierById(int sid) {
			try {
				return sessionFactory.getCurrentSession().get(Supplier.class, Integer.valueOf(sid));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return null;
		}

		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public List<Supplier> list() {
			String selectSupplier = "FROM Supplier";

			Query query = sessionFactory.getCurrentSession().createQuery(selectSupplier);

			return query.getResultList();
		}

	}



