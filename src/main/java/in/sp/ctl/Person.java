package in.sp.ctl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Person{

	@PostMapping("/api/person")
	public ResponseEntity<String> createPerson(@RequestBody Person person){
		System.out.println(person);
		return ResponseEntity.ok("person created successfully");
	} 
}
