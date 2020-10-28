package vn.edu.utc.tracuu.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.utc.tracuu.cachevariable.StaticData;
import vn.edu.utc.tracuu.dataclass.ThiSinh;

import java.util.Map;

@RestController
public class RestBase {

    
    @PostMapping("/find")
    public ThiSinh findData(@RequestParam("q") String q){
        ThiSinh thiSinh = (ThiSinh) StaticData.dataMaps.get(q);
        return thiSinh;
    }
}
