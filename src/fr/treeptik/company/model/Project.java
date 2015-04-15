package fr.treeptik.company.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Project {

	@Column(name = "id")
	@Id
	@GeneratedValue
	private int projectId;
	@Column(name = "name")
	private String nom;
	
	@ManyToMany(mappedBy ="projects",cascade = CascadeType.PERSIST)
	List<Employee> employees;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
		int result = 1;
		result = prime * result
				+ ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + projectId;
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
		Project other = (Project) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (projectId != other.projectId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", nom=" + nom
				+ ", employees=" + employees + "]";
	}
	
	
	
}
