package paolasThesis.company2java;

public class Comp_Dept_Emp {
	private long id_comp;
	private long id_dept;
	private long id_emp;	
	
	
	public Comp_Dept_Emp(long id_comp, long id_dept, long id_emp) {		
		this.id_comp = id_comp;
		this.id_dept = id_dept;
		this.id_emp = id_emp;
	}

	public Comp_Dept_Emp(){}
	
	public long getId_comp() {
		return id_comp;
	}

	public void setId_comp(long id_comp) {
		this.id_comp = id_comp;
	}

	public long getId_dept() {
		return id_dept;
	}

	public void setId_dept(long id_dept) {
		this.id_dept = id_dept;
	}

	public long getId_emp() {
		return id_emp;
	}

	public void setId_emp(long id_emp) {
		this.id_emp = id_emp;
	}	
}
