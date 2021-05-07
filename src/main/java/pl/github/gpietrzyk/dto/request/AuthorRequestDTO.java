package pl.github.gpietrzyk.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class AuthorRequestDTO {
    private final String firstName;
    private final String middleName;
    private final String lastName;

    @JsonCreator
    public AuthorRequestDTO(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}
