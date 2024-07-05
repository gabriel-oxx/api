package med.voll.api.models.dtos;

import med.voll.api.models.entities.Doctor;

public record RegisterDoctorOutput(
		Long id,
		String name,
		String email,
		String crm,
		Specialties specialties
) {

	public RegisterDoctorOutput(Doctor doctor) {
		this(
				doctor.getId(),
				doctor.getName(),
				doctor.getEmail(),
				doctor.getCrm(),
				doctor.getSpecialties()
		);	
	}


}
