package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.CarSupplier;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

	@Autowired
	public CarSupplier carSupplier;

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

		if (count == null || count < 0 || count > carSupplier.carsStorage.size()) {
			model.addAttribute("cars", carSupplier.carsStorage);
		} else {
			model.addAttribute("cars", carSupplier.carsStorage.subList(0, count));
		}

		model.addAttribute("cars_supplier_address", carSupplier.hashCode());
		model.addAttribute("cars_requested", count);
		model.addAttribute("cars_available", carSupplier.carsStorage.size());

		return "cars";
	}
}


