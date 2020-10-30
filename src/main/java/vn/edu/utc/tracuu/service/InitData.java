package vn.edu.utc.tracuu.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import vn.edu.utc.tracuu.cachevariable.StaticData;
import vn.edu.utc.tracuu.dataclass.ThiSinh;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class InitData {

    @PostConstruct
    public void initData() throws IOException {
        String pathFile = "src/main/resources/files/data.xlsx";
        InputStream inputStream = new FileInputStream(new File(pathFile));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            ThiSinh thiSinh = new ThiSinh();
            thiSinh.setMaSinhVien(row.getCell(1).toString());
            thiSinh.setToeic(row.getCell(9).toString());
            thiSinh.setHoTen(row.getCell(2).getStringCellValue());
            thiSinh.setNgaySinh(row.getCell(3).getStringCellValue());
            try {
                thiSinh.setMaDeNghe(row.getCell(4).getStringCellValue());
            }catch (Exception e){
                thiSinh.setMaDeNghe("N/A");
            }
            try {
                thiSinh.setDiemNghe(row.getCell(5).toString());
            }catch (Exception e){
                thiSinh.setDiemNghe("N/A");
            }
            try {
                thiSinh.setMaDeDoc(row.getCell(6).toString());
            }catch (Exception e){
                thiSinh.setMaDeDoc("N/A");
            }
            try{
                thiSinh.setDiemDoc(row.getCell(7).toString());
            }catch (Exception e){
                thiSinh.setDiemDoc("N/A");
            }
            try {
                thiSinh.setTongDiem(row.getCell(8).toString());
            }catch (Exception e){
                thiSinh.setTongDiem("N/A");
            }
            try {
                thiSinh.setPhanLoai(row.getCell(10).toString());
            }catch (Exception e){
                thiSinh.setPhanLoai("N/A");
            }
            StaticData.dataMaps.put(thiSinh.getMaSinhVien(),thiSinh);
        }
        System.out.println("Khởi tạo dữ liệu thành công!");
    }
}
