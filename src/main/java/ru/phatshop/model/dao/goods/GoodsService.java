package ru.phatshop.model.dao.goods;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.phatshop.model.entities.Goods;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class GoodsService implements IDaoGoods{

    private final GoodsRepository repository;

    @Override
    public List<Goods> findAll() {
        return (List<Goods>) repository.findAll();
    }

    @Override
    public Optional<Goods> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Goods save(Goods goods) {
        return repository.save(goods);
    }

    @Override
    public Goods update(Goods goods) {
        return null;
    }

    @Override
    public Goods delete(Integer id) {
        return null;
    }
}
