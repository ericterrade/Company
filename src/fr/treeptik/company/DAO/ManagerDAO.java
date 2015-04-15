package fr.treeptik.company.DAO;

import fr.treeptik.company.model.Manager;

public class ManagerDAO extends GenericDAO<Manager, Integer>{

	public ManagerDAO() {
		super(Manager.class);
	}
	
	public double salaireMoyen() {
		return (double) entityManager.createQuery("select avg(m.salary) from Manager m").getSingleResult();
	}
	
	public long nbManagerWith2Project(){
		return  (long) entityManager.createQuery("select count(m) from Manager m join m.projects p group by m having count(m)>2").getSingleResult();
	}
	
	
	
}
