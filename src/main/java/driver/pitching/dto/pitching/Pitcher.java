package driver.pitching.dto.pitching;

import lombok.Builder;
import lombok.Data;

@Data
public class Pitcher {
    private String firstName;
    private String lastName;
    private CareerPitchMetrics careerPitchMetrics;
}
