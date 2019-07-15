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
		
		
		int qtyCompanies = 2;	  //50     ///100.20.2000
		int qtyDepartments = 2;  //10
		int qtyEmployees = 2;  //1000
		
		int idDept = 0;
		int idEmp = 0;
		
		for (int c = 1; c <= qtyCompanies ; c++) {
			companies.add(new Company(c, "c"));
			
			for (int d = 1; d <= qtyDepartments ; d++) {
				idDept++;
				departments.add(new Department(idDept, c, "d"));				
				
				for (int e = 1; e <= qtyEmployees ; e++) {
					idEmp++;
					employees.add(new Employee(idEmp, idDept, c, "e", 1000+e+d+c));
				}
			}			
		}
		
		OutputStream os;
		JsonGenerator g;
		try {
			
			os = new FileOutputStream("d:\\companies.json",true);
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
			
			os = new FileOutputStream("d:\\departments.json",true);
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
				

			os = new FileOutputStream("d:\\employees.json",true);
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
