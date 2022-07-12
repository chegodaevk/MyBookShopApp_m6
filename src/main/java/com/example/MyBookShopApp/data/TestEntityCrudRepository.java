package com.example.MyBookShopApp.data;

import org.springframework.data.repository.CrudRepository;

// расширяем интерфейс CrudRepository которому в качестве рабочего типа передаём TestEntity и тип его id (Long)
public interface TestEntityCrudRepository extends CrudRepository<TestEntity,Long>{
}
