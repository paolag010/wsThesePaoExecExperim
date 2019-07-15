package paolasThesis.automaticExperimentExecution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHelper {
	
	  public PrintWriter createFile(String path, String name, String extension) throws IOException{
		File archivo = new File(path+name+extension);
		FileWriter writer = new FileWriter(archivo);
		PrintWriter salida = new PrintWriter(writer);
		return salida;
	  }
	  
	  public PrintWriter writeFile(PrintWriter output, String text)throws Exception{
		//output.append("-- Test --");
		//output.println();
		output.write(text);		
		//output.print(new String(text));		
		output.close();
		return output;
	  }
		  
	  public String readFile(String path)throws Exception{
		File file = new File (path);
		FileReader fileReader = new FileReader (file);
		BufferedReader buffReader = new BufferedReader(fileReader);
		String line=null;
		String info="";
		while((line=buffReader.readLine())!=null){
			System.out.println(line);
		    info+=" "+line;
		}
		if( null != fileReader)
			fileReader.close();   
	  	return info;
	}
}
