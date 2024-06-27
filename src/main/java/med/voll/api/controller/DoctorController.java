package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.models.DataRegistration;
import med.voll.api.models.Doctor;
import med.voll.api.models.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class DoctorController {
	@Autowired
	DoctorRepository repository;

	@PostMapping
	@Transactional
	public void register(@Valid @RequestBody DataRegistration data) {
		repository.save(new Doctor(data));
	}


}
