package smile.heyi.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class UpdateExcel {
	private Workbook wb = null ;
	private InputStream is;
	private WritableWorkbook book = null;
	private  WritableSheet sheet  ;
	private String path ="";
	private Label labeAll[][], labeRow[], labeColumn[];
	
	private String sheetName = "sheet1";
	private int sheetID = 0;
	public UpdateExcel(String path){
		this.path = path;
	}
	
	public UpdateExcel(String path,int sheet){
		this.path = path;
		if(sheet>0){
			this.sheetID = sheet-1;
		}else{
			this.sheetID = 0;
		}
	}
	
	private void init(){
		try {
			is = new FileInputStream(path);
			wb = Workbook.getWorkbook(is);
			book = Workbook.createWorkbook(new File(path), wb);//����workbook�ĸ���
			sheet = book.getSheet(sheetID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private int judy(int i){
		if(i>0){
			return i-1;
		}else{
			return 0;
		}
	}

	
	/**
	 * 修改指定单元格内容
	 * @param column 列号，从1开始
	 * @param row 行号，从1开始
	 * @param info 要修改的内容
	 */
	public void updateCell(int column, int row, String info){
		init();
		WritableCell cell =sheet.getWritableCell(judy(column), judy(row));//��ȡ��һ����Ԫ��
		
		CellFormat cf = cell.getCellFormat();//��ȡ��һ����Ԫ��ĸ�ʽ

		
		Label lbl = new Label(judy(column), judy(row), info,cf);//����һ����Ԫ���ֵ��Ϊ���޸����ֵ��
//		if(cf != null){
//			lbl.setCellFormat(cf);//���޸ĺ�ĵ�Ԫ��ĸ�ʽ�趨�ɸ�ԭ��һ��
//			System.out.println("ssss");
//		}
		try {
			sheet.addCell(lbl);//���Ĺ�ĵ�Ԫ�񱣴浽sheet
			
			book.write();
			book.close();
			wb.close();
			is.close();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改整列数据
	 * @param column 要修改的列号，从1开始
	 * @param startRow 从第几行开始，从1开始
	 * @param info 要修改的数据，ArrayList类型
	 */
	public void updateColumn(int column, int startRow, ArrayList info){
		init();
		ArrayList list = info;
		int startNumber = judy(startRow);
		int endNumber = judy(startRow + (list.size()-1));
		
		
		try {
			Label lb = null;
			int m = 0;
			for(int i=startNumber; i<=endNumber; i++){
				//获得单元格格式
				WritableCell cell =sheet.getWritableCell(judy(column),i);//��ȡ��һ����Ԫ��
				CellFormat cf = cell.getCellFormat();//��ȡ��һ����Ԫ��ĸ�ʽ
				
				lb = new Label(judy(column), i, list.get(m).toString(),cf);
			
				sheet.addCell(lb);
				m++;
			}
			book.write();
			book.close();
			wb.close();
			is.close();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改整行数据
	 * @param row 要修改的行号，从1开始
	 * @param startColumn 从第几列开始，从1开始
	 * @param info 要修改的数据，ArrayList类型
	 */
	public void updateRow(int row, int startColumn, ArrayList info){
		init();
		ArrayList list = info;
		int startNumber = judy(startColumn);
		int endNumber = judy(startColumn + (list.size()-1));
		
		
		
		try {
			Label lb = null;
			int m = 0;
			for(int i=startNumber; i<=endNumber; i++){
				//获得单元格格式
				WritableCell cell =sheet.getWritableCell(i, judy(row));//��ȡ��һ����Ԫ��
				CellFormat cf = cell.getCellFormat();//��ȡ��һ����Ԫ��ĸ�ʽ
				
				lb = new Label(i, judy(row), list.get(m).toString(),cf);
				sheet.addCell(lb);
				m++;
			}
			book.write();
			book.close();
			wb.close();
			is.close();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public void setCellColumn(int startRow, int startColumn, String[] info) throws RowsExceededException, WriteException{
//		String tmp[] = info;
//		Label[] Column = new Label[tmp.length];
//		for(int i=0;i<tmp.length;i++){
//			labeColumn[i] = new Label(startColumn+i,startRow,tmp[i]);
//			sheet.addCell(labeColumn[i]);
//		}
//	}
	
	

	
}
