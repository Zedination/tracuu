package vn.edu.utc.tracuu.dataclass;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Datatable {
    private List<List<String>> data;
}
