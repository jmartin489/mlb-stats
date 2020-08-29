package driver.pitching.dto.pitching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PitchMetrics {
    private Map<String, PitchMetaData> pitchMetaDataMap;
}
