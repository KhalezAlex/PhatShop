package ru.phatshop.model.dao.goods;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.phatshop.model.entities.Goods;
@Repository
public interface GoodsRepository extends CrudRepository<Goods, Integer> {
}
