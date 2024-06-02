package kg.aiu.ecotrack.service.implementation;

import kg.aiu.ecotrack.repository.SensorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


class EquipmentServiceImplementationTest {

    @Mock
    SensorRepository sensorRepository;

    @InjectMocks
    SensorServiceImplementation sensorServiceImplementation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void existsByModel() {
        Mockito.when(sensorRepository.existsByModel(Mockito.anyString())).thenReturn(true);
        boolean b = sensorServiceImplementation.existsByModel("Model 1");
        assertTrue(b);
        verify(sensorRepository,times(1)).existsByModel(anyString());
    }

    @Test
    void save() {
    }

    @Test
    void existsById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void getById() {
    }

    @Test
    void getAll() {
    }
}