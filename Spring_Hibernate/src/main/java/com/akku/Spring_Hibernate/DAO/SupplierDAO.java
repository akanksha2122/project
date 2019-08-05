package com.akku.Spring_Hibernate.DAO;



	import java.util.List;

	import com.akku.Spring_Hibernate.model.Supplier;

	public interface SupplierDAO {
		public boolean insertSupp(Supplier supplier);
		public boolean updateSupp(Supplier supplier);
		public boolean deleteSupp(int sid);
		
		//To select single supplier by id
		public Supplier getSupplierById(int sid);
		
		public List<Supplier> list();

	}



