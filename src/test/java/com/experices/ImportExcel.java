package com.experices;

import com.imooc.dao.PersonDao;
import com.imooc.dao.PersonDaoImpl;
import com.imooc.dao.StudentDAO;
import com.imooc.dao.StudentDAOImpl;
import com.imooc.domain.Person;
import com.imooc.domain.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 关于导入excel
 */
public class ImportExcel {

    public static void main(String[] args) {
        Person person = new Person();
        getDataFromExcel("E:\\workspace\\文档\\补数据\\10005.xls",person);
    }


    /**
     * 读取出filePath中的所有数据信息
     * @param filePath excel文件的绝对路径
     *
     */

    public static void getDataFromExcel(String filePath, Person person) {
        if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
            System.out.println("文件不是excel类型");
        }
        FileInputStream fis = null;
        Workbook wookbook = null;
        int lineNum = 0;
        Sheet sheet = null;
        try {
            //获取一个绝对地址的流
            fis = new FileInputStream(filePath);
            //2003版本的excel，用.xls结尾, 2007版本以.xlsx
            if (filePath.endsWith(".xls")) {
                wookbook = new HSSFWorkbook(fis);//得到工作簿
            } else {
                wookbook = new XSSFWorkbook(fis);//得到工作簿
            }
            //得到一个工作表
            sheet = wookbook.getSheetAt(0);
            //获得表头
            Row rowHead = sheet.getRow(0);
            //列数
            int rows = rowHead.getPhysicalNumberOfCells();
            //行数
            lineNum = sheet.getLastRowNum();
            System.out.println(lineNum);
            if (0 == lineNum) {
                System.out.println("Excel内没有数据！");
            }
            getData(sheet, lineNum, rows, person);
            //System.out.println("Excel"+lineNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //https://blog.csdn.net/weixin_43209201/article/details/86519522
    //https://blog.csdn.net/qq_21764553/article/details/79153227
    public static  void  getData(Sheet sheet, int lineNum, int rowNum, Person person){
        //获得所有数据
        for(int i =2; i <= lineNum ; i++){
            //获得第i行对象
            Row row = sheet.getRow(i);
            List<String> list = new ArrayList<>();
            String str2 = "";
            String str3 = "";
            double d = 0;
            for(int j=1; j<rowNum; j++){
                String str = "";
                if (j == 3 ) {
                    //System.out.println(row.getCell(j));
                    Date d2 = row.getCell(j).getDateCellValue();
                    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    str2 = formater.format(d2);
                    //System.out.println(str2);
                    //str = getRightTypeCell(row.getCell(j));
                }
                else if (j== 18) {
                    System.out.println(row.getCell(j));
                    Date d2 = row.getCell(j).getDateCellValue();
                    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    str3 = formater.format(d2);
                    //System.out.println(str2);
                    //str = getRightTypeCell(row.getCell(j));
                }
                else if(j == 7)
                    d = getRightTypeCell2(row.getCell(j));
                else {
                    //System.out.println(j);
                    str = getRightTypeCell(row.getCell(j));
                }
                list.add(str);
            }
            person.setFlow(list.get(0));
            person.setType(list.get(1));
            person.setTransDate(str2);
            person.setOrgCode(list.get(5));
            person.setMoneys(d);
            person.setDingDan(list.get(7));
            person.setQianZhi(list.get(15));
            person.setOper(list.get(16));
            person.setUpdateTime(str3);
            //System.out.println(person.toString());
            PersonDao studentDAO = new PersonDaoImpl();
            studentDAO.save1(person);
        }
    }

    /**
     * @param cell 一个单元格的对象
     * @return 返回该单元格相应的类型的值
     */
    public static String getRightTypeCell(Cell cell){
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }

    public static Double getRightTypeCell2(Cell cell){
        cell.setCellType(CellType.NUMERIC);
        return cell.getNumericCellValue();
    }
}

