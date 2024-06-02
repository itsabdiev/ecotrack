package kg.aiu.ecotrack.dto.request;

import lombok.Builder;
import java.sql.Timestamp;

@Builder
public record DataRequest(
        String PM2_5,
        String PM10,
        String CO2,
        Timestamp registrationTime,
        Long sensorId
) {
}
