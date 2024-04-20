package in.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.sp.entity.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PartyDao {
    
    @Autowired
    private DataSource ds;

    public void createParty(Party party) throws SQLException{
        Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO Party (party_id,party_enum_type_id) VALUES (?,?)");
        ps.setString(1, party.getParty_id());
        ps.setString(2, party.getParty_enum_type_id());

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data inserted successfully.");
        } else {
            System.out.println("Failed to insert data.");
        }

    }
}
