package kg.aiu.ecotrack.endpoint;

import kg.aiu.ecotrack.dto.request.DataRequest;
import kg.aiu.ecotrack.dto.response.DataResponse;
import kg.aiu.ecotrack.dto.response.MessageResponse;
import kg.aiu.ecotrack.entity.Data;
import kg.aiu.ecotrack.exception.DataForSensorAlreadyExistsException;
import kg.aiu.ecotrack.exception.NotFoundException;
import kg.aiu.ecotrack.service.DataService;
import kg.aiu.ecotrack.service.SensorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DataEndpoint {

    DataService dataService;
    SensorService sensorService;
    SensorEndpoint sensorEndpoint;


    public List<DataResponse> getAll() {
        return dataService.getAll().stream().map(this::entityToDtoMapper).collect(Collectors.toList());
    }


    private Data dtoToEntityMapper(DataRequest request) {
        return Data.builder()
                .sensor(sensorService.getById(request.sensorId()))
                .PM2_5(request.PM2_5())
                .PM10(request.PM10())
                .registrationTime(request.registrationTime())
                .CO2(request.CO2())
                .build();
    }

    private DataResponse entityToDtoMapper(Data data) {
        return DataResponse.builder()
                .registrationTime(data.getRegistrationTime())
                .PM2_5(data.getPM2_5())
                .sensorId(data.getSensor().getId())
                .PM10(data.getPM10())
                .CO2(data.getCO2())
                .build();
    }

    public DataResponse getById(Long id) {
        existsByIdOrThrowException(id);
        return entityToDtoMapper(dataService.getById(id));
    }

    public MessageResponse save(DataRequest dataRequest) {
        sensorEndpoint.existsByIdOrThrowException(dataRequest.sensorId());
        Optional<Data> optionalData = dataService.existsBySensorId(dataRequest.sensorId());
        if (optionalData.isPresent()) throw new DataForSensorAlreadyExistsException();
        dataService.save(dtoToEntityMapper(dataRequest));
        return MessageResponse.builder()
                .message("Data has been created")
                .statusCode(201)
                .build();
    }

    public MessageResponse update(Long id, DataRequest dataRequest) {
        existsByIdOrThrowException(id);
        sensorEndpoint.existsByIdOrThrowException(dataRequest.sensorId());
        Data data = dtoToEntityMapper(dataRequest);
        data.setId(id);
        dataService.save(data);
        return MessageResponse.builder()
                .message("Data has been updated")
                .statusCode(200)
                .build();
    }

    private void existsByIdOrThrowException(Long id) {
        if (!dataService.existsById(id)) throw new NotFoundException("Data has not been found");
    }

    public MessageResponse delete(Long id) {
        existsByIdOrThrowException(id);
        dataService.deleteById(id);
        return MessageResponse.builder()
                .message("Data has been removed")
                .statusCode(200)
                .build();
    }
}
