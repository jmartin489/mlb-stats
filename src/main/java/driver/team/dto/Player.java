package driver.team.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player {
    private String id;
    private String status;
    private String position;
    private String primary_position;
    private String first_name;
    private String last_name;
    private String preferred_name;
    private String jersey_number;
    private Integer depth;
}
