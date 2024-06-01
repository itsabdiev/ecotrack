package kg.aiu.ecotrack.dto.request;


import lombok.Builder;

@Builder
public record UserUpdateRequest(
        String phoneNumber,
        String firstName,
        String lastName
) {
}
