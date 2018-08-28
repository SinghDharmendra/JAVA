package jpa.eclipselink.manyToOne.handler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.eclipselink.manyToOne.entity.DepartmentMTO;
import jpa.eclipselink.manyToOne.entity.EmployeeMTO;

public class ManyToOne {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		// Create Department Entity
		DepartmentMTO department = new DepartmentMTO();
		department.setName("Development");

		// Store Department
		entitymanager.persist(department);

		// Create Employee1 Entity
		EmployeeMTO employee1 = new EmployeeMTO();
		employee1.setEname("Satish");
		employee1.setSalary(45000.0);
		employee1.setDeg("Technical Writer");
		employee1.setDepartment(department);

		// Create Employee2 Entity
		EmployeeMTO employee2 = new EmployeeMTO();
		employee2.setEname("Krishna");
		employee2.setSalary(45000.0);
		employee2.setDeg("Technical Writer");
		employee2.setDepartment(department);

		// Create Employee3 Entity
		EmployeeMTO employee3 = new EmployeeMTO();
		employee3.setEname("Masthanvali");
		employee3.setSalary(50000.0);
		employee3.setDeg("Technical Writer");
		employee3.setDepartment(department);

		// Store Employees
		entitymanager.persist(employee1);
		entitymanager.persist(employee2);
		entitymanager.persist(employee3);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
}