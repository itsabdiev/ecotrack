package kg.aiu.ecotrack.dto.request;

import lombok.Builder;

@Builder
public record SignUpRequest(
        String email,
        String password,
        String phoneNumber,
        String firstName,
        String lastName
) {
}
