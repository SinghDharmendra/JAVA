package concept.java.basic.passingparam;

public class Employee {
	private String empId;
	private String name;
	private String pin;
	public Employee(String empId, String name, String pin) {
		
		this.empId = empId;
		this.name = name;
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", pin=" + pin + "]";
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	};
	

}
