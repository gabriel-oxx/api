package med.voll.api.models.doctor;

public record DoctorData(
		String name,
		String email,
		String crm,
		Specialty specialty
) {

	public DoctorData(Doctor doctor) {
		this(
				doctor.getName(),
				doctor.getEmail(),
				doctor.getCrm(),
				doctor.getSpecialty()
		);
	}


}
