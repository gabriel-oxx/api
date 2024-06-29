package med.voll.api.models.doctor.dtos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.models.address.AddressInputDto;

public record UpdateDoctor(
		@NotNull
				Long id,
		String name,
		String phone,
		AddressInputDto address
) {
}
