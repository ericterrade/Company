package fr.treeptik.company.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.treeptik.company.model.Employee;
import fr.treeptik.company.model.Project;

public class EmployeeDAO extends GenericDAO<Employee, Integer> {

	public EmployeeDAO() {
		super(Employee.class);
	}

	public List<Employee> findAll() {
		return entityManager
				.createNamedQuery("findallEmployee", Employee.class)
				.getResultList();
	}

	public List<Employee> findAllEmployeeDepartment() {
		return entityManager.createNamedQuery("findallEmployeeDepartment",
				Employee.class).getResultList();
	}

	public List<Employee> findAllEmployeeByProject() {
		return entityManager.createNamedQuery("findallEmployeeProject",
				Employee.class).getResultList();
	}

	public List<Employee> findEmployeeByProject(Project project) {
		return entityManager
				.createQuery(
						"select distinct e from Employee e join e.projects p where p.nom = :name",
						Employee.class).setParameter("name", project.getNom())
				.getResultList();
	}

	public List<Employee> findEmployeeBySalaire() {
		return entityManager.createQuery(
				"select distinct e from Employee e order by e.salary desc",
				Employee.class).getResultList();
	}

	public List<Employee> findEmployeeLeMieuxPaye() {
		return entityManager
				.createQuery(
						"select distinct e from Employee e where e not in (select m from Manager m) and e.manager is null order by e.salary desc having max(e.salary)",
						Employee.class).setMaxResults(1).getResultList();
	}

	public List<Employee> findEmployeeLeMoinsPaye() {
		return entityManager
				.createQuery(
						"select distinct e from Employee e order by e.salary asc",
						Employee.class).setMaxResults(2).getResultList();
	}

	public List<Employee> findEmployeeEmbauche() {
		return entityManager
				.createQuery(
						"select distinct e from Employee e where e.startDate BETWEEN '2013-04-13' and :dateTo ",
						Employee.class).setParameter("dateTo", new Date(), TemporalType.DATE).getResultList();
	}
	
	public List<Employee> findEmployeeStartA(){
		return entityManager.createQuery(
				"select e from Employee e where e.firstName like 'A%'",
				Employee.class).getResultList();
	}
	
	public List<Employee> findEmployeeByProjectByNumber(){
		return entityManager.createQuery(
				"select e from Employee e join e.projects p join e.phoneNumbers",
				Employee.class).getResultList();
	}
	
	public List<Employee> findEmployeeDetroit(){
		return entityManager.createQuery(
				"select e from Employee e join e.address a where a.town like 'Detroit'",
				Employee.class).getResultList();
	}
	
	public int countEmployeeWithSalaryUpTo(int salaire){
		return entityManager.createQuery(
				"select e from Employee e where e.salary>:salaire",
				Employee.class).setParameter("salaire",salaire).getResultList().size();
	}
	
	public List<Employee> findEmployeeMieuxPaye(){
		return entityManager.createQuery(
				"select e from Employee e join e.phoneNumbers where e not in (select m from Manager m) order by e.salary desc",
				Employee.class).setMaxResults(3).getResultList();
	}
	
	public int countEmployeeDetroit(){
		return entityManager.createQuery(
				"select distinct e from Employee e join e.address a where a.town like 'Detroit'",
				Employee.class).getResultList().size();
	}
	
	public List<Employee> findEmployeeAndHisManager(){
		return entityManager.createQuery(
				"select e from Employee e join e.manager m ",
				Employee.class).getResultList();
	}
	
	public double findEmployee5SalaryMoyen(){
		/*CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> q = cb.createQuery(Employee.class);
		Root<Employee> e = q.from(Employee.class);
		TypedQuery<Employee> query = entityManager.createQuery(q);
		q.select(e).orderBy(cb.desc(e.get("salary")));
		
		List<Employee> Employees = query.setMaxResults(5).getResultList();*/
		List<Employee> Employees = entityManager.createQuery("select e from Employee e order by e.salary desc").setMaxResults(5).getResultList();
		return (double) entityManager.createQuery("select avg(e.salary) from Employee e where e in (:employees)").setParameter("employees", Employees).getSingleResult();
	}
	
	public void ajustSalary(){
		
		entityManager.getTransaction().begin();
		entityManager.createNativeQuery("update Employee e set e.salary = 26000 order by e.salary asc limit 2").executeUpdate();
		entityManager.getTransaction().commit();
	}
	
	 

}
