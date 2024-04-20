package in.sp.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.dao.PartyDao;
import in.sp.entity.Party;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class PartyController {

    @Autowired
    private PartyDao partyDao;

    @PostMapping("/api/party")
    public ResponseEntity<String> createPerson(@RequestBody Party party) {
        try {
            System.out.println(party);
            partyDao.createParty(party);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("Failed to create person");
        }
        return ResponseEntity.ok("person created successfully");
    }
}
