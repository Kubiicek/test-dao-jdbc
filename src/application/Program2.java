package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		
		if (list != null) {
			list.forEach(deparment -> System.out.println(deparment));
		}
		
		System.out.println("\n=== TEST 3: department insert ===");
		Department newDeparment = new Department(null, "Notebooks");
		departmentDao.insert(newDeparment);
		System.out.println("Inserted! New id = " + newDeparment.getId());
		
		System.out.println("\n=== TEST 4: department update ===");
		department = departmentDao.findById(4);
		department.setName("Book");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: department delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
