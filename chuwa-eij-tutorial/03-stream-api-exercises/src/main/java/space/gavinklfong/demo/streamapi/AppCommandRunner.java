package space.gavinklfong.demo.streamapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import space.gavinklfong.demo.streamapi.models.Customer;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.CustomerRepo;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class AppCommandRunner implements CommandLineRunner {

	@Autowired
	private CustomerRepo customerRepos;
	
	@Autowired
	private OrderRepo orderRepos;
	
	@Autowired
	private ProductRepo productRepos;

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		log.info("Customers:");
		customerRepos.findAll()
				.forEach(c -> log.info(c.toString()));

		log.info("Orders:");
		orderRepos.findAll()
				.forEach(o -> log.info(o.toString()));

		log.info("Products:");
		productRepos.findAll()
				.forEach(p -> log.info(p.toString()));

		//Excercise 1 Obtain a list of products belongs to category “Books” with price > 100
		List<Product> e1 = productRepos.findAll()
				.stream()
				.filter(p->p.getCategory().equalsIgnoreCase("Books"))
				.filter(p -> p.getPrice() > 100)
				.collect(Collectors.toList());

		//Exercise 2 — Obtain a list of order with products belong to category “Baby”
		List<Order> e2 = orderRepos.findAll()
						.stream()
								.filter(o->o.getProducts().stream().anyMatch(
										p->p.getCategory().equalsIgnoreCase("Baby")
								)).collect(Collectors.toList());

		//Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
		List<Product> e3 = productRepos.findAll()
						.stream()
								.filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
										.map(p -> p.withPrice(p.getPrice() * 0.9))
												.collect(Collectors.toList());

		//Exercise 4 — Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
		List<Product> e4 = orderRepos.findAll()
				.stream()
				.filter(o -> o.getCustomer().getTier() == 2)
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
				.flatMap(o -> o.getProducts().stream())
				.distinct()
				.collect(Collectors.toList());

		//Exercise 5 — Get the cheapest products of “Books” category
		Optional<Product> e5 = productRepos.findAll()
						.stream()
						.filter(p -> p.getCategory().equalsIgnoreCase("Book"))
						.min(Comparator.comparing(Product::getPrice));

		//Exercise 6 — Get the 3 most recent placed order
		List<Order> e6 = orderRepos.findAll()
				.stream()
				.sorted(Comparator.comparing(Order::getOrderDate).reversed())
				.limit(3)
				.collect(Collectors.toList());

		//Exercise 7 — Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list
		List<Product> e7 = orderRepos.findAll()
				.stream()
				.filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
				.peek(o -> System.out.println(o.toString()))
				.flatMap(o -> o.getProducts().stream())
				.distinct()
				.collect(Collectors.toList());

		//Exercise 8 — Calculate total lump sum of all orders placed in Feb 2021
		Double e8 = orderRepos.findAll()
				.stream()
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
				.flatMap(o -> o.getProducts().stream())
				.mapToDouble(p -> p.getPrice())
				.sum();
		//Exercise 9 — Calculate order average payment placed on 14-Mar-2021
		Double e9 = orderRepos.findAll()
				.stream()
				.filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
				.flatMap(o -> o.getProducts().stream())
				.mapToDouble(p -> p.getPrice())
				.average().getAsDouble();

		//Exercise 10 — Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category “Books”
		DoubleSummaryStatistics statistics = productRepos.findAll()
				.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
				.mapToDouble(p -> p.getPrice())
				.summaryStatistics();
		//statistics.getAverage(), statistics.getCount(), statistics.getMin(), statistics.getMax()

		//Exercise 11 — Obtain a data map with order id and order’s product count
		Map<Long, Integer> e11 = orderRepos.findAll()
				.stream()
				.collect(Collectors.toMap(
						order -> order.getId(),
						order -> order.getProducts().size()
					)
				);

		//exercise 12 — Produce a data map with order records grouped by customer
		Map<Customer, List<Order>> e12 = orderRepos.findAll()
				.stream()
				.collect(
						Collectors.groupingBy(Order::getCustomer)
				);

		//Exercise 13 — Produce a data map with order record and product total sum
		Map<Order, Double> e13 = orderRepos.findAll()
				.stream()
				.collect(
						Collectors.toMap(
								Function.identity(),
								order -> order.getProducts().stream()
										.mapToDouble(p -> p.getPrice()).sum()
						)
				);

		//Exercise 14 — Obtain a data map with list of product name by category
		Map<String, List<String>> e14 = productRepos.findAll()
				.stream()
				.collect(
						Collectors.groupingBy(
								Product::getCategory,
								Collectors.mapping(product -> product.getName(), Collectors.toList())
						)
				);

		//Exercise 15 — Get the most expensive product by category
		Map<String, Optional<Product>> e15 = productRepos.findAll()
				.stream()
				.collect(
						Collectors.groupingBy(
								Product::getCategory,
								Collectors.maxBy(Comparator.comparing(Product::getPrice))
						)
				);
	}

}
