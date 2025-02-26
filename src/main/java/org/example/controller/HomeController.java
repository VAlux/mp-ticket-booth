package org.example.controller;

import org.example.model.Event;
import org.example.model.Ticket;
import org.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Controller for the home page.
 * @author Andrii Krokhta
 */
@Controller
public class HomeController {

	/**
	 * Sends the user to the home page.
	 *
	 * @return Name of the home view.
	 */
	@GetMapping("/home")
	public String home(){
		return "home";
	}

	/**
	 * Creates a default user instance.
	 *
	 * @return Default user instance.
	 */
	@ModelAttribute("user")
	public User getEmptyUser() {
		return new User(0L, null, null);
	}

	/**
	 * Creates a default event instance.
	 *
	 * @return Default event instance.
	 */
	@ModelAttribute("event")
	public Event getEmptyEvent() {
		return new Event(0L, null, null);
	}

	/**
	 * Creates a default ticket instance.
	 *
	 * @return Default ticket instance.
	 */
	@ModelAttribute("ticket")
	public Ticket getEmptyTicket() {
		return new Ticket(0L, 0L, 0L, null, 0);
	}
}
