package med.voll.api.models.dtos;

import med.voll.api.models.address.Address;
import med.voll.api.models.entities.Doctor;

public record DoctorDetails(
		Long id,
		String name,
		String email,
		String phone,
		String crm,
		Specialties specialties,
		Address address
) {
	public DoctorDetails(Doctor doctor) {
		this(
				doctor.getId(),
				doctor.getName(),
				doctor.getEmail(),
				doctor.getPhone(),
				doctor.getCrm(),
				doctor.getSpecialties(),
				doctor.getAddress()
		);
	}
}
