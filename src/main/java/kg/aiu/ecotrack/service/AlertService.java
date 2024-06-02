package kg.aiu.ecotrack.service;

import kg.aiu.ecotrack.entity.Alert;

import java.util.List;

public interface AlertService {
    List<Alert> getAll();

    Alert getById(Long id);

    void save(Alert alert);

    boolean existsById(Long id);

    void deleteById(Long id);
}
