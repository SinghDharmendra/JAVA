package jpa.eclipselink.oneToMany.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT_OTM")
public class DepartmentOTM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	private String name;

	@OneToMany(targetEntity = EmployeeOTM.class)
	private List employeelist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String deptName) {
		this.name = deptName;
	}

	public List getEmployeelist() {
		return employeelist;
	}

	public void setEmployeelist(List employeelist) {
		this.employeelist = employeelist;
	}
}