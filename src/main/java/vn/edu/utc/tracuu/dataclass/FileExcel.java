package vn.edu.utc.tracuu.dataclass;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FileExcel {
    private MultipartFile file;
}
