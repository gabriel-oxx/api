package med.voll.api.models.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressInputDto(
		@NotBlank
		String street,
		@NotBlank
		String neighborhood,
		@NotBlank
		@Pattern(regexp =  "\\d{8}")
		String cep,
		@NotBlank
		String city,
		@NotBlank
		String state,
		String complement,
		String number
) {
}
