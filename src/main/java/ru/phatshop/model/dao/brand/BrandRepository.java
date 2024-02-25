package ru.phatshop.model.dao.brand;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.phatshop.model.entities.Brand;
@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
}
