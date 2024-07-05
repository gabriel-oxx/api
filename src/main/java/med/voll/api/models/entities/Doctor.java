package med.voll.api.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.models.address.Address;
import med.voll.api.models.dtos.RegisterDoctorInput;
import med.voll.api.models.dtos.Specialties;
import med.voll.api.models.dtos.UpdateDoctor;

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
	private Specialties specialties;
	@Embedded
	private Address address;
	private boolean active;

	public Doctor(RegisterDoctorInput data) {
		this.active = true;
		this.name = data.name();
		this.email = data.email();
		this.phone = data.phone();
		this.crm = data.crm();
		this.specialties = data.specialties();
		this.address = new Address(data.address());
	}

	public void updateInfo(UpdateDoctor data) {

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
