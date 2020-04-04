package com.tencent.mashibing.step010;

import jxl.Workbook;
import jxl.format.VerticalAlignment;
import jxl.write.*;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class App010 {
    /**
            * 应用程序主函数
     *
             * @param argvArray 参数数组
     * @throws Exception
     */
    static public void main(String[] argvArray) throws Exception {
        (new App010()).start();
    }

    /**
     * 测试开始
     */
    private void start() throws Exception {
        // 加载 Mysql 驱动
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // 数据库连接地址
        String dbConnStr = "jdbc:mysql://122.51.48.108:3306/hzfi_app?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai&allowMultiQueries=true&user=root&password=Zaq1@3edc";
        // 创建数据库连接
        Connection conn = DriverManager.getConnection(dbConnStr);
        // 简历陈述对象
        Statement stmt = conn.createStatement();

        // 创建 SQL 查询
        // ormtest 数据库中有个 t_user 数据表,
        // t_user 数据表包括三个字段: user_id、user_name、password,
        // t_user 数据表有 20 万条数据
        String sql = "select * from b_subject";

        // 执行查询
        ResultSet rs = stmt.executeQuery(sql);

        // 获取开始时间
        long t0 = System.currentTimeMillis();

        SubjectEntity_Helper helper = new SubjectEntity_Helper();

        List<SubjectEntity> lists = new ArrayList<>();
        while (rs.next()) {
            // 创建新的实体对象

            SubjectEntity sue = helper.create(rs);
            lists.add(sue);
           // 创建新的实体对象,
            // 这里已经把创建过程封装到助手类中了...
            // 这么做的好处 step000 中已经提到过了
        }

        // 获取结束时间
        long t1 = System.currentTimeMillis();

        // 关闭数据库连接
        stmt.close();
        conn.close();

        // 打印实例化花费时间
        System.out.println("实例化花费时间 = " + (t1 - t0) + "ms");
        System.out.println(lists.size());

        //增加导出功能
        getXlsFile(lists);
    }


    private static void getXlsFile(List<SubjectEntity> lists) {
        WritableWorkbook wwb = null;
        Workbook book = null;
        //List<Per> assetBalanceDetailList = financeCenterBo.queryAssetBalanceDetailList(param);
        try {
            book = Workbook.getWorkbook(new File("D:\\learnspace\\保证金统计(模板).xls"));
            wwb = Workbook.createWorkbook(new File("D:\\learnspace\\保证金统计.xls"), book);
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
            //System.out.println(orgBalanceDetailList.size());
            if (null != lists && lists.size() > 0) {
                for (int i = 0; i < lists.size(); i++) {
                    SubjectEntity tmpBean = lists.get(i);
                    sheet.addCell(new Label(0, i + 1,  tmpBean.getId()+"", format));
                    sheet.addCell(new Label(1, i + 1, (String) tmpBean.getSubCode(), format));
                    sheet.addCell(new Label(2, i + 1, (String) tmpBean.getSubName(), format));/*
                    sheet.addCell(new Label(5, i + 1, (String) tmpBean.getLastUpdateTime(), format));
                    sheet.addCell(new Label(6, i + 1, (String) tmpBean.getOperAcct(), format));
                    sheet.addCell(new Label(7, i + 1, (String) tmpBean.getSerialNo(), format));*/
                }
            }
            wwb.write();
        } catch (Exception e) {
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
