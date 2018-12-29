package com.example.demo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@RestController
public class HelloController {


    @ApiOperation(value = "测试用例", notes = "")
    @ApiImplicitParams({
    })
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello( String user ) {
        return user;
    }

    @RequestMapping(value = "excelDownload", method = RequestMethod.POST)
    public Response excelDownload() throws IOException {


        String[][] array = new String[2][2];
        String[] headArray = new String[]{"姓名", "身份证号"};

        String[] dataArray = new String[]{"刘坦", "11111"};
        array[0] = headArray;
        array[1] = dataArray;
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet1 = workbook.createSheet("测试下载");
        for (int i = 0; i < array.length; i++) {
            Row row = sheet1.createRow((short) i);
            for (int j = 0; j < array[i].length; j++) {
                row.createCell(j).setCellValue(array[i][j]);
            }

        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        baos.flush();
        Response.ResponseBuilder builder = Response.ok();
        builder.header("Content-Disposition", "attachment; filename=FileName.xls");
        builder.entity(baos.toByteArray());
        return builder.build();
    }


    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[][] array = new String[2][2];
        String[] headArray = new String[]{"姓名", "身份证号"};

        String[] dataArray = new String[]{"刘坦", "11111"};
        array[0] = headArray;
        array[1] = dataArray;
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet1 = workbook.createSheet("测试下载");
        for (int i = 0; i < array.length; i++) {
            Row row = sheet1.createRow((short) i);
            for (int j = 0; j < array[i].length; j++) {
                row.createCell(j).setCellValue(array[i][j]);
            }

        }
        try {
            this.setResponseHeader(response, "test.xls");
            OutputStream os = response.getOutputStream();
            workbook.write(os);
            os.flush();
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
