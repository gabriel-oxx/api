package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.models.doctor.DataRegistration;
import med.voll.api.models.doctor.Doctor;
import med.voll.api.models.doctor.DoctorData;
import med.voll.api.models.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@GetMapping
	public List<DoctorData> list() {
		return repository.findAll()
				.stream()
				.map(DoctorData::new)
				.toList();
	}


}
