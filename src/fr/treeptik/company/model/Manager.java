package fr.treeptik.company.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends Employee {

	@Column(name = "manager_id")
	@OneToMany (mappedBy = "manager",cascade = CascadeType.PERSIST)
	private List<Employee> employees;
	
	public Manager() {

	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((employees == null) ? 0 : employees.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manager [employees=" + employees + "]";
	}
	
	

	

}
