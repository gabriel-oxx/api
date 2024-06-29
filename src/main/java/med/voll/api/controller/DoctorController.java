package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.models.doctor.dtos.RegisterDoctorInput;
import med.voll.api.models.doctor.dtos.RegisterDoctorOutput;
import med.voll.api.models.doctor.dtos.UpdateDoctor;
import med.voll.api.models.doctor.entities.Doctor;

import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class DoctorController {
	@Autowired
	DoctorRepository repository;

	@PostMapping
	@Transactional
	public void register(@Valid @RequestBody RegisterDoctorInput data) {
		repository.save(new Doctor(data));
	}

	@GetMapping
	public Page<RegisterDoctorOutput> list(
			@PageableDefault(size = 3, sort = {"crm"}, direction = Sort.Direction.DESC)
			Pageable pageable
	) {
		return repository.findAllByActiveTrue(pageable)
				.map(RegisterDoctorOutput::new);
	}

	@PutMapping
	@Transactional
	public void update(@Valid @RequestBody UpdateDoctor data) {
		var doctor = repository.getReferenceById(data.id());
		doctor.updateInfo(data);
	}


	@DeleteMapping("/{id}")
	@Transactional
	public void delete(@PathVariable Long id) {
		var doctor = repository.getReferenceById(id);
		doctor.delete();
	}


}
