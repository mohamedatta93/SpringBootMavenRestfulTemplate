package hello;

import org.springframework.data.repository.CrudRepository;
import hello.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	
}
