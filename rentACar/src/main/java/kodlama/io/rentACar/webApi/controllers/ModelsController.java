package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;

@RequestMapping("api/models")
@RestController
@AllArgsConstructor
public class ModelsController {

	private ModelService modelService;

	@GetMapping()
	public List<GetAllModelsResponse> getAll() {
		return modelService.getAllModelsResponses();
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}

	@PutMapping("/{id}")
	public void update(UpdateModelRequest updateModelRequest) {
		this.modelService.update(updateModelRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(int id) {
		this.modelService.delete(id);
	}
	@GetMapping("/{brandId}")
	public List<GetAllModelsResponse> findByBrandId(int brandId) {
		return this.modelService.findByBrand(brandId);
	}
}
