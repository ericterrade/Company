package fr.treeptik.company.DAO;

import java.util.List;

import fr.treeptik.company.model.Project;

public class ProjectDAO extends GenericDAO<Project, Integer>{

	public ProjectDAO() {
		super(Project.class);
	}

	public List<Project> findAllProjectWithEmployee() {
		return entityManager.createQuery("select distinct p from Project p left join p.employees e", Project.class).getResultList();
	}
	
	public List<Project> findProjectNonManagerParJohnHarper(){
		return entityManager.createQuery("select distinct p from Project p where p not in (select p from Project p join p.employees e where e.manager in (select m from Manager m where m.firstName like 'Harper' and m.lastName like 'John'))", Project.class).getResultList();
	}



}
