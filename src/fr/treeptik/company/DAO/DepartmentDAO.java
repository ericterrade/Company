package fr.treeptik.company.DAO;


import java.util.List;

import fr.treeptik.company.model.Department;

public class DepartmentDAO extends GenericDAO<Department, Integer>{

	public DepartmentDAO() {
		super(Department.class);
	}
	
	
	public List<Department> findAll(){
		return entityManager
				.createQuery("select d from Department d order by d.name ASC", Department.class)
				.getResultList();
		
	}
}
