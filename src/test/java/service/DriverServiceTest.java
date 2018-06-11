package service;

import com.app.model.Driver;
import com.app.model.Enums.DriverStatus;
import com.app.model.Waggon;
import com.app.repository.impl.DriversRepository;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.app.model.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverServiceTest {
    @Mock
    SessionFactory factory;
    @Mock
    Map city;
    @Mock
    private Waggon waggon;

    DriversRepository driversRepository;
    Driver driver;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
        this.driversRepository = new DriversRepository(factory);
        driver = new Driver(5858,"Vasya","Petrov",8,DriverStatus.DRIVING, city, waggon );
    }

    @Test
    public void driverServiceAddDriver(){
        this.driversRepository.addDriver(driver);
        int idDriver = driver.getIdDriver();
        Driver driverFromDB = driversRepository.getDriver(idDriver);
        assertEquals(idDriver, driverFromDB.getIdDriver());
    }

    @Test( expected = NullPointerException.class )
    public void whenCreateIsTriggeredForNullEntity_thenException(){
        this.driversRepository.addDriver(null);
    }

}
