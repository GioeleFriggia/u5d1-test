package gioelefriggia.u5d1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gioelefriggia.u5d1.entities.*;

@SpringBootApplication
public class u5d1Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(u5d1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(u5d1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(u5d1Application.class)) {
			Menu menu = context.getBean(Menu.class);

			// Creazione del primo ordine
			Order order1 = new Order(4, 1);
			order1.addItem(menu.getPizzas().get(0)); // Aggiunta di una pizza margherita all'ordine
			order1.addItem(menu.getDrinks().get(0)); // Aggiunta di una limonata all'ordine
			order1.setTableStatus("occupato");

			// Stampa del primo ordine utilizzando il logger
			logger.info("Primo ordine numero: {}", order1.getOrderNumber());
			logger.info("Stato: {}", order1.getStatus());
			logger.info("Numero di coperti: {}", order1.getNumberOfGuests());
			logger.info("Totale: {}", order1.getTotalAmount());
			logger.info("Tavolo numero: {}", order1.getTableNumber());
			logger.info("Stato del tavolo: {}", order1.getTableStatus());
			logger.info("Elementi dell'ordine:");
			for (MenuItem item : order1.getItems()) {
				logger.info("- {}: {}", item.getName(), item.getPrice());
			}

			// Creazione del secondo ordine
			Order order2 = new Order(2, 2);
			order2.addItem(menu.getPizzas().get(1)); // Aggiunta di una pizza hawaiana all'ordine
			order2.addItem(menu.getDrinks().get(2)); // Aggiunta di un bicchiere di vino all'ordine
			order2.setTableStatus("in corso");

			// Stampa del secondo ordine utilizzando il logger
			logger.info("Secondo ordine numero: {}", order2.getOrderNumber());
			logger.info("Stato: {}", order2.getStatus());
			logger.info("Numero di coperti: {}", order2.getNumberOfGuests());
			logger.info("Totale: {}", order2.getTotalAmount());
			logger.info("Tavolo numero: {}", order2.getTableNumber());
			logger.info("Stato del tavolo: {}", order2.getTableStatus());
			logger.info("Elementi dell'ordine:");
			for (MenuItem item : order2.getItems()) {
				logger.info("- {}: {}", item.getName(), item.getPrice());
			}
		}
	}
}
