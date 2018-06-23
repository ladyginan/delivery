package service;

import com.app.model.Map;
import com.app.repository.impl.MapRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class MapServiceTest {
    @Mock
    MapRepository mapRepositoryMock;

    List<Map> maps;
    Map city;

    @BeforeEach
    void init(){
        city = new Map(1,"3213",3.0,3.0);
        maps.add(city);
        when(mapRepositoryMock.findCityById(1)).thenReturn(city);
        when(mapRepositoryMock.getAllMap()).thenReturn(maps);
    }


}
