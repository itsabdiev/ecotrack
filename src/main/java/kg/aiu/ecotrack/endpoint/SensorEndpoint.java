package kg.aiu.ecotrack.endpoint;


import kg.aiu.ecotrack.dto.request.SensorRequest;
import kg.aiu.ecotrack.dto.response.MessageResponse;
import kg.aiu.ecotrack.dto.response.SensorResponse;
import kg.aiu.ecotrack.entity.Sensor;
import kg.aiu.ecotrack.exception.NotFoundException;
import kg.aiu.ecotrack.exception.SensorAlreadyExistException;
import kg.aiu.ecotrack.service.SensorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SensorEndpoint {

    SensorService sensorService;

    public MessageResponse save(SensorRequest sensorRequest) {
        if (sensorService.existsByModel(sensorRequest.model())) throw new SensorAlreadyExistException();
        sensorService.save(dtoToEntityMapper(sensorRequest));
        return MessageResponse.builder()
                .message("Sensor has been created")
                .statusCode(201)
                .build();
    }

    public MessageResponse update(Long id, SensorRequest sensorRequest) {
        existsByIdOrThrowException(id);
        Sensor sensor = dtoToEntityMapper(sensorRequest);
        sensor.setId(id);
        sensorService.save(sensor);
        return MessageResponse.builder()
                .message("Sensor has been updated")
                .statusCode(200)
                .build();

    }

    public MessageResponse delete(Long id) {
        existsByIdOrThrowException(id);
        sensorService.deleteById(id);
        return MessageResponse.builder()
                .message("Sensor has been removed")
                .statusCode(200)
                .build();

    }

    public SensorResponse getById(Long id) {
        existsByIdOrThrowException(id);
        return entityToDtoMapper(sensorService.getById(id));
    }

    public void existsByIdOrThrowException(Long id) {
        if (!sensorService.existsById(id)) throw new NotFoundException("Sensor has not been found");
    }

    public List<SensorResponse> getAll() {
        return sensorService.getAll().stream().map(this::entityToDtoMapper).collect(Collectors.toList());
    }

    private Sensor dtoToEntityMapper(SensorRequest sensorRequest) {
        return Sensor.builder()
                .sensorNumber(UUID.randomUUID())
                .model(sensorRequest.model())
                .installationDate(sensorRequest.installationDate())
                .build();
    }


    private SensorResponse entityToDtoMapper(Sensor sensor) {
        return SensorResponse.builder()
                .id(sensor.getId())
                .installationDate(sensor.getInstallationDate())
                .sensorNumber(sensor.getSensorNumber())
                .model(sensor.getModel())
                .build();
    }



}
