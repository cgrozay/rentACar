package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRepuest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarReepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

	private CarReepository carReepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllCarsResponse> getAllCarsResponses() {
		List<Car> cars = carReepository.findAll();
		List<GetAllCarsResponse> getAllCarsResponses = cars.stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
				.collect(Collectors.toList());
		return getAllCarsResponses;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		Car car=this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		car.setId(0);
		this.carReepository.save(car);

	}

	@Override
	public void update(UpdateCarRepuest updateCarRepuest) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
