package ru.phatshop.model.dao.brand;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.phatshop.model.entities.Brand;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BrandService implements IDaoBrand {

    private final BrandRepository repository;

    @Override
    public List<Brand> findAll() {
        return (List<Brand>) repository.findAll();
    }

    @Override
    public Optional<Brand> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Brand save(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public Brand update(Brand brand) {
        return null;
    }

    @Override
    public Brand delete(Integer id) {
        return null;
    }
}
