package vn.edu.utc.tracuu.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.edu.utc.tracuu.cachevariable.StaticData;
import vn.edu.utc.tracuu.dataclass.Datatable;
import vn.edu.utc.tracuu.dataclass.ThiSinh;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    private InitData initData;
    @Autowired
    public void setInitData(InitData initData) {
        this.initData = initData;
    }

    public Datatable getListStudent(){
        List<List<String>> data = new ArrayList<List<String>>();
        StaticData.dataMaps.forEach((k,v)->{
            ThiSinh thiSinh = (ThiSinh) v;
            List<String> temp = new ArrayList<>();
            temp.add(thiSinh.getMaSinhVien());
            temp.add(thiSinh.getHoTen());
            temp.add(thiSinh.getNgaySinh());
            temp.add(thiSinh.getMaDeNghe());
            temp.add(thiSinh.getDiemNghe());
            temp.add(thiSinh.getMaDeNghe());
            temp.add(thiSinh.getDiemDoc());
            temp.add(thiSinh.getTongDiem());
            temp.add(thiSinh.getToeic());
            temp.add(thiSinh.getPhanLoai());
            data.add(temp);
        });
        return new Datatable(data);
    }
    public void saveFile(MultipartFile file) throws IOException {
        String uploadFilePath =   "src/main/resources/files/data.xlsx";
        Path path = Paths.get(uploadFilePath);
        Files.write(path, file.getBytes());
    }
    public void refreshDataMap() throws IOException{
        this.initData.initData();
    }
}
