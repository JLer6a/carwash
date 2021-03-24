package ru.budkin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ru.budkin.model.Car;
import ru.budkin.repositories.CarRepositoryImpl;
import java.util.List;
import java.util.Optional;


@Controller
public class CarController {

    @Autowired
    private CarRepositoryImpl carRepository;



    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public ModelAndView getCarsPage(){
        List<Car> cars = carRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("carlist");
        modelAndView.addObject("cars", cars);
        return modelAndView;
    }

    @RequestMapping (value = "/car", method = RequestMethod.POST)
    public ModelAndView addCar(Car car){
        carRepository.addNewCar(car);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/car");
        return modelAndView;
    }


    @GetMapping("car/{id}")
    public String show (@PathVariable ("id") Integer id, Model model){
        Optional<Car> car = carRepository.find(id);
        model.addAttribute("car", car.get());
        return "show";
    }

    @PostMapping("car/{id}")
    public String delete (@PathVariable ("id") Integer id){
        carRepository.deleteById(id);
        return "redirect:/car";
    }

}
