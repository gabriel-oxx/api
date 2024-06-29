package med.voll.api.models.doctor;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.models.address.Address;
import med.voll.api.models.address.AddressData;

@Entity
@Table(name = "doctors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String crm;
	@Enumerated(EnumType.STRING)
	private Specialty specialty;
	@Embedded
	private Address address;
	private boolean active;

	public Doctor(DataRegistration data) {
		this.active = true;
		this.name = data.name();
		this.email = data.email();
		this.phone = data.phone();
		this.crm = data.crm();
		this.specialty = data.specialty();
		this.address = new Address(data.address());
	}

	public void updateInfo(UpdateDoctorData data) {

		if (data.name() != null)
			this.name = data.name();

		if (data.phone() != null)
			this.phone = data.phone();

		if (data.address() != null) {
			this.address.updateInfo(data.address());
		}


	}


	public void delete() {
		this.active = false;
	}


}
