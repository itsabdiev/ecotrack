package kg.aiu.ecotrack.web;


import kg.aiu.ecotrack.dto.request.SensorRequest;
import kg.aiu.ecotrack.dto.response.MessageResponse;
import kg.aiu.ecotrack.dto.response.SensorResponse;
import kg.aiu.ecotrack.endpoint.SensorEndpoint;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SensorController {

    SensorEndpoint sensorEndpoint;

    @GetMapping
    public List<SensorResponse> getAll() {
        return sensorEndpoint.getAll();
    }

    @GetMapping("/{id}")
    public SensorResponse getById(@PathVariable Long id) {
        return sensorEndpoint.getById(id);
    }

    @PostMapping
    public MessageResponse save(@RequestBody SensorRequest sensorRequest) {
        return sensorEndpoint.save(sensorRequest);
    }

    @PutMapping("/{id}")
    public MessageResponse update(@RequestBody SensorRequest sensorRequest, @PathVariable Long id) {
        return sensorEndpoint.update(id,sensorRequest);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return sensorEndpoint.delete(id);
    }

}
