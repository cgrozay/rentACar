package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllModelsResponse> getAllModelsResponses() {
		List<Model> models = modelRepository.findAll();
		List<GetAllModelsResponse> modelsResponses = models.stream()
				.map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());
		return modelsResponses;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		model.setId(0);
		this.modelRepository.save(model);
	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);

	}

	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);

	}

	//ModelRepository de findByBrand methodu yazılıp Query anotasyonu ile sorgu oluşturulmuştur.
	//Manager da findByBrand methodu çağırılıp mapleme yapılarak listelenmesi sağlanmıştır.
	@Override
	public List<GetAllModelsResponse> findByBrand(int brandId) {
		List<Model> models = modelRepository.finByBrand(brandId);
		List<GetAllModelsResponse> getAllModelsResponses = models.stream()
				.map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());
		return getAllModelsResponses;
	}

}
