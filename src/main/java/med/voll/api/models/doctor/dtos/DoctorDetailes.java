package med.voll.api.models.doctor.dtos;

import med.voll.api.models.address.Address;
import med.voll.api.models.doctor.entities.Doctor;

public record DoctorDetailes(
		Long id,
		String name,
		String email,
		String phone,
		String crm,
		Specialties specialties,
		Address address
) {
	public DoctorDetailes(Doctor doctor) {
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
