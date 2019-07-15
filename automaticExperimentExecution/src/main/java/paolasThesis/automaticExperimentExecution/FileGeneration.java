package paolasThesis.automaticExperimentExecution;

import java.io.IOException;

public class FileGeneration {
	
	private FileInfo inF;
	private FileHelper fh;
	
	public FileGeneration(){
		inF = new FileInfo();
		fh =new FileHelper();
	}

	public void generateFileExperimentExec(){
        try {
			fh.writeFile(fh.createFile("D:\\" , "00-ExperimentExecConsolePromt" , ".bat" ), inF.generateInfoExecExperiment1());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateFileExperimentExec(String path, String nameFile, String extension){
        try {
			fh.writeFile(fh.createFile(path , nameFile , "."+ extension ), inF.generateInfoExecExperiment1());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateFileExperimentExec(String path, String nameFile, String extension, String info){
        try {
			fh.writeFile(fh.createFile(path , nameFile , "."+ extension ), info);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void generateFilesQueriesExec(){
		int qtySchemas = 5;
		int qtyQueries = 1;
		String schemaName = "";
		String queryName = "";
		String queryNameExc = "";
		String pathJsFiles = "D:\\ZPruebaScripts\\";
				
		for (int i = 1; i <= qtySchemas; i++) {
			schemaName = "sc0" + i; 
			for (int j = 1; j <= qtyQueries; j++) {		
				queryName = schemaName +"_Q" + j;
				queryNameExc = queryName + "_esc";
				
				try {
					fh.writeFile(fh.createFile(pathJsFiles, queryNameExc , ".js" ), inF.generateFileExecQuery(queryName));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
}
