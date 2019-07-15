package pck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Methods {

	int W_ID = 0;
	int D_ID = 0;	
	int D_W_ID = W_ID;
	int C_ID = 0;
	int C_D_ID = D_ID;
	int C_W_ID = D_W_ID;
	
	
	int qtyDistricts = 10;
	int qtyCustomersPerDis = 2;
			
	
	public void writeDataSetCollection(String path, String collectionName){
		
		File f;
		FileWriter w;
		BufferedWriter bw;
		PrintWriter wr;
		
		try {
			f = new File(path + collectionName);
			w = new FileWriter(f);
			bw = new BufferedWriter(w);
			wr = new PrintWriter(bw);
			
			
			createDocWareHouse(wr);
			wr.println(",");
				wr.println("\"districts\":[");					
					while (D_ID < qtyDistricts) {						
						createDocDistrict(wr);
						wr.append(",");
						
							wr.println("\"customers\":[");
							    for (int c = 0; c < qtyCustomersPerDis; c++) {
									createDocCustomer(wr);
									wr.append("}");									
									if(c+1 != qtyCustomersPerDis) wr.append(",");
								}							    
							wr.println("]");									
						
						wr.println("}");
						if(D_ID != qtyDistricts) wr.append(",");
					}
				wr.println("]");
			wr.println("}");
			
			wr.close();
			bw.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "The file has not been created." + e);
		}
	}		
	
	public void createDocWareHouse(PrintWriter wr)
	{
		W_ID++;
		wr.println("{");
		wr.println("\"W_ID\": "			+ W_ID + ", ");
		wr.println("\"W_NAME\": " 		+ "\"W_NAME_" + W_ID + "\" , ");
		wr.println("\"W_STREET_1\": " 	+ "\"W_STREET_1_" + W_ID + "\" , ");
		wr.println("\"W_STREET_2\": " 	+ "\"W_STREET_2_" + W_ID + "\" , ");
		wr.println("\"W_CITY\": " 		+ "\"W_CITY_" + W_ID + "\" , ");
		wr.println("\"W_STATE\": " 		+ "\"W_STATE_" + W_ID + "\" , ");		
		wr.println("\"W_TAX\": " 		+ " 0.1 , ");
		wr.append("\"W_YTD\": " 		+ " 0.1 ");

	}
	
	public void createDocDistrict(PrintWriter wr){
		D_ID++;
		D_W_ID = W_ID;
		wr.println("{");		
		wr.println("\"D_ID\": "+ D_ID + ", ");		
		wr.println("\"D_W_ID\": "+ D_W_ID + ", ");		
		wr.println("\"D_NAME\": " + "\"D_NAME_" + D_ID + "_" + D_W_ID + "\" , ");
		wr.println("\"D_STREET_1\": " + "\"D_STREET_1_" + D_ID + "_" + D_W_ID + "\" , ");
		wr.println("\"D_STREET_2\": " + "\"D_STREET_2_" + D_ID + "_" + D_W_ID + "\" , ");
		wr.println("\"D_CITY\": " + "\"D_CITY_" + D_ID + "_" + D_W_ID + "\" , ");
		wr.println("\"D_STATE\": " + "\"D_STATE_" + D_ID + "_" + D_W_ID + "\" , ");
		wr.println("\"D_TAX\": " + "0.1 , ");
		wr.println("\"D_YTD\": " + "0.1 , ");		
		wr.println("\"D_NEXT_O_ID\": 11 ");  //TODO		
	}
	
	public void createDocCustomer(PrintWriter wr){
		C_ID++;
		C_D_ID = D_ID;
		C_W_ID = D_W_ID;
		wr.println("{");		
		wr.println("\"C_ID\": "+ C_ID + ", ");
		wr.println("\"C_D_ID\": "+ C_D_ID + ", ");		
		wr.println("\"C_W_ID\": "+ C_W_ID + ", ");		
		wr.println("\"C_FIRST\": " + "\"C_FIRST_" + C_ID + "_" + C_D_ID + "_" + C_W_ID + "\" , ");
		wr.println("\"C_MIDDLE\": " + "\"C_MIDDLE_" + C_ID + "_" + C_D_ID + "_" + C_W_ID + "\" , ");
		wr.println("\"C_LAST\": " + "\"C_LAST_" + C_ID + "_" + C_D_ID + "_" + C_W_ID + "\"");		
	}
	
	public void createDocHistories(){
		
	}
	
}
