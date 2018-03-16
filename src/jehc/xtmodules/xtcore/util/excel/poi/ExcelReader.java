package jehc.xtmodules.xtcore.util.excel.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
  
/** 
 * 操作Excel表格的功能类 
 */  
public class ExcelReader {  
    private Sheet sheet;  
    private Row row;  
    /** 
     * 读取Excel数据内容 
     * @param InputStream 
     * @return Map 包含单元格数据内容的Map对象 
     */  
    @SuppressWarnings("resource")
	public Map<Integer, List<String>> readExcelContent(File file) {  
        Map<Integer, List<String>> content = new HashMap<Integer, List<String>>();  
        try {  
            Workbook wb = null;  
            try{  
            	wb = new HSSFWorkbook(new FileInputStream(file)); 
            }catch(OfficeXmlFileException e){  
            	wb = new XSSFWorkbook(new FileInputStream(file));  
            }  
            
            sheet = wb.getSheetAt(0);  
            // 得到总行数  
            int rowNum = sheet.getLastRowNum()+1;  
            row = sheet.getRow(0);  
            int colNum = row.getPhysicalNumberOfCells();  
            // 正文内容应该从第二行开始,第一行为表头的标题  
            for (int i = 0; i < rowNum; i++) {  
                row = sheet.getRow(i);  
                if(row==null){  
                    break;  
                }  
                List<String> list = new ArrayList<String>();  
                for (int j = 0; j < colNum; j++) {  
                      
                    Cell cell = row.getCell(j);  
                    if(cell != null) {  
                        switch (cell.getCellType()) {       
                        case HSSFCell.CELL_TYPE_NUMERIC: // 数字       
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {       
                                //如果是date类型则 ，获取该cell的date值       
                                list.add(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()).toString());       
                            } else { // 纯数字       
                                double d = cell.getNumericCellValue();  
                                if (d - (int) d < Double.MIN_VALUE) {   
                                // 是否为int型  
                                list.add(Integer.toString((int) d));  
                                } else {   
                                 // 是否为double型  
                                list.add(Double.toString(cell.getNumericCellValue()));  
                                }  
                            }  
                            break;       
                        case HSSFCell.CELL_TYPE_STRING: // 字符串       
                            list.add(cell.getStringCellValue() + "");       
                            break;       
                        case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean       
                            list.add(cell.getBooleanCellValue() + "");       
                            break;       
                        case HSSFCell.CELL_TYPE_FORMULA: // 公式       
                            list.add(cell.getCellFormula() + "");       
                            break;       
                        case HSSFCell.CELL_TYPE_BLANK: // 空值       
                            list.add("");       
                            break;       
                        case HSSFCell.CELL_TYPE_ERROR: // 故障       
                            list.add("");       
                            break;       
                        default:       
                            list.add("");       
                            break;  
                        }  
                    } else {  
                        list.add("");  
                    }  
                }  
                content.put(i, list);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return content;  
    }  
    
	@SuppressWarnings("resource")
	public Map<Integer, List<String>> readExcelContent(InputStream inputStream) {  
        Map<Integer, List<String>> content = new HashMap<Integer, List<String>>();  
        try {  
            Workbook wb = null; 
            try{  
                wb = new HSSFWorkbook(inputStream);  
            }catch(OfficeXmlFileException e){  
                wb = new XSSFWorkbook(inputStream);  
            }  
            sheet = wb.getSheetAt(0);  
            // 得到总行数  
            int rowNum = sheet.getLastRowNum()+1;  
            row = sheet.getRow(0);  
            int colNum = row.getPhysicalNumberOfCells();  
            // 正文内容应该从第二行开始,第一行为表头的标题  
            for (int i = 0; i < rowNum; i++) {  
                row = sheet.getRow(i);  
                if(row==null){  
                    break;  
                }  
                List<String> list = new ArrayList<String>();  
                for (int j = 0; j < colNum; j++) {  
                      
                    Cell cell = row.getCell(j);  
                    if(cell != null) {  
                        switch (cell.getCellType()) {       
                        case HSSFCell.CELL_TYPE_NUMERIC: // 数字       
                            /*if (HSSFDateUtil.isCellDateFormatted(cell)) {       
                                //如果是date类型则 ，获取该cell的date值       
                                list.add(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()).toString());       
                            } else { // 纯数字       
                                double d = cell.getNumericCellValue();  
                                if (d - (int) d < Double.MIN_VALUE) {   
                                // 是否为int型  
                                list.add(Integer.toString((int) d));  
                                } else {   
                                 // 是否为double型  
                                list.add(Double.toString(cell.getNumericCellValue()));  
                                }  
                            }  */
                        	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                        	list.add(cell.getStringCellValue() + "");  
                            break;       
                        case HSSFCell.CELL_TYPE_STRING: // 字符串       
                            list.add(cell.getStringCellValue() + "");       
                            break;       
                        case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean       
                            list.add(cell.getBooleanCellValue() + "");       
                            break;       
                        case HSSFCell.CELL_TYPE_FORMULA: // 公式       
                            list.add(cell.getCellFormula() + "");       
                            break;       
                        case HSSFCell.CELL_TYPE_BLANK: // 空值       
                            list.add("");       
                            break;       
                        case HSSFCell.CELL_TYPE_ERROR: // 故障       
                            list.add("");       
                            break;       
                        default:       
                            list.add("");       
                            break;  
                        }  
                    } else {  
                        list.add("");  
                    }  
                }  
                content.put(i, list);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return content;  
    }  
}  