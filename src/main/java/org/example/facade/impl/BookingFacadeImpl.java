package org.example.facade.impl;

import org.example.facade.BookingFacade;
import org.example.model.Event;
import org.example.model.Ticket;
import org.example.model.User;
import org.example.preloader.DataPreloader;
import org.example.service.EventService;
import org.example.service.TicketService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@Component
public class BookingFacadeImpl implements BookingFacade {


	private final EventService eventService;

	private final TicketService ticketService;

	private final UserService userService;

	private final List<DataPreloader<?>> dataPreloaders;

	@Autowired
	public BookingFacadeImpl(EventService eventService, TicketService ticketService, UserService userService, List<DataPreloader<?>> dataPreloaders) {
		this.eventService = eventService;
		this.ticketService = ticketService;
		this.userService = userService;
		this.dataPreloaders = dataPreloaders;
	}

	/**
	 * Preloads data from xml files.
	 */
	@PostConstruct
	private void preloadData() {
		dataPreloaders.forEach(DataPreloader::preloadData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Event getEventById(long eventId) {
		return eventService.getEventById(eventId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
		return eventService.getEventsByTitle(title, pageSize, pageNum);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Event> getEventsForDay(LocalDate day, int pageSize, int pageNum) {
		return eventService.getEventsForDay(day, pageSize, pageNum);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Event createEvent(Event event) {
		return eventService.createEvent(event);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Event updateEvent(Event event) {
		return eventService.updateEvent(event);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteEvent(long eventId) {
		return eventService.deleteEvent(eventId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserById(long userId) {
		return userService.getUserById(userId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserByEmail(String email) {
		return userService.getUserByEmail(email);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getUsersByName(String name, int pageSize, int pageNum) {
		return userService.getUsersByName(name, pageSize, pageNum);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User createUser(User user) {
		return userService.createUser(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User updateUser(User user) {
		return userService.updateUser(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteUser(long userId) {
		return userService.deleteUser(userId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Ticket bookTicket(long userId, long eventId, Ticket.Category category, int place) {
		return ticketService.bookTicket(userId, eventId, category, place);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
		return ticketService.getBookedTickets(user, pageSize, pageNum);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
		return ticketService.getBookedTickets(event, pageSize, pageNum);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean cancelTicket(long ticketId) {
		return ticketService.cancelTicket(ticketId);
	}
}
