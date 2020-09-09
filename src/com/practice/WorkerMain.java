package com.practice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WorkerMain {

	public static void main(String[] args) {
		List<Worker> workers = List.of(new Worker("Toothless", 26, 52000, "Develop"),
				new Worker("Hookfang", 35, 85000, "Develop"),
				new Worker("Stormfly", 30, 65000, "HR"),
				new Worker("Meatlug", 28, 40000, "Testing"),
				new Worker("CloudJumper", 38, 38000, "Testing"),
				new Worker("Skullcrusher", 40, 90000, "Admin"));

		System.out.println("List of Workers whose salary is less then 60000:");
		List<Worker> list1 = workers.stream().filter(w -> w.getSalary() < 60000)
						.collect(Collectors.toList());
		list1.forEach(System.out::println);
		
		System.out.print("\nCount of workers whose salary greater than 30000 less than 60000: ");
		long count = workers.stream().filter(w -> w.getSalary() > 30000 && w.getSalary() < 60000)
					.count();
		System.out.println(count);
		
		System.out.println("\nOldest worker, get worker object and print:");
		Worker oldestWorker = workers.stream().max(Comparator.comparing(w -> w.getAge())).get();
		System.out.println(oldestWorker);
		
		System.out.println("\nJunior worker,get worker object and print:");
		Worker juniorWorker = workers.stream().min(Comparator.comparing(w -> w.getAge())).get();
		System.out.println(juniorWorker);
		
		System.out.println("\nHighest paid worker,get worker object and print:");
		Worker highestPaid = workers.stream().max(Comparator.comparing(w -> w.getSalary())).get();
		System.out.println(highestPaid);
		
		System.out.println("\nLowest paid worker,get worker object and print:");
		Worker lowestPaid = workers.stream().min(Comparator.comparing(w -> w.getSalary())).get();
		System.out.println(lowestPaid);
		
		System.out.println("\nSort worker age, lowest to Highest,get list of worker names and print:");
		Comparator<Worker> c = Comparator.comparing(w -> w.getAge());
		List<Worker> ascendingWorkerAge = workers.stream().sorted(c).collect(Collectors.toList());
		ascendingWorkerAge.forEach(System.out::println);
		
		System.out.println("\nSort worker age, highest to lowest,get list of worker names and print:");
		List<Worker> descendingWorkerAge = workers.stream().sorted(c.reversed()).collect(Collectors.toList());
		descendingWorkerAge.forEach(System.out::println);
		
		System.out.println("\nAverage Salary of all workers:");
		workers.stream().mapToLong(w -> w.getSalary()).average().ifPresent(avg -> System.out.println(avg));
		
		System.out.println("\nAverage age of all workers:");
		workers.stream().mapToInt(w -> w.getAge()).average().ifPresent(avg -> System.out.println(avg));
	}

}
