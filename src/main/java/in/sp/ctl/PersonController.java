package in.sp.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.dao.PersonDao;
import in.sp.entity.Person;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class PersonController{

	@Autowired
	private PersonDao personDao;

	@PostMapping("/api/person")
	public ResponseEntity<String> createPerson(@RequestBody Person person){
		try {
            System.out.println(person);
            personDao.createPerson(person);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("Failed to create person");
        }
		return ResponseEntity.ok("person created successfully");
	} 
}
