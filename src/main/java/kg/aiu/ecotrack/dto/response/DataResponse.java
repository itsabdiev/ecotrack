package kg.aiu.ecotrack.dto.response;

import lombok.Builder;
import java.sql.Timestamp;

@Builder
public record DataResponse(
        String PM2_5,
        String PM10,
        String CO2,
        Timestamp registrationTime,
        Long sensorId
) {
}
