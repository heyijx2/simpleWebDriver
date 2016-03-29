package smile.heyi.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ReadExcel extends CreateExcel {
	private Workbook workbook;
	private Sheet sheet;
	private InputStream input = null;
  

	
	private String path;
	
	public ReadExcel(String path)  {
		this.path = path;
		try {
			input = new FileInputStream(path);
			workbook = Workbook.getWorkbook(input) ;
			sheet = workbook.getSheet(0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ReadExcel(){
		super();
	}
	
	
	public void setPath(String path, int sheet) {
		this.path = path;
		try {
			workbook = Workbook.getWorkbook(new File(path)) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sheet>0){
			this.sheet = workbook.getSheet((sheet-1));
		}else{
			this.sheet = workbook.getSheet(0);
		}
	}
	
	/**
	 * ���EXCEL��sheetҳ����
	 * @return
	 */
	public int getSheetSum(){
		int sum =0;
		sum = sheet.getNumberOfImages();
		return sum;
	}
	
	/**
	 * ���ָ��sheetҳ����
	 * @param sheetmember
	 * @return
	 */
	public String getSheetName(int sheetmember){
		String name = "";
		name = sheet.getName();
		return name;
	}
	
	/**
	 * �õ�������
	 * @return
	 */
	public int getRowSum(){
		int sum =0;
		sum = sheet.getRows();
		return sum;
	}
	
	/**
	 * �õ�������
	 * @return
	 */
	public int getColumnSum(){
		int sum =0;
		sum = sheet.getColumns();
		return sum;
	}
	/**
	 * ��ȡָ����Ԫ������
	 * @param Column �кţ���1��ʼ
	 * @param Row �кţ���1��ʼ
	 * @return
	 */
	public String getCell(int Column, int Row){
		Cell cell = sheet.getCell(Column-1, Row-1);
		
		return getCellString(cell);
	}
	
	public String getCellString(Cell cell){
		Range[] ranges = sheet.getMergedCells();
		
		int cellRow = cell.getRow();
		int cellColumn = cell.getColumn();
		String flag = cell.getContents();
		
		for(Range e : ranges){
			int startRow = e.getTopLeft().getRow();
			int startColumn = e.getTopLeft().getColumn();
			int endRow = e.getBottomRight().getRow();
			int endColumn = e.getBottomRight().getColumn();

			if(cellRow > startRow && cellRow <= endRow
					&& cellColumn >= startColumn && cellColumn <= endColumn){
				flag = e.getTopLeft().getContents();
				break;
			}
		}
		return flag;
	}
	
	
	public ArrayList<String> getRowToArrayList(int Row){
		ArrayList<String> list = new ArrayList<String>();
		Cell cell[] = sheet.getRow(Row);
		for(int i=0;i<cell.length;i++){
			list.add(getCellString(cell[i]));
		}
		return list;
	}
	
	/**
	 * �õ������ݣ�����ArrayList����
	 * @param Row Ҫ��ȡ���к�
	 * @param startColumn ָ����ʼ���к�
	 * @param endColumn  ָ�������к�
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getRowToArrayList(int Row, int startColumn, int endColumn){
		ArrayList<String> list = new ArrayList<String>();
		Cell cell[] = sheet.getRow(Row-1);
		for(int i=startColumn-1; i<=endColumn-1; i++){
			list.add(getCellString(cell[i]));
		}
		return list;
	}
	
	
	
	/**
	 * �õ��������ݣ�����ArrayList����
	 * @param Column ָ����ȡ�ڼ���
	 * @return
	 */
	public ArrayList<String> getColumnToArrayList(int Column){
		ArrayList<String> list = new ArrayList<String>();
		Cell cell[] = sheet.getColumn(Column);
		for(int i=0;i<cell.length;i++){
			list.add(getCellString(cell[i]));
		}
		
		return list;
	}
	
	/**
	 * �õ��������ݣ�����ArrayList����
	 * @param Column ָ����ȡ�ڼ���
	 * @param startRow �ӵڼ��п�ʼ
	 * @param endRow  �����к�
	 * @return
	 */
	public ArrayList<String> getColumnToArrayList(int Column, int startRow, int endRow){
		ArrayList<String> list = new ArrayList<String>();
		Cell cell[] = sheet.getColumn(Column-1);
		for(int i=startRow-1; i<=endRow-1; i++){
			list.add(getCellString(cell[i]));
		}
		return list;
	}
	
	public ArrayList<Integer> getRowNumber(int column, String info){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int columnNumber =  getColumnToArrayList(column).size();
		for(int i=1;i<=columnNumber;i++){
			String s = getCell(column,i);
			if(s.equals(info)){
				list.add(i);
			}
		}
		
		return list;
	}
	
	public String[] getColumnToStringArray(int Column){
		String [] tmp;
		Cell cell[] = sheet.getColumn(Column);
		tmp = new String[cell.length];
		for(int i=0;i<cell.length;i++){
			tmp[i] = getCellString(cell[i]);
		}
		return tmp;
	}
	
	public String[] getRowToStringArray(int Row){
		String [] tmp;
		Cell cell[] = sheet.getRow(Row);
		tmp = new String[cell.length];
		for(int i=0;i<cell.length;i++){
			tmp[i] = getCellString(cell[i]);
		}
		return tmp;
	}
	
	/**
	 * ����Excel��ָ�������ڵ�ֵ
	 * @param startColumn ��ʼ�к�
	 * @param endColumn �����к�
	 * @param startRow ��ʼ�к�
	 * @param endRow �����к�
	 * @return ArrayList������
	 */
	public ArrayList<String>[] getZoneToArrayList(int startColumn, int endColumn, 
			int startRow, int endRow){
		int sum = endRow-startRow+1;
		ArrayList[] list = new ArrayList [sum];
		for(int i=0; i<sum ; i++){
			list[i] = this.getRowToArrayList(startRow+i, startColumn, endColumn); 
		}
		
		return list;
	}
}
