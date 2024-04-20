package in.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.sp.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PersonDao {

    @Autowired
    private DataSource ds;

    public void createPerson(Person person) throws SQLException {
        Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Person (party_id, first_name, middle_name, last_name, gender, birth_date, marital_status_enum_id, employment_status_enum_id, occupation) "
                        +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

        ps.setString(1, person.getParty_id());
        ps.setString(2, person.getFirst_name());
        ps.setString(3, person.getMiddle_name());
        ps.setString(4, person.getLast_name());
        ps.setString(5, String.valueOf(person.getGender()));
        ps.setString(6, person.getBirth_date());
        ps.setString(7, person.getMaterial_status_enum_id());
        ps.setString(8, person.getEmployment_status_enum_id());
        ps.setString(9, person.getOccupation());
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data inserted successfully.");
        } else {
            System.out.println("Failed to insert data.");
        }
    }
}
