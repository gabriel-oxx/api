package med.voll.api.models;

public record AddressData(
		String street,
		String neighborhood,
		String cep,
		String city,
		String state,
		String complement,
		String number
) {
}
