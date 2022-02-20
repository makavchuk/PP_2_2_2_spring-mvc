package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

	public List<Car> getCarList() {
		List<Car> result = Arrays.asList(new Car("Mercedes", "CLG", 2020),
				new Car("BMW", "7", 2010),
				new Car("Ford", "Escort", 2000),
				new Car("Toyota", "Corolla", 2002),
				new Car("Fiat", "Cordoba", 1995)
		);
		return result;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String printCars(ModelMap model, @RequestParam(value = "count", required = false) Integer count) {
		List<Car> carsList = getCarList();
		int carsCountToReturn = BoundriesCheck(count, carsList.size());

		model.addAttribute("cars", carsList.subList(0, carsCountToReturn));
		model.addAttribute("cars_requested", count);
		model.addAttribute("cars_available", carsList.size());

		return "cars";
	}

	int BoundriesCheck(Integer value, int maxValue) {
		// есть подозрение, что для запихивания значения в некоторые границы уже есть такая функция
		if (value == null) {
			return maxValue;
		} else {
			if (value < 0) {
				return 0;
			} else {
				if (value >= maxValue) {
					return maxValue;
				} else {
					return value;
				}
			}
		}
	}

}