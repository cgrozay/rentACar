package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import lombok.AllArgsConstructor;

@RequestMapping("/api/cars")
@RestController
@AllArgsConstructor
public class CarsController {

	private CarService carService;
	@GetMapping()
	public List<GetAllCarsResponse> getAllCarsResponses(){
		return this.carService.getAllCarsResponses();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateCarRequest createCarRequest) {
		this.carService.add(createCarRequest);
	}
}
