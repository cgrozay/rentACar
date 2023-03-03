package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.rentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

	@Query("From Model where brand.id=:brandId")
	List<Model> finByBrand(int brandId);
}
