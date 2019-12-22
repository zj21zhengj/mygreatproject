package com.experices;

import com.common.util.WebUtil;
import java.io.File;
import java.util.List;

import com.imooc.dao.ExcelDao;
import com.imooc.domain.OrgBalanceDetail;
import jxl.Workbook;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import jxl.write.Label;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 导出到excel
 */
public class LeadOutExcel {

    private static ApplicationContext ctx = null;
    private static ExcelDao excelDao = null;


    public static void main(String[] args) {
        ctx = new ClassPathXmlApplicationContext("beans2.xml");
        excelDao = (ExcelDao) ctx.getBean("excelDao");
        String fileName = "账户详情";
        //获取绝对路径空指针异常 https://blog.csdn.net/qq_38846242/article/details/83382969
       // String paths = WebUtil.getRealPath();
        List<OrgBalanceDetail> orgBalanceDetailList = excelDao.queryAll();
        WritableWorkbook wwb = null;
        Workbook book = null;
        //List<Per> assetBalanceDetailList = financeCenterBo.queryAssetBalanceDetailList(param);
        try {
            book = Workbook.getWorkbook(new File("C:\\Users\\HengTian\\Desktop\\a\\保证金统计(模板).xls"));
            wwb = Workbook.createWorkbook(new File("C:\\Users\\HengTian\\Desktop\\a\\" + fileName + ".xls"), book);
            WritableSheet sheet = wwb.getSheet(0);
            WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 10);
            WritableFont wf2 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD);
            WritableCellFormat format = new WritableCellFormat(NumberFormats.TEXT);
            WritableCellFormat format2 = new WritableCellFormat(NumberFormats.TEXT);
            format.setFont(wf);
            format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            format.setAlignment(jxl.format.Alignment.CENTRE);
            format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            format.setWrap(true);
            format2.setFont(wf2);
            format2.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            format2.setAlignment(jxl.format.Alignment.LEFT);
            format2.setVerticalAlignment(VerticalAlignment.CENTRE);
            System.out.println(orgBalanceDetailList.size());
            if (null != orgBalanceDetailList && orgBalanceDetailList.size() > 0) {
                for (int i = 0; i < orgBalanceDetailList.size(); i++) {
                    OrgBalanceDetail tmpBean = orgBalanceDetailList.get(i);
                    sheet.addCell(new Label(0, i +1, (String)tmpBean.getOrgCode(),  format));
                    sheet.addCell(new Label(2, i + 1, (String) tmpBean.getAccountType(), format));
                    sheet.addCell(new Label(4, i + 1, (String) tmpBean.getTradeNo(), format));/*
                    sheet.addCell(new Label(5, i + 1, (String) tmpBean.getLastUpdateTime(), format));
                    sheet.addCell(new Label(6, i + 1, (String) tmpBean.getOperAcct(), format));
                    sheet.addCell(new Label(7, i + 1, (String) tmpBean.getSerialNo(), format));*/
                }
            }
            wwb.write();
        } catch (Exception e){
            System.out.println("失败");
            e.printStackTrace();
        } finally {
            if (book != null) {
                try {
                    book.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (wwb != null) {
                try {
                    wwb.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
