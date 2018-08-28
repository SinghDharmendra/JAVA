package jpa.eclipselink.oneToMany.handler;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.eclipselink.oneToMany.entity.DepartmentOTM;
import jpa.eclipselink.oneToMany.entity.EmployeeOTM;

public class OneToMany {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		// Create Employee1 Entity
		EmployeeOTM employee1 = new EmployeeOTM();
		employee1.setEname("Satish");
		employee1.setSalary(45000.0);
		employee1.setDeg("Technical Writer");

		// Create Employee2 Entity
		EmployeeOTM employee2 = new EmployeeOTM();
		employee2.setEname("Krishna");
		employee2.setSalary(45000.0);
		employee2.setDeg("Technical Writer");

		// Create Employee3 Entity
		EmployeeOTM employee3 = new EmployeeOTM();
		employee3.setEname("Masthanvali");
		employee3.setSalary(50000.0);
		employee3.setDeg("Technical Writer");

		// Store Employee
		entitymanager.persist(employee1);
		entitymanager.persist(employee2);
		entitymanager.persist(employee3);

		// Create Employeelist
		List<EmployeeOTM> emplist = new ArrayList();
		emplist.add(employee1);
		emplist.add(employee2);
		emplist.add(employee3);

		// Create Department Entity
		DepartmentOTM department = new DepartmentOTM();
		department.setName("Development");
		department.setEmployeelist(emplist);

		// Store Department
		entitymanager.persist(department);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
}