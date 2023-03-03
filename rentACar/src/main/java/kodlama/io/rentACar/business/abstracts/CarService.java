package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRepuest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;

public interface CarService {

	List<GetAllCarsResponse> getAllCarsResponses();
	void add(CreateCarRequest createCarRequest);
	void update(UpdateCarRepuest updateCarRepuest);
	void delete(int id);
}
