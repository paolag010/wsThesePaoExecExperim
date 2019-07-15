package paolasThesis.automaticExperimentExecution;

import java.io.IOException;
  
public class main {
	public static void main(String args[]) throws IOException, Exception {
        
		FileGeneration fg = new FileGeneration();
		FileResult fr = new FileResult();
		
        //fg.generateFileExperimentExec(); 
        //fg.generateFilesQueriesExec();
		fr.extractResults();
	}

}