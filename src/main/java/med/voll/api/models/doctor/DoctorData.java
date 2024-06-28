package med.voll.api.models.doctor;

public record DoctorData(
		Long id,
		String name,
		String email,
		String crm,
		Specialty specialty
) {

	public DoctorData(Doctor doctor) {
		this(
				doctor.getId(),
				doctor.getName(),
				doctor.getEmail(),
				doctor.getCrm(),
				doctor.getSpecialty()
		);
	}


}
