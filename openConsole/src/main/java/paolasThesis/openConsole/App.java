package paolasThesis.openConsole;

import java.io.IOException;

/**
 * TODO
 *
 */
public class App 
{
	public static void main(String[] args) {
	    try {
	    	String newPath = "C:/Program Files/MongoDB/Server/3.2/bin/";
	    	String commandOpenCmd = "cmd.exe /c cd \""+newPath+"\" & start";
	    	String commandExecuteBat = " \"\" \"D:/testConsole/00-ExperimentExecConsolePromt.bat\"";
	    	//String commandExecuteMongoD = " \"\" \"C:/Program Files/MongoDB/Server/3.0/bin/mongod.exe\"";
	    	
	    	//Runtime.getRuntime().exec("cmd.exe /c cd \""+newPath+"\" & start");
	    	Runtime.getRuntime().exec(commandOpenCmd + commandExecuteBat);
	    	
	        System.out.println("ok");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
}
