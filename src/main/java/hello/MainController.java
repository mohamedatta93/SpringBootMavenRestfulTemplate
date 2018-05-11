package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.Employee;
import hello.EmployeeRepository;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam Double salary) {

		Employee e = new Employee();
		e.setName(name);
		e.setSalary(salary);
		employeeRepository.save(e);

		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

}
