package ru.budkin.repositories;

import ru.budkin.model.Car;

public interface CarRepository extends CrudRepository<Car>{

void deleteById(Integer id);

}
