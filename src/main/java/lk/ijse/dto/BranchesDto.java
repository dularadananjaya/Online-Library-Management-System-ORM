package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BranchesDto {
    private String id;
    private String branchName;
    private String staff;
    private String manager;
    private String address;
}
