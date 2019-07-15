package paolasThesis.automaticExperimentExecution;

public class FileInfoBK {
	
	private String pathJsFiles = "C:/Users/SONY VAIO/Dropbox/Paola/Estudio/PhDGrenoble/ThesisPaola/ExperimentsSchemas/Experiment/scripts/";
	private String pathResults = "C:/Users/SONY VAIO/Dropbox/Paola/Estudio/PhDGrenoble/ThesisPaola/ExperimentsSchemas/Experiment/";
	private String pathResultsDate = "results020516/";
	
	// Experiment with 5 schemas and 6 queries by schema
	// MongoDB server is started and shutdown before and after to query executions
	
	public String generateInfoExecExperiment1()
	{
		int qtySchemas = 5;
		int qtyQueries = 6;
		String info = "";
		String schemaName = "";
		String queryName = "";
		String queryNameExc = "";
				
		for (int i = 1; i <= qtySchemas; i++) {
			schemaName = "sc0" + i; 
			for (int j = 1; j <= qtyQueries; j++) {		
				queryName = schemaName +"_Q" + j;
				queryNameExc = queryName + "_esc";
				info += ( "start \"\" \"C:\\Program Files\\MongoDB\\Server\\3.0\\bin\\mongod.exe\"" + "\r\n" 
						+ "mongo localhost:27017/" + schemaName + " \"" + pathJsFiles + queryNameExc + ".js\""+ " > \"" +  pathResults + pathResultsDate + "\"" + queryNameExc + "-Results.txt\""  + "\r\n" 
						+ "mongo localhost:27017/admin \"" + pathJsFiles + "stop_mongod.js\""+ "\r\n\r\n" );	
				
				//Temporal 
				
				info += ( "start \"\" \"C:\\Program Files\\MongoDB\\Server\\3.0\\bin\\mongod.exe\"" + "\r\n" 
						+ "mongo localhost:27017/" + schemaName + " \"" + pathJsFiles + "ZHelperMessage_esc.js\""+ "\r\n" 
						+ "mongo localhost:27017/admin \"" + pathJsFiles + "stop_mongod.js\""+ "\r\n\r\n" );	
			}
		}
		
		return info;
	}
	
	public String generateFileExecQuery(String queryName){
		
		String info = "";
		
		info += (
		"var path = \"" + pathJsFiles + "\";" + "\n" + 		
		"var scpt = \"" + queryName +"\";" + "\n" +  
		"load(path + scpt + \".js\");" + "\n" + 
		"\n" + 
		"load(path + \"scExecTimes.js\");" + "\n" + 
		"load(path + \"scExecTimesWOIndex.js\");" + "\n" + 
		"load(path + \"scExecReport.js\");" + "\n" + 
		"var execTimesWI = scExecTimes();" + "\n" + 
		"var execTimesWOI = scExecTimesWOIndex();" + "\n" + 
		"\n" + 
		"--TODO: Drop indexes \n" +  
		"var exQWOI = " + queryName + "();" + "\n" + 
		"\n" + 
		"for(var i = 0; i<execTimesWOI ; i++){" + "\n" + 
		"\texQWOIs.push( " + queryName + "() );" + "\n" + 
		"}" + "\n" + 
		"\n" + 
		"--TODO: Add indexes \n" +  
		"var exQWI = " + queryName + "();" + "\n" + 
		"\n" + 
		"for(var i = 0; i<execTimesWI ; i++){" + "\n" + 
		"\texQWIs.push( " + queryName + "() );" + "\n" + 
		"}" + "\n" + 
		"\n" + 
		"scExecReport2(scpt,exQWOI,exQWI,execTimesWOI,execTimesWI,exQWOIs,exQWIs)" + "\n" +
		"\n");
		
		return info;
	}	
	
	
	public String generateFileImportDB(String dbName){
		
		/*
		 
		 db.dropDatabase()

		mongoimport --db sc02 --collection companies --drop --file D:\data\companies.json
		mongoimport --db sc02 --collection departments --drop --file D:\data\departments.json
		mongoimport --db sc02 --collection employees --drop --file D:\data\employees.json
		use sc02
		
		mongoimport --db scTest --collection companies --drop --file D:\dataTest\companies.json
		mongoimport --db scTest --collection departments --drop --file D:\dataTest\departments.json
		mongoimport --db scTest --collection employees --drop --file D:\dataTest\employees.json
		use scTest		 
		 
		 * */
		
		return "";
	}
	
	
}
