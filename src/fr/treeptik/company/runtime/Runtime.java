package fr.treeptik.company.runtime;

import java.util.Date;
import java.util.List;

import fr.treeptik.company.DAO.AddressDAO;
import fr.treeptik.company.DAO.DepartmentDAO;
import fr.treeptik.company.DAO.EmployeeDAO;
import fr.treeptik.company.DAO.ManagerDAO;
import fr.treeptik.company.DAO.ProjectDAO;
import fr.treeptik.company.model.Department;
import fr.treeptik.company.model.Employee;
import fr.treeptik.company.model.Manager;
import fr.treeptik.company.model.Project;

public class Runtime {
	public static void main(String[] args) {
		EmployeeDAO empDao = new EmployeeDAO();
		AddressDAO addDao = new AddressDAO();
		ProjectDAO projDao = new ProjectDAO();
		DepartmentDAO depDao = new DepartmentDAO();
		ManagerDAO managerDao = new ManagerDAO();

		// 1- Lister tous les employés
		/*
		 * List<Employee> employees = empDao.findAll();
		 * System.out.println(employees); // 2- Lister les employés et leur
		 * département respectifs List<Employee> employeesDepartment =
		 * empDao.findAllEmployeeDepartment(); for (Employee employee :
		 * employeesDepartment) { System.out.println(employee);
		 * System.out.println(employee.getDepartment()); }
		 */
		// 3- Lister tous les employés qui travaillent sur un projet
		/*
		 * List<Employee> employeesProject = empDao.findAllEmployeeByProject();
		 * for (Employee employee : employeesProject) {
		 * System.out.println("------- " + employee.getFirstName() +
		 * "---------"); for (Project project : employee.getProjects()) {
		 * System.out.println("*** " + project.getNom()); } }
		 */

		// 4- Lister les projets et récupérer leur liste d’employés
		/*
		 * List<Project> projectWithEmployee = projDao
		 * .findAllProjectWithEmployee(); for (Project proj :
		 * projectWithEmployee) { System.out.println("********* " +
		 * proj.getNom() + " ***********"); if (proj != null) { for (Employee
		 * empl : proj.getEmployees()) { System.out.println("--- " +
		 * empl.getFirstName() + " " + empl.getLastName()); } } }
		 */
		// 5- Lister les employés qui n’ont pas de manager et qui travaille sur
		// le projet Cloudunit
		/*
		 * Project projectCloudUnit = new Project();
		 * projectCloudUnit.setNom("Cloudunit"); List<Employee>
		 * emplWithoutManager = empDao.findEmployeeByProject(projectCloudUnit);
		 * for (Employee empl5 : emplWithoutManager) { if(empl5.getManager()==
		 * null){ System.out.println("---------- " + empl5.getFirstName() +
		 * "  "+ empl5.getLastName() + " --------"); } }
		 */

		// 6- Lister les départements rangés par ordre alphabétique
		/*
		 * List<Department> allDepartment = depDao.findAll(); for (Department
		 * dep : allDepartment){ System.out.println("---------- " +
		 * dep.getName() +"---------"); }
		 */

		// 7- Lister les employés rangés du plus haut au plus bas salaire
		/*
		 * List<Employee> employeeSalaire = empDao.findEmployeeBySalaire(); for
		 * (Employee empl7 : employeeSalaire) { System.out.println("---------- "
		 * + empl7.getFirstName() + "  " + empl7.getLastName() +
		 * " : "+empl7.getSalary() + "€ --------"); }
		 */

		// 8- Calculer le salaire moyen d’un manager
		/*
		 * double salaireMoyen = managerDao.salaireMoyen();
		 * System.out.println("Salaire moyen d'un Manager : "+ salaireMoyen
		 * +"€");
		 */

		// 9- Récupérer l’employé le mieux payé qui n’a pas de manager mais qui
		// n’est pas lui-même manager
		/*
		 * List<Employee> employeeMieuxPaye = empDao.findEmployeeLeMieuxPaye();
		 * for (Employee empl9 : employeeMieuxPaye) {
		 * System.out.println("---------- " + empl9.getFirstName() + "  " +
		 * empl9.getLastName() + " : "+empl9.getSalary() + "€ --------");
		 * Manager manager9 = empl9.getManager(); if(manager9 != null){
		 * System.out.println("*** " + manager9.getFirstName() + "  " +
		 * manager9.getLastName() + "***"); }
		 * 
		 * }
		 */

		// 10- Récupérer les deux employés les moins bien payés
		/*
		 * List<Employee> employeeMoinsPaye = empDao.findEmployeeLeMoinsPaye();
		 * for (Employee empl10 : employeeMoinsPaye) {
		 * System.out.println("---------- " + empl10.getFirstName() + "  " +
		 * empl10.getLastName() + " : "+empl10.getSalary() + "€ --------"); }
		 */
		// 11- Lister les employés ayant été embauché entre le 13 avril 2013 et
		// aujourd’hui
		/*
		 * List<Employee> employeeEmbauche = empDao.findEmployeeEmbauche(); for
		 * (Employee empl11 : employeeEmbauche) {
		 * System.out.println("---------- " + empl11.getFirstName() + "  " +
		 * empl11.getLastName() + " : "+empl11.getStartDate() + " --------"); }
		 */
		// 12- Lister les noms des employés commençant par A
		/*
		 * List<Employee> employeeA = empDao.findEmployeeStartA(); for (Employee
		 * empl12 : employeeA) { System.out.println("---------- " +
		 * empl12.getFirstName() + "  " + empl12.getLastName() + " --------"); }
		 */

		// 13- Lister les employés attachés à leurs projets et à leurs numéros
		// de téléphone
		/*
		 * List<Employee> employeePN = empDao.findEmployeeByProjectByNumber();
		 * for (Employee empl13 : employeePN) { System.out.println("***** " +
		 * empl13.getFirstName() + "  " + empl13.getLastName() + " *****");
		 * for(Project proj : empl13.getProjects()){ System.out.println("--- " +
		 * proj.getNom()); } for(String number : empl13.getPhoneNumbers()){
		 * System.out.println("+++ " + number); } }
		 */

		// 14- Lister les employés habitants à Détroit

		/*
		 * List<Employee> employeeD = empDao.findEmployeeDetroit(); for
		 * (Employee empl14 : employeeD) { System.out.println("---------- " +
		 * empl14.getFirstName() + "  " + empl14.getLastName() + " --------"); }
		 */
		// 15- Compter le nombre d’employés ayant un salaire inférieur à 30000 $
		// System.out.println("nombre d’employés ayant un salaire à 30000 : " +
		// empDao.countEmployeeWithSalaryUpTo(30000));

		// 16- Récupérer les projets non managés par John Harper
		/*
		 * List<Project> projectNonManager =
		 * projDao.findProjectNonManagerParJohnHarper(); for (Project proj16 :
		 * projectNonManager) { System.out.println("---------- " +
		 * proj16.getNom() + " --------"); }
		 */

		// 17- Récupérer les trois salariés les mieux payés qui ne sont pas
		// managers et qui ont fourni leur numéro de téléphone
		/*
		 * List<Employee> employeeMieuxPaye = empDao.findEmployeeMieuxPaye();
		 * for (Employee empl17 : employeeMieuxPaye) {
		 * System.out.println("---------- " + empl17.getFirstName() + "  " +
		 * empl17.getLastName() + " " + empl17.getSalary() + "€ --------"); }
		 */

		// 18- Récupérer le nombre d’employés habitants à Détroit
		// System.out.println("nombre d’employés habitants à Détroit : " +
		// empDao.countEmployeeDetroit());

		// 19- Récupérer le nom, le prénom, le nom du manager de chaque employé

		/*List<Employee> employeePM = empDao.findEmployeeAndHisManager();
		for (Employee empl19 : employeePM) {
			System.out.println("***** " + empl19.getFirstName() + "  "
					+ empl19.getLastName() + " *****");

			System.out.println("Managé par : " + empl19.getManager().getFirstName()
					+ "  " + empl19.getManager().getLastName() + " -----");
		}*/
		
		//20- Calculer le salaire moyen des cinq employés les mieux payés
		/*double salaireMoyen = empDao.findEmployee5SalaryMoyen();
		System.out.println("salaire moyen des cinq employés les mieux payés : " + salaireMoyen);*/
		
		
		//21- Compter le nombre de managers ayant au moins deux projets
		
		/*long nbManagerWith2Project = managerDao.nbManagerWith2Project();
		System.out.println("nombre de managers ayant au moins deux projets : " + nbManagerWith2Project);*/
		
		//22- Ajuster le salaire des deux salariés les moins payés à 26000 $
		
		empDao.ajustSalary();
	}

}
