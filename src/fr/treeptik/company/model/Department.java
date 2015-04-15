package fr.treeptik.company.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Column(name = "id")
	@Id
	@GeneratedValue
	private int departmentId;
	private String name;
	@OneToMany (mappedBy = "department",cascade = CascadeType.PERSIST)
	private List<Employee> Employees;
	
	public Department() {
		
	}

	public Department(int addressId, String name, List<Employee> employees) {
		super();
		this.departmentId = addressId;
		this.name = name;
		Employees = employees;
	}

	public int getAddressId() {
		return departmentId;
	}

	public void setAddressId(int addressId) {
		this.departmentId = addressId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return Employees;
	}

	public void setEmployees(List<Employee> employees) {
		Employees = employees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Department other = (Department) obj;
		if (departmentId != other.departmentId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + "]";
	}
	
	
	
}
