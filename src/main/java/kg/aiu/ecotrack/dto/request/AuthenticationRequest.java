package kg.aiu.ecotrack.dto.request;

public record AuthenticationRequest(
        String username,
        String password
) {
}
