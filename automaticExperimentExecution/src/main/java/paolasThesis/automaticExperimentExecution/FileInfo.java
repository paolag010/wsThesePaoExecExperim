package paolasThesis.automaticExperimentExecution;

public class FileInfo {
	
	private String pathJsFiles = "C:/Users/SONY VAIO/Dropbox/Paola/Estudio/PhDGrenoble/ThesisPaola/ExperimentsSchemas/Experiment/scripts/";
	private String pathResults = "C:/Users/SONY VAIO/Dropbox/Paola/Estudio/PhDGrenoble/ThesisPaola/ExperimentsSchemas/Experiment/";
	private String pathResultsDate = "results020516/";
	
	// Experiment with 5 schemas and 6 queries by schema
	// MongoDB server is started and shutdown before and after to query executions
	
	public String generateInfoExecExperiment1()
	{
		int qtySchemas = 5;
		int qtyQueries = 1;
		String info = "";
		String schemaName = "";
		String queryName = "";
		String queryNameExc = "";
		
		String pathScripts="C:\\Users\\SONY VAIO\\Dropbox\\Paola\\Estudio\\PhDGrenoble\\ThesisPaola\\ExperimentsSchemas\\Experiment\\scripts\\";
		String pathMongoD= "C:\\Program Files\\MongoDB\\Server\\3.0\\bin\\mongod.exe";
		String pathResults="C:/Users/SONY VAIO/Dropbox/Paola/Estudio/PhDGrenoble/ThesisPaola/ExperimentsSchemas/Experiment/results020816/";

		info += (  
				"setlocal" + "\r\n" 
				+ "set pathScripts=\"" + pathScripts + "\r\n" 
				+ "set pathMongoD=\"" + pathMongoD + "\"" + "\r\n" 
				+ "set pathResults=\"" + pathResults + "\r\n" 
				);
				
		for (int i = 1; i <= qtySchemas; i++) {
			schemaName = "sc0" + i; 
			for (int j = 1; j <= qtyQueries; j++) {		
				queryName = schemaName +"_Q" + j;
				queryNameExc = queryName + "_esc";
				info += ( "start \"\" %pathMongoD%" + "\r\n" 
						+ "mongo localhost:27017/" + schemaName + " %pathScripts%" + queryNameExc + ".js\""+ " > %pathResults%" + queryNameExc + "-Results.txt\""  + "\r\n" 
						+ "mongo localhost:27017/admin %pathScripts%" + "stop_mongod.js\""+ "\r\n\r\n" );	
				//Temporal 
				info += ( "start \"\" %pathMongoD%" + "\r\n" 
						+ "mongo localhost:27017/" + schemaName + " %pathScripts%" + "ZHelperMessage_esc.js\""+ "\r\n" 
						+ "mongo localhost:27017/admin %pathScripts%" + "stop_mongod.js\""+ "\r\n\r\n" );
				info += ( "start \"\" %pathMongoD%" + "\r\n" 
						+ "mongo localhost:27017/" + schemaName + " %pathScripts%" + "ZHelperMessage_esc.js\""+ "\r\n"
						+ "mongo localhost:27017/admin %pathScripts%" + "stop_mongod.js\""+ "\r\n\r\n" );	
				
				info += "TIMEOUT /T 60 /NOBREAK" + "\r\n\r\n";
			}
		}
		
		info += "endlocal" + "\r\n";
		
		return info;
	}
	
	public String generateFileExecQuery(String queryName){
		
		String info = "";
		String helperGetPathScripts = "ZHelperGetPathScripts";
		
		info += (
		"load(pwd() + \"\\\" +" + helperGetPathScripts +  ".js);" + "\n" +
		"var path = " + helperGetPathScripts + "();" + "\n" + 		
		"var scpt = \"" + queryName +"\";" + "\n" +  
		"load(path + scpt + \".js\");" + "\n" + 
		"\n" + 
		"load(path + \"scExecTimes.js\");" + "\n" + 
		"load(path + \"scExecTimesWOIndex.js\");" + "\n" + 
		"load(path + \"scExecReport.js\");" + "\n" + 
		"var execTimesWI = scExecTimes();" + "\n" + 
		"var execTimesWOI = scExecTimesWOIndex();" + "\n" +
		"var exQWIs=[];" + "\n" + 
		"var exQWOIs=[]; " + "\n" +
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
