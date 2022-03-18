package co.com.linadev.springbootwebflux.utils;

import co.com.linadev.springbootwebflux.model.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvUtilFileTest {

    @Test
    public void readTest(){
        List<Player> list = CsvUtilFile.getPlayers();
        assert list.size() == 18207;
    }

}