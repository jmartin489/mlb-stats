package driver.team.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Team {
    private String name;
    private String market;
    private String abbr;
    private String id;
    private List<Position> positions;
}