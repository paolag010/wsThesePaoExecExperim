package paolasThesis.company2java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import main.Company;

public class main {
	
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<Company> companies = new ArrayList();		
		ArrayList<Department> departments = new ArrayList();
		ArrayList<Employee> employees = new ArrayList();
		ArrayList<Comp_Dept_Emp> cdes = new ArrayList();
		
		int qtyCompanies = 100;	//50-10-1000
		int qtyDepartments = 20;
		int qtyEmployees = 2000;		
		
		int idD = 0;
		int idC = 0;
		int idE = 0;

		for (int c = 1; c <= qtyCompanies ; c++) {
			idC++;
			companies.add(new Company( idC , "c"));			
			
			for (int d = 1; d <= qtyDepartments ; d++) {
				idD++;
				departments.add(new Department(idD, idC, "d_"+d));				
					
				for (int e = 1; e <= qtyEmployees ; e++) {
					idE++;
					employees.add(new Employee(idE, idD, idC, "e_"+e , 1000+e+d+c));
					cdes.add(new Comp_Dept_Emp(idC, idD, idE));
				}
			}			
		}
		
		OutputStream os;
		JsonGenerator g;
		try {
			
			os = new FileOutputStream("c:\\companies.json",true);
			g = mapper.getFactory().createGenerator(os);
			for (Company company : companies) {
				try {
					mapper.writeValue(g, company );
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			os.flush();
			os.close();	
			
			os = new FileOutputStream("c:\\departments.json",true);
			g = mapper.getFactory().createGenerator(os);
			for (Department department : departments) {
				try {
					mapper.writeValue(g, department );
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			os.flush();
			os.close();				
				

			os = new FileOutputStream("c:\\employees.json",true);
			g = mapper.getFactory().createGenerator(os);
			for (Employee employee : employees) {
				try {
					mapper.writeValue(g, employee );
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			os.flush();
			os.close();
							
			
			os = new FileOutputStream("c:\\cdes.json",true);
			g = mapper.getFactory().createGenerator(os);
			for (Comp_Dept_Emp cde : cdes) {
				try {
					mapper.writeValue(g, cde );
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			os.flush();
			os.close();				
			
			
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

		
		/*
		try {
			OutputStream os = new FileOutputStream("d:\\file.json",true);
			JsonGenerator g = mapper.getFactory().createGenerator(os);
			mapper.writeValue(g, new Company(1, "c_name_1") );
			
			for (int i = 2; i <= qtyCompanies ; i++) {
				try {
					mapper.writeValue(g,new Company(i, "c_name_"+i));
				} catch (JsonGenerationException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
			
			os.flush();
			os.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}*/
		

	}

}
