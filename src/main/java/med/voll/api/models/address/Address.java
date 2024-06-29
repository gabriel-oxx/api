package med.voll.api.models.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private String street;
	private String neighborhood;
	private String cep;
	private String city;
	private String state;
	private String number;
	private String complement;

	public Address(AddressInputDto address) {
		this.street = address.street();
		this.neighborhood = address.neighborhood();
		this.cep = address.cep();
		this.city = address.city();
		this.state = address.state();
		this.number = address.number();
		this.complement = address.complement();
	}


	public void updateInfo(AddressInputDto data) {
		if (data.street() != null)
			this.street = data.street();

		if (data.neighborhood() != null)
			this.neighborhood = data.neighborhood();

		if (data.cep() != null)
			this.cep = data.cep();

		if (data.city() != null)
			this.city = data.city();

		if (data.state() != null)
			this.state = data.state();

		if (data.number() != null)
			this.number = data.number();

		if (data.complement() != null)
			this.complement = data.complement();

	}


}
