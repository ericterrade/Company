package fr.treeptik.company.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "statut", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Employee")
@NamedQueries({ 
	@NamedQuery(name = "findallEmployee", query = "select e from Employee e"),
	@NamedQuery(name = "findallEmployeeDepartment", query = "select e from Employee e left join e.department d"),
	@NamedQuery(name = "findallEmployeeProject", query="select distinct e from Employee e right join e.projects p")
	})
public class Employee {

	@Column(name = "id")
	@Id
	@GeneratedValue
	private int employeeId;
	private String firstName;
	private String lastName;
	private int salary;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@OneToOne
	private Address address;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Department department;
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Project> projects;
	@ElementCollection
	@CollectionTable(name = "Employee_phoneNumbers")
	@Column(name = "phoneNumbers")
	private List<String> phoneNumbers;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Manager manager;

	public Employee() {

	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address adress) {
		this.address = adress;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId +  ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + ", startDate=" + startDate + "]";
	}

}
