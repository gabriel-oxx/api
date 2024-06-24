package med.voll.api.models;

public record DataRegistration(
		String name,
		String email,
String crm,
		Specialty specialty,
		AddressData address
) {
}
