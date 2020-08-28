package driver.pitching.dto.pitching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PitchType {
    Map<String, PitchMetaData> pitchMetaDataMap;
}
