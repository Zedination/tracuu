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
        String pathFile = "src/main/resources/data.xlsx";
        InputStream inputStream = new FileInputStream(new File(pathFile));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            ThiSinh thiSinh = new ThiSinh();
            thiSinh.setMaSinhVien(row.getCell(1).toString());
            thiSinh.setSoBaoDanh(row.getCell(2).getStringCellValue());
            thiSinh.setHoTen(row.getCell(3).getStringCellValue());
            thiSinh.setNgaySinh(row.getCell(4).getStringCellValue());
            try {
                thiSinh.setMaDeNghe(row.getCell(5).getStringCellValue());
            }catch (Exception e){
                thiSinh.setMaDeNghe("N/A");
            }
            try {
                thiSinh.setDiemNghe(String.valueOf(row.getCell(6).getNumericCellValue()));
            }catch (Exception e){
                thiSinh.setDiemNghe("N/A");
            }
            try {
                thiSinh.setMaDeDoc(row.getCell(7).getStringCellValue());
            }catch (Exception e){
                thiSinh.setMaDeDoc("N/A");
            }
            try{
                thiSinh.setDiemDoc(String.valueOf(row.getCell(8).getNumericCellValue()));
            }catch (Exception e){
                thiSinh.setDiemDoc("N/A");
            }
            try {
                thiSinh.setTongDiem(String.valueOf(row.getCell(9).getNumericCellValue()));
            }catch (Exception e){
                thiSinh.setTongDiem("N/A");
            }
            try {
                thiSinh.setPhanLoai(String.valueOf(row.getCell(10).getNumericCellValue()));
            }catch (Exception e){
                thiSinh.setPhanLoai("N/A");
            }
            StaticData.dataMaps.put(thiSinh.getMaSinhVien(),thiSinh);
        }
        System.out.println("Khởi tạo dữ liệu thành công!");
    }
}
