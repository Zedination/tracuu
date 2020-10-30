package vn.edu.utc.tracuu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.utc.tracuu.cachevariable.StaticData;
import vn.edu.utc.tracuu.dataclass.Datatable;
import vn.edu.utc.tracuu.dataclass.FileExcel;
import vn.edu.utc.tracuu.service.AdminService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class AdminRest {

    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/data")
    public Datatable listStudent(){
        return this.adminService.getListStudent();
    }

    @PostMapping(path = {"/admin/update"}, consumes = "multipart/form-data")
    public String updateData(FileExcel fileExcel) throws IOException {
//        InputStream inputStream = new ByteArrayInputStream(fileExcel.getFile().getBytes());
        adminService.saveFile(fileExcel.getFile());
        StaticData.dataMaps.clear();
        this.adminService.refreshDataMap();
        return "success";
    }
}
