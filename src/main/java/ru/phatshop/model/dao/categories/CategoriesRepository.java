package ru.phatshop.model.dao.categories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.phatshop.model.entities.Categories;
@Repository
public interface CategoriesRepository extends CrudRepository<Categories, Integer> {
}
