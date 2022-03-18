package co.com.linadev.springbootwebflux.utils;

import co.com.linadev.springbootwebflux.model.Player;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CsvUtilFile {

    private CsvUtilFile(){}

    public static List<Player> getPlayers(){

        var uri =  "C:\\TallerReactivo\\SprintBootWebFlux\\src\\test\\java\\co\\com\\linadev\\springbootwebflux\\resources\\data.csv";

        List<Player> list = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(uri))) {

            List<String[]> registers = reader.readAll();

            registers.forEach(strings -> list.add(new Player(null,
                    Long.parseLong(strings[0].trim()),
                    strings[1],
                    Integer.parseInt(Optional.of(strings[2].trim()).filter(h -> !h.isBlank()).orElse("0")),
                    strings[3],
                    strings[4],
                    Integer.parseInt(strings[5].trim()),
                    Integer.parseInt(strings[6].trim()),
                    strings[7]
            )));

            return list;

        } catch (IOException | CsvException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
