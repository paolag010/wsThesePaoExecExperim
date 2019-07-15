package paolasThesis.company2java;

public class Employee {
	
	private long id_employee;
	private long id_dept;	
	private long id_comp;
	private String name;
	private double salary;
	
	public Employee() {	}

	public Employee(long id_employee, long id_dept, long id_comp, String name, double salary) {
		this.id_employee = id_employee;
		this.id_dept = id_dept;
		this.id_comp = id_comp;
		this.name = name + "_" + id_employee + "_" + id_dept + "_" + id_comp ;
		this.salary = salary;
	}

	public long getId_employee() {
		return id_employee;
	}

	public void setId_employee(long id_employee) {
		this.id_employee = id_employee;
	}

	public long getId_dept() {
		return id_dept;
	}

	public void setId_dept(long id_dept) {
		this.id_dept = id_dept;
	}

	public long getId_comp() {
		return id_comp;
	}

	public void setId_comp(long id_comp) {
		this.id_comp = id_comp;
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
