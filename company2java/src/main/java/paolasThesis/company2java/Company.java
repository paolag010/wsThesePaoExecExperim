package paolasThesis.company2java;

public class Company {
	private long id_company;
	private String name;
	
	public Company(long id_company, String name){
		this.id_company = id_company;
		this.name = name + "_" + id_company;
	}
	
	public Company(){}

	public long getId_company() {
		return id_company;
	}

	public void setId_company(long id_company) {
		this.id_company = id_company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
}
