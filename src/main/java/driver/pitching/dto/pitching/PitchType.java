package driver.pitching.dto.pitching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PitchType {
    private String pitchType;
    private Integer pitchTypeCount;
    private Double pitchSpeed;
    private Double pitchXLoc;
    private Double pitchYLoc;
}
