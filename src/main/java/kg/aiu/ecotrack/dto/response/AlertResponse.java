package kg.aiu.ecotrack.dto.response;

import lombok.Builder;

import java.sql.Timestamp;

@Builder
public record AlertResponse(
        String warningMessage,
        Timestamp registrationTime,
        Long sensorId
) {
}
