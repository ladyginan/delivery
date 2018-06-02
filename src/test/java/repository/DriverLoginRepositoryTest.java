package repository;

import com.app.model.Driver;
import com.app.model.Map;
import com.app.model.Enums.DriverStatus;
import com.app.model.Waggon;
import com.app.repository.DriverLoginRepositoryInterface;
import com.app.repository.DriversRepositoryInterface;
import com.app.repository.impl.DriverLoginRepository;
import com.app.repository.impl.DriversRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//public class DriverLoginRepositoryTest {
//    @Mock
//    private SessionFactory factory;
//    @Mock
//    private DriverLoginRepositoryInterface repository;
//    @Mock
//    private DriversRepositoryInterface driversRepository;
//    @Mock
//    private Session session;
//
//
//    com.app.model.Map city;
//
//    private Waggon waggon;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        when(factory.openSession()).thenReturn(session);
//        this.repository = new DriverLoginRepository(factory);
//        this.driversRepository = new DriversRepository(factory);
//    }

//    @Test
//    public void testFindDriverPersonalNumber(){
//        Driver driver = new Driver(5858,"Vasya","Petrov",8,DriverStatus.DRIVING, city, waggon );
//        driversRepository.addDriver(driver);
//        int idDriver = driver.getIdDriver();
//        int personalNumber = repository.findDriverPersonalNumber(idDriver);
//        assertEquals(idDriver, personalNumber);
//    }
//
//    @Test
//    public void testFindCurrentWaggon(){
//
//    }
//}
