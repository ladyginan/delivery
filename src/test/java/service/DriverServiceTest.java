package service;

import com.app.model.Driver;
import com.app.model.Enums.DriverStatus;
import com.app.model.Enums.WaggonStatus;
import com.app.model.Waggon;
import com.app.repository.WaggonRepositoryInterface;
import com.app.repository.impl.DriversRepository;
import com.app.repository.impl.MapRepository;
import com.app.repository.impl.WaggonRepository;
import com.app.service.impl.DriverService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.app.model.Map;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class DriverServiceTest {
    @Mock
    DriversRepository driversRepositoryMock;
    @Mock
    WaggonRepository waggonRepositoryMock;
    @Mock
    MapRepository mapRepositoryMock;

    DriverService driverService;
    Driver driverMock;

    @BeforeEach
    void init() {
        driverService = new DriverService(driversRepositoryMock, waggonRepositoryMock, mapRepositoryMock);
        Map city = new Map(1, "3213", 3.0, 3.0);
        Waggon waggon = new Waggon(1, "4324", 8, 4, WaggonStatus.WORKING, city, null, null);
        driverMock = new Driver(1, 5858, "Vasya", "Petrov", 8, DriverStatus.DRIVING, city, waggon, null, 0);
        when(mapRepositoryMock.findCityById(1)).thenReturn((city));
        when(driversRepositoryMock.getDriver(1)).thenReturn(driverMock);
        when(waggonRepositoryMock.getWaggon(1)).thenReturn(waggon);
    }

    @Test
    void driverServiceGetTest() {
        Driver driver = driverService.getDriver(1);
        Assertions.assertEquals(driver.getIdDriver(), driverMock.getIdDriver());
    }
}