package smile.heyi.excel;

public class ExcelException extends Exception {
	public ExcelException(){
		super("��Excel����");
	}
	
	public ExcelException(String message){
		super(message);
	}
}
