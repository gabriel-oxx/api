package med.voll.api.models.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.models.address.Address;
import med.voll.api.models.address.AddressData;

public record UpdateDoctorData(
		@NotNull
				Long id,
		String name,
		String phone,
		AddressData address
) {
}
