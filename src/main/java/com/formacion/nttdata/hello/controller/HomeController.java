package com.formacion.nttdata.hello.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formacion.nttdata.hello.model.User;
import com.formacion.nttdata.hello.servicio.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService servicio;

	@RequestMapping(value = "/", method = RequestMethod.GET)

	public String home(Locale locale, Model model) {

		System.out.println("Home Page Requested, locale = " + locale);

		String formattedDate = servicio.normalFecha(locale);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)

	public String user(@Validated User user, Model model, Locale locale) throws Exception {

		System.out.println("User Page Requested");

		model.addAttribute("userName", user.getUserName());

		model.addAttribute("newDate", servicio.calculoFecha(locale, user.getAddDate()));

		return "user";
	}

}
