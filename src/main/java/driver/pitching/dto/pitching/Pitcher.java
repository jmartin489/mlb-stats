package driver.pitching.dto.pitching;

import lombok.Data;

@Data
public class Pitcher {
    private String first_name;
    private String last_name;
    private CareerPitchMetrics careerPitchMetrics;
}