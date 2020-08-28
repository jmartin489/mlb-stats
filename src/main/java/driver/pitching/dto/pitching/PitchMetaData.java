package driver.pitching.dto.pitching;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PitchMetaData {
    private Integer pitchTypeCount;
    private Double pitchSpeed;
    private Double pitchXLoc;
    private Double pitchYLoc;
}
