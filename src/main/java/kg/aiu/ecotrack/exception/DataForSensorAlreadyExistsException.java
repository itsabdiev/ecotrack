package kg.aiu.ecotrack.exception;

public class DataForSensorAlreadyExistsException extends RuntimeException {

    public DataForSensorAlreadyExistsException() {
        super("Data for sensor already exists");
    }
}
