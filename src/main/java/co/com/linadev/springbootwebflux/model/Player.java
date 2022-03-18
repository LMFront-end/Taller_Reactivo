package co.com.linadev.springbootwebflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "players")
public class Player {

    @Id
    private String id;
    private Long playerId;
    private String playerName;
    private Integer playerAge;
    private String playerPhoto;
    private String playerCountry;
    private Integer playerSteOne;
    private Integer playerStepTwo;
    private String playerClub;

}
