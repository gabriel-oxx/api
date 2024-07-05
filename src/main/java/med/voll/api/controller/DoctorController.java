package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.models.dtos.DoctorDetails;
import med.voll.api.models.dtos.RegisterDoctorInput;
import med.voll.api.models.dtos.RegisterDoctorOutput;
import med.voll.api.models.dtos.UpdateDoctor;
import med.voll.api.models.entities.Doctor;

import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class DoctorController {
	@Autowired
	DoctorRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity register(@Valid @RequestBody RegisterDoctorInput data, UriComponentsBuilder uriBuilder) {
		var doctor = new Doctor(data);
		repository.save(doctor);
		var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
		return ResponseEntity.created(uri).body(new DoctorDetails(doctor));
	}

	@GetMapping
	public ResponseEntity<Page<RegisterDoctorOutput>> list(
			@PageableDefault(size = 3, sort = {"crm"}, direction = Sort.Direction.DESC)
			Pageable pageable
	) {
		var page = repository.findAllByActiveTrue(pageable)
				           .map(RegisterDoctorOutput::new);
		return ResponseEntity.ok(page);
	}

	@PutMapping
	@Transactional
	public ResponseEntity update(@Valid @RequestBody UpdateDoctor data) {
		var doctor = repository.getReferenceById(data.id());
		doctor.updateInfo(data);
		return ResponseEntity.ok(new DoctorDetails(doctor));
	}


	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable Long id) {
		var doctor = repository.getReferenceById(id);
		doctor.delete();
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity getDoctor(@PathVariable Long id) {
		var doctor = repository.getReferenceById(id);
		return ResponseEntity.ok(new DoctorDetails(doctor));
	}
}
