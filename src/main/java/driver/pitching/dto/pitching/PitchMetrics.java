package driver.pitching.dto.pitching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PitchMetrics {
    private List<PitchType> pitchType;
}
