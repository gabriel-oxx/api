package med.voll.api.models.doctor.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.models.address.AddressInputDto;

public record RegisterDoctorInput(
		@NotBlank(message = "Nome é obrigatório")
		String name,
		@NotBlank(message = "Email é obrigatório")
				@Email(message = "O email deve possuir '@' para separar o nome de usuário do domínio")
		String email,
@NotBlank(message = "O número de telefone é obrigatório")
String phone,
@NotBlank(message = "O número do CRM é obrigatório")
		@Pattern(regexp = "\\d{4,6}", message = "O formato do CRM está incorreto")
String crm,
		@NotNull(message = "É obrigatório informar uma especialidade")
		Specialties specialties,
		@NotNull(message = "É obrigatório informar um endereço")
				@Valid
		AddressInputDto address
) {
}
