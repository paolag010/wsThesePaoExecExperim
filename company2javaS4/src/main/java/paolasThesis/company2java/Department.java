package paolasThesis.company2java;

public class Department {

	private long id_department;
	private String name;
	
	public Department() { }

	public Department(long id_department, long id_comp, String name) {
		this.id_department = id_department;
		this.name = name + "_" + id_comp ;
	}

	public long getId_department() {
		return id_department;
	}

	public void setId_department(long id_department) {
		this.id_department = id_department;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}
