package service;

import com.app.model.Driver;
import com.app.model.Enums.DriverStatus;
import com.app.model.Waggon;
import com.app.repository.impl.DriversRepository;
import com.app.service.impl.DriverService;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.app.model.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverServiceTest {
    @Mock
    DriversRepository driversRepository;
//    @Mock
////    Map city;
////    @Mock
////    Waggon waggon;
    @Mock
    Driver driver;
    DriverService driverService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        this.driverService = new DriverService();
        Driver driver = new Driver();
    }

    @Test( expected = NullPointerException.class )
    public void whenCreateIsTriggeredForNullEntity_thenException(){
        this.driverService.addDriver(null);
    }
    @Test
    public void driverServiceAddDriverTest() {
        this.driverService.addDriver(driver);
    }


//        this.city = new Map();
//        this.waggon = new Waggon();
//        driver = new Driver(5858,"Vasya","Petrov",8,DriverStatus.DRIVING, city, waggon );


//
//    @Test
//    public void driverServiceAddDriver(){
//        this.driversRepository.addDriver(driver);
//        int idDriver = driver.getIdDriver();
//        Driver driverFromDB = driversRepository.getDriver(idDriver);
//        assertEquals(idDriver, driverFromDB.getIdDriver());
//    }
//

}
