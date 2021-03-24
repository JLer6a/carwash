package ru.budkin.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.budkin.model.Car;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;


@Component
public class CarRepositoryImpl implements CarRepository {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CarRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<Car> carRowMapper = (row, i) -> Car.builder()
            .id(row.getInt("id"))
            .number(row.getString("number_car"))
            .time(row.getString("time_time"))
            .service(row.getString("service_work"))
            .build();


    //Language = SQL
    public static final String SQL_FIND_BY_ID = "select * from carwash where id = ?";

    //Language = SQL
    public static final String SQL_FIND_ALL = "select * from carwash order by time_time";

    //Language = SQL
    public static final String SQL_ADD_CAR = "insert into carwash (number_car, time_time, service_work) values (?,?,?)";

    //language=SQL
    public static final String SQL_DELETE_BY_ID = "delete from carwash where id = ?";

    @Override
    public void addNewCar(Car entity) {
        jdbcTemplate.update(SQL_ADD_CAR, entity.getNumber(), entity.getTime(),entity.getService());

    }

    @Override
    public Optional<Car> find(Integer id) {
        Car car;
        try {
            car = jdbcTemplate.queryForObject(SQL_FIND_BY_ID, carRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            car = null;
        }
        return Optional.ofNullable(car);
    }


    @Override
    public List<Car> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, carRowMapper);
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, id);

    }
}

