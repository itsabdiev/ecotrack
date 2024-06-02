package kg.aiu.ecotrack.exception;


public class SensorAlreadyExistException extends RuntimeException {

    public SensorAlreadyExistException() {
        super("Sensor already exists");
    }
}