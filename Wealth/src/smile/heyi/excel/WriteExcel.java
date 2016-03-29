package smile.heyi.excel;

import java.io.IOException;
import java.util.ArrayList;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteExcel extends CreateExcel {
	private WritableWorkbook workbook;
	private WritableSheet sheet;
	private Label labeAll[][], labeRow[], labeColumn[];
	
	private String sheetName = "sheet1";
	private String filePath;
	
	
	public WriteExcel(String path) throws ExcelException, IOException {
		workbook = getWorkBook(path);
		sheet = workbook.createSheet(sheetName, 0);
		
	}
	
	public WriteExcel(){
		super();
	}
	
//	public void setSheetName(String name){
//		this.sheetName = name;
//		sheet = workbook.createSheet(sheetName, 0);
//	}
//	
//	public void setExcelPath(String path) throws IOException, ExcelException{
//		this.filePath = path;
//		workbook = super.getWorkBook(filePath);
//	}
	
	public void setExcelInfo(String path, String sheetname) throws IOException, ExcelException{
		this.filePath = path;
		this.sheetName = sheetname;
		
		workbook = getWorkBook(filePath);
		sheet = workbook.createSheet(sheetName, 0);
	}
	
	public void setCellRow(int startRow, int startColumn, ArrayList info) throws RowsExceededException, WriteException{
		ArrayList list = info;
		labeRow = new Label[list.size()];
		for(int i=startRow;i<list.size()+startRow;i++){
			labeRow[i-startRow]= new Label(i,startColumn,list.get(i-startRow).toString());
			sheet.addCell(labeRow[i-startRow]);
		}
	}
	
	public void setCellRow(int startRow, int startColumn, String[] info) throws RowsExceededException, WriteException{
		String tmp[] = info;
		labeRow = new Label[tmp.length];
		for(int i=startRow;i<tmp.length+startRow;i++){
			labeRow[i-startRow] = new Label(i,startColumn,tmp[i-startRow]);
			sheet.addCell(labeRow[i-startRow]);
		}
	}
	
	public void setCellColumn(int startRow, int startColumn, String[] info) throws RowsExceededException, WriteException{
		String tmp[] = info;
		Label[] Column = new Label[tmp.length];
		for(int i=0;i<tmp.length;i++){
			labeColumn[i] = new Label(startColumn+i,startRow,tmp[i]);
			sheet.addCell(labeColumn[i]);
		}
	}
	
	public void setCellColumn(int startRow, int startColumn, ArrayList info) throws RowsExceededException, WriteException{
		ArrayList list = info;
		Label[] Column = new Label[list.size()];
		for(int i=0;i<list.size();i++){
			labeColumn[i] = new Label(startColumn+i,startRow,list.get(i).toString());
			sheet.addCell(labeColumn[i]);
		}
	}
	
	
	public void setCell(int row,int column, String str){
		labeAll = new Label[row+1][column+1];
		labeAll[row][column]= new Label(column,row,str);
		try {
			sheet.addCell(labeAll[row][column]);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write() throws RowsExceededException, WriteException, IOException{
		workbook.write();
		workbook.close();
	}
	
}
