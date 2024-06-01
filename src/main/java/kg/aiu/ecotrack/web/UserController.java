package kg.aiu.ecotrack.web;


import kg.aiu.ecotrack.dto.request.UserUpdateRequest;
import kg.aiu.ecotrack.dto.response.MessageResponse;
import kg.aiu.ecotrack.endpoint.UserEndpoint;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {

    UserEndpoint userEndpoint;

    @PutMapping("/update")
    public MessageResponse update(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody UserUpdateRequest userUpdateRequest) {
        return userEndpoint.update(userUpdateRequest,userDetails.getUsername());
    }

    @DeleteMapping("/delete")
    public MessageResponse delete(@AuthenticationPrincipal UserDetails userDetails) {
        return userEndpoint.delete(userDetails.getUsername());
    }
}
