package kg.aiu.ecotrack.dto.response;

import lombok.Builder;

import java.util.Date;
import java.util.UUID;

@Builder
public record SensorResponse (
        Long id,
        UUID sensorNumber,
        String model,
        Date installationDate
) {
}
