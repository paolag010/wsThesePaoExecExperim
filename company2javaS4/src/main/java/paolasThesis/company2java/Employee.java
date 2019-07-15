package paolasThesis.company2java;

public class Employee {
	
	private long id_employee;
	private String name;
	private double salary;
	
	public Employee() {	}

	public Employee(long id_employee, long id_dept, long id_comp, String name, double salary) {
		this.id_employee = id_employee;
		this.name = name + "_" + id_dept + "_" + id_comp ;
		this.salary = salary;
	}

	public long getId_employee() {
		return id_employee;
	}

	public void setId_employee(long id_employee) {
		this.id_employee = id_employee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
