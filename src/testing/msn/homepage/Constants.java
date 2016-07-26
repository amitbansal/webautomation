package testing.msn.homepage;

public class Constants {
	public String File_Path;
    public String File_Name;
    public String Sheet_Name;
    public String Hub_URL;
    public String Screenshot_Path;
    public String FireFoxProfile_Name;
    public String Reportfile_Path;
    public static String ImagetagFailTest;
    public static String Data_File="C:\\seleniumQA\\workspace\\testing\\src\\datafile.properties";
    
    
	public Constants(){
		ExternalConstants.init();
		File_Path=ExternalConstants.prop.getProperty("File_Path");
		File_Name=ExternalConstants.prop.getProperty("File_Name");
		Sheet_Name=ExternalConstants.prop.getProperty("Sheet_Name");
		Hub_URL=ExternalConstants.prop.getProperty("Hub_URL");
		Screenshot_Path=ExternalConstants.prop.getProperty("Screenshot_Path");		
		FireFoxProfile_Name=ExternalConstants.prop.getProperty("FireFoxProfile_Name");
		Reportfile_Path=ExternalConstants.prop.getProperty("Reportfile_Path");
	}
	      
      
}