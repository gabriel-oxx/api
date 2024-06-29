package med.voll.api.models.doctor.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.models.address.AddressInputDto;

public record RegisterDoctorInput(
		@NotBlank
		String name,
		@NotBlank
				@Email
		String email,
@NotBlank
String phone,
@NotBlank
		@Pattern(regexp = "\\d{4,6}")
String crm,
		@NotNull
		Specialties specialties,
		@NotNull
				@Valid
		AddressInputDto address
) {
}
