package kg.aiu.ecotrack.dto.request;

import lombok.Builder;

import java.util.Date;

@Builder
public record SensorRequest (
        String model,
        Date installationDate
) {
}
