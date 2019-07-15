package paolasThesis.company2java;

public class Department {

	private long id_department;
	private long id_comp;
	private String name;
	
	public Department() { }

	public Department(long id_department, long id_comp, String name) {
		this.id_department = id_department;
		this.id_comp = id_comp;
		this.name = name + "_" + id_department + "_" + id_comp ;
	}

	public long getId_department() {
		return id_department;
	}

	public void setId_department(long id_department) {
		this.id_department = id_department;
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
	
}
