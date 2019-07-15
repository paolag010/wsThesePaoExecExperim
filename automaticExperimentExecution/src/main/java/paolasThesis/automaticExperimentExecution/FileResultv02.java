package paolasThesis.automaticExperimentExecution;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class FileResult {

	
	private String pathResults = "C:/Users/PaoG/Dropbox/resultat/server/";
	private String pathResultsDate = "results101718_Setup02/";
	private FileHelper fh;
	
	public FileResult()
	{
		//inF = new FileInfo();
		fh =new FileHelper();
	}
	
	
	public ArrayList<String> extractResults(){		
		int qtySchemas = 9;                                 //*********
		int qtyQueries = 5;                                 //********
		String path = "";
		String pathExcel = "";
		String schemaName = "";
		String queryName = "";
		String queryNameExc = "";
		ArrayList<String> results = new ArrayList<String>();
		ArrayList<String> resultsTraces = new ArrayList<String>();
		ArrayList<String> resultsCI = new ArrayList<String>();		
		String result = "";
		String fileName = "serverExperiment_results101718_Setup02"; 
				
	    Workbook wb = new HSSFWorkbook(); 		//Workbook wb = new XSSFWorkbook();
	    CreationHelper createHelper = wb.getCreationHelper();

	    // TraceWithOutIndex sheet
	    int currRowWOI0 = 0;	   
	    Sheet sheetWOI = wb.createSheet("WithOutIndexes");	    
	    Row rowWOI0 = sheetWOI.createRow((short)currRowWOI0);
	    rowWOI0.createCell(0).setCellValue("SC");
	    rowWOI0.createCell(1).setCellValue("Q");
	    rowWOI0.createCell(2).setCellValue("T");	 
	    currRowWOI0++;	    
	    
	    // TraceWithIndex sheet
	    int currRowWI0 = 0;
	    Sheet sheetWI = wb.createSheet("WithIndexes");	    
	    Row rowWI0 = sheetWI.createRow((short)currRowWI0);
	    rowWI0.createCell(0).setCellValue("SC");
	    rowWI0.createCell(1).setCellValue("Q");
	    rowWI0.createCell(2).setCellValue("T");	 
	    currRowWI0++;
	    
	    int currCTemp = 10;
	    
	    // Main sheet - Create a row and put some cells in it. Rows are 0 based.
	    int currCell = 0;
	    Sheet sheet = wb.createSheet(fileName);
	    sheet.createRow((short)0);
	    Row row2 = sheet.createRow((short)1);
    	Cell cellR2 = row2.createCell(currCell);	    
	    cellR2.setCellValue("--");	    
	    
		for (int j = 5; j <= qtyQueries; j++) {								//********
			queryName = "Q" + j;	
			currCell++;
			row2.createCell(currCell).setCellValue(queryName);
			currCell++;
			row2.createCell(currCell).setCellValue(queryName+ " - min");
			currCell++;
			row2.createCell(currCell).setCellValue(queryName+ " - max");		    
			currCell++;
			row2.createCell(currCell).setCellValue(queryName+ " - dev");
		    currCell++;
			row2.createCell(currCell).setCellValue(queryName+ " - avg");
			currCell++;
			row2.createCell(currCell).setCellValue(queryName+ " - index");
			currCell++;
			row2.createCell(currCell).setCellValue(queryName+ " - index min");
			currCell++;
			row2.createCell(currCell).setCellValue(queryName+ " - index max");
			currCell++;
			row2.createCell(currCell).setCellValue(queryName+ " - index dev");
			currCell++;
			row2.createCell(currCell).setCellValue(queryName+ " - index avg");
			currCell++;
			row2.createCell(currCell).setCellValue(queryName+ " - per dec");			
		}
		
	    // Creation indexes times
	    int currCellCI = 0;		
	    int currRowCI = 0;
	    Sheet sheetCI = wb.createSheet("IndexesCreation");	    
	    Row rowCI0 = sheetCI.createRow((short)currRowCI);
	    rowCI0.createCell(currCellCI).setCellValue("--");
	    currRowCI++;
	    Row rowCI1 = sheetCI.createRow((short)currRowCI);
	    rowCI1.createCell(currCellCI).setCellValue("--");
	    currRowCI++;	
	    currCellCI++;
	    
		for (int j = 5; j <= qtyQueries; j++) {											//**********
			queryName = "Q" + j;	
			rowCI0.createCell(currCellCI).setCellValue(queryName);			
			rowCI1.createCell(currCellCI).setCellValue("Collection-Index-Time");
			currCellCI++;
		}	 
		currCellCI=0;
	    
		
		for (int i = 8; i <= qtySchemas; i++) {											//***************
			schemaName = "sc0" + i; 
			
			currCell = 0;
		    Row row = sheet.createRow((short)i+1);
	    	Cell cell = row.createCell(currCell);
		    cell.setCellValue(schemaName);		
		    
		    currCellCI = 0;		    
		    Row rowI = sheetCI.createRow((short)currRowCI);
		    rowI.createCell(currCellCI).setCellValue(schemaName);
		    currCellCI++;
		    currRowCI++;
		    
			for (int j = 5; j <= qtyQueries; j++) {												//********
				queryName = "Q" + j;
				queryNameExc = schemaName + "_" + queryName + "_esc";
				path = ( pathResults + pathResultsDate + queryNameExc + "-Results.txt" );	
				pathExcel = ( pathResults + pathResultsDate + fileName + ".xls" );
				
				try {
					result = fh.readFile(path);
				} catch (Exception e) {					
					e.printStackTrace();	// TODO
				}
				
			    results = new ArrayList<String>();
				Pattern p = Pattern.compile("\\[(.*?)\\]");
				Matcher m = p.matcher(result);
				while(m.find())
				{
					results.add(m.group(1));
				}

				if(results.isEmpty()){
				    for (int k = 0; k < 11; k++) {
				    	currCell++;
				    	row.createCell(currCell).setCellValue( "--" );
					}
				}else{
				    for (int k = 0; k < 11; k++) {
				    	currCell++;
				    	row.createCell(currCell).setCellValue(Double.parseDouble( results.get(k)) );
					}
				}				
							
				
				// Traces 		
				resultsTraces = new ArrayList<String>();
				Pattern pT = Pattern.compile("\\#(.*?)\\#");
				Matcher mT = pT.matcher(result);
				while(mT.find())
				{
					resultsTraces.add(mT.group(1));
				}
				
				// Traces - Without indexes
				String timesWOI[] = resultsTraces.get(0).split(",");
			    for (int k = 0; k < timesWOI.length; k++) {
			    	Row rowT = sheetWOI.createRow((short)currRowWOI0);
			    	rowT.createCell(0).setCellValue(schemaName);
			    	rowT.createCell(1).setCellValue(queryName);			    	
			    	rowT.createCell(2).setCellValue(Integer.parseInt( timesWOI[k] ));
			    	currRowWOI0++;
				}

			    
			    sheetWOI.getRow(0).createCell(currCTemp).setCellValue(schemaName+"-"+queryName);
			    int currRTemp = 1;
			    for (int k = 0; k < timesWOI.length; k++) {
			    	sheetWOI.getRow(currRTemp).createCell(currCTemp).setCellValue(Integer.parseInt( timesWOI[k] ));
			    	currRTemp++;
				}	
			    
			    // Traces - Without indexes
			    String timesWI[] = resultsTraces.get(1).split(",");
			    for (int k = 0; k < timesWI.length; k++) {
			    	Row rowT = sheetWI.createRow((short)currRowWI0);
			    	rowT.createCell(0).setCellValue(schemaName);
			    	rowT.createCell(1).setCellValue(queryName);			    	
			    	rowT.createCell(2).setCellValue(Integer.parseInt( timesWI[k] ));
			    	currRowWI0++;
				}
			    
			    sheetWI.getRow(0).createCell(currCTemp).setCellValue(schemaName+"-"+queryName);
			    currRTemp = 1;
			    for (int k = 0; k < timesWI.length; k++) {
			    	sheetWI.getRow(currRTemp).createCell(currCTemp).setCellValue(Integer.parseInt( timesWI[k] ));
			    	currRTemp++;
				}	
			    currCTemp++;
			    
				// Indexes creation 
			    resultsCI = new ArrayList<String>();
				Pattern pCI = Pattern.compile("\\{(.*?)\\}");
				Matcher mCI = pCI.matcher(result);
				while(mCI.find())
				{
					resultsCI.add(mCI.group(1));
				}
				
				rowI.createCell(currCellCI).setCellValue(resultsCI.get(0));
				currCellCI++;
				
//			    row.createCell(2).setCellValue(createHelper.createRichTextString("This is a string"));
			}
		}
		
		
        try{
		    FileOutputStream fileOut = new FileOutputStream(pathExcel);
		    wb.write(fileOut);
		    fileOut.close();
	        System.out.println("File .xlsx written successfully on disk.");
	    } 
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }		
		
		return results;		
	} 
	
}
