package smile.heyi.excel;

public class ExcelException extends Exception {
	public ExcelException(){
		super("´ò¿ªExcel´íÎó");
	}
	
	public ExcelException(String message){
		super(message);
	}
}
