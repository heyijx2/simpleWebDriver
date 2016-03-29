package smile.heyi.excel;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.Workbook;
import jxl.write.WritableWorkbook;



 class CreateExcel {
	private String path;
	WritableWorkbook wwb;
	

	public  CreateExcel() {
		
	}
	
	private WritableWorkbook createWorkBook() throws IOException {		
		OutputStream os = new FileOutputStream(path);
		wwb = Workbook.createWorkbook(os);
		return wwb;
	}
	
	private Boolean judgePath(String name){
		Boolean r = true;
		StringBuilder sb = new StringBuilder(name);
		//删除“\”前的所内容
		sb.delete(0, sb.lastIndexOf(".")+1);
		
		String regEx="xls";
		Pattern p=Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);
		Matcher m=p.matcher(sb.toString()); 
		if(m.matches()){
			r = true;
		}else{
			r = false;
		}
		return r;
	}
	

	
	public WritableWorkbook getWorkBook(String path) throws IOException, ExcelException{
		if(judgePath(path)){
				this.path = path;
				createWorkBook();
				
		}else{
			throw new ExcelException("Error");
		}

		return wwb;
	}
	
	
	
}
