
public class StoreResults {
	
	 public void CreateResultsFile() throws IOException {
	   	 // Create Results File based on Date and Time Stamp
	   	 String linestr;
		   	 String[] datesplit = new Date().toString().split(" ",0);
		   	 datesplit[3]=datesplit[3].replaceAll(":","_");
		   	 String Results_FilePath_Base ="C:\\\\Work\\\\eclipse-workspace\\\\DrachmaSelenium\\\\Production\\\\V1Jan2019\\\\Selenium\\\\Quotations\\\\Unipay_Results\\\\Automated_Test_Results.htm";
		   	 Results_FilePath ="C:\\Work\\eclipse-workspace\\\\\\\\DrachmaSelenium\\\\\\\\Production\\\\\\\\V1Jan2019\\\\\\\\Selenium\\\\\\\\Quotations\\\\\\\\Unipay_Results\\\\\\\\"+"\\\\Automated_Test_Results_" + datesplit[2]+datesplit[1]+datesplit[5]+"_"+datesplit[3]+".htm";
		     System.out.println(Results_FilePath);
		   	 FileWriter out = new FileWriter(Results_FilePath);
		 	 BufferedWriter writer = new BufferedWriter(out);
		   	 FileReader in = new FileReader(Results_FilePath_Base);
		   	 BufferedReader reader = new BufferedReader(in);
		   	 
		   	 while((linestr = reader.readLine()) != null) { 
		   	 	writer.write(linestr);
		   	    writer.newLine();   
		   	 }
		   	 
		   	 writer.close();
		   	 reader.close();
		   	 //Creates the Log File based on Date and Time Stamp
//		   	 Log_FilePath = GetConfig("Logs")+"\\\\Quotation_Log_" + datesplit[2]+datesplit[1]+datesplit[5]+"_"+datesplit[3]+".txt";
//		   	 out = new FileWriter(Log_FilePath);
		 	 writer = new BufferedWriter(out);
		   	 writer.close();
		   	 
		}

}
