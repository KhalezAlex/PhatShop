package ru.phatshop.model.dao.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.phatshop.model.entities.Categories;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CategoriesService implements IDaoCategories{

    private final CategoriesRepository repository;

    @Override
    public List<Categories> findAll() {
        return (List<Categories>) repository.findAll();
    }

    @Override
    public Optional<Categories> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Categories save(Categories categories) {
        return repository.save(categories);
    }

    @Override
    public Categories update(Categories categories) {
        return null;
    }

    @Override
    public Categories delete(Integer id) {
        return null;
    }
}
