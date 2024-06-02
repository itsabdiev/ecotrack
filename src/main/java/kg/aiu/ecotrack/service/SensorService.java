package kg.aiu.ecotrack.service;

import kg.aiu.ecotrack.entity.Sensor;

import java.util.List;

public interface SensorService {

    boolean existsByModel(String model);

    void save(Sensor sensor);

    boolean existsById(Long id);

    void deleteById(Long id);

    Sensor getById(Long id);

    List<Sensor> getAll();
}
