package service;

import com.app.DTO.DriverDTO;
import com.app.model.Driver;
import com.app.model.Enums.DriverStatus;
import com.app.model.Enums.WaggonStatus;
import com.app.model.Waggon;
import com.app.repository.impl.DriversRepository;
import com.app.repository.impl.MapRepository;
import com.app.repository.impl.WaggonRepository;
import com.app.service.impl.DriverService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.app.model.Map;


import java.util.ArrayList;
import java.util.List;

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
    @InjectMocks
    DriverService driverService;


    Driver driverMock;
    DriverDTO driverDTOMock;
    List<Driver> driversMock;
    List<DriverDTO> driversDTOMock;


  @BeforeEach
  void init(){
      Map city = new Map(1,"3213",3.0,3.0);
      Waggon waggon = new Waggon(1,"4324",8,4,WaggonStatus.WORKING,city,null,null);
      driverMock = new Driver(1,5858,"Vasya","Petrov",8, DriverStatus.DRIVING, city, waggon, null,0 );
      driversMock = new ArrayList<>();
      driversDTOMock = new ArrayList<>();
      driverDTOMock = new DriverDTO(driverMock);
      driversDTOMock.add(driverDTOMock);
      driversMock.add(driverMock);
      when(driversRepositoryMock.getDriver(1)).thenReturn(driverMock);
      when(waggonRepositoryMock.getWaggon(1)).thenReturn(waggon);
      when(driversRepositoryMock.getAllDrivers()).thenReturn(driversMock);
      when(driversRepositoryMock.updateDriver(driverMock)).thenReturn(driverMock);
      when(driversRepositoryMock.removeDriver(1)).thenReturn(driverMock);
      when(driversRepositoryMock.addDriver(driverMock)).thenReturn(driverMock);
      when(mapRepositoryMock.findCityById(1)).thenReturn(city);
  }

  @Test
  void getAllDriversTest(){
    List<Driver> drivers = driverService.getAllDrivers();
      Assertions.assertIterableEquals(drivers,driversMock);

  }
  @Test
  void getAllDriversJsonTest(){
      List<Driver> drivers = driverService.getAllDrivers();
      List<DriverDTO> driversDTO = new ArrayList<>();
      for (Driver driver : drivers) {
          driversDTO.add(new DriverDTO(driver));
      }
      Assertions.assertEquals(driversDTO,driversDTOMock);
  }

  @Test
  void addDriver(){
      Driver driver = driverService.addDriver(driverMock);
      Assertions.assertEquals(driver, driverMock);
      Assertions.assertTrue(driver.getClass().equals(Driver.class));
  }

  @Test
  void updateDriverTest(){
      DriverDTO driver = driverService.updateDriver(driverDTOMock);
      Assertions.assertTrue(driver.getClass().equals(DriverDTO.class));
      Assertions.assertEquals(driver, driverDTOMock);
  }

  @Test
  void getDriverDTO(){
      Driver driver = driverService.getDriver(1);
      DriverDTO driverDTO = new DriverDTO(driver);
      Assertions.assertEquals(driverDTO, driverDTOMock);
      Assertions.assertTrue(driverDTO.getClass().equals(DriverDTO.class));
  }

    @Test
    void driverServiceGetTest() {
        Driver driver = driverService.getDriver(1);
        Assertions.assertEquals(driver.getIdDriver(), driverMock.getIdDriver());
        Assertions.assertTrue(driver.getClass().equals(Driver.class));
    }

    @Test
    void removeDriverTest(){
      Driver driver = driverService.removeDriver(1);
        Assertions.assertEquals(driver.getIdDriver(), driverMock.getIdDriver());
        Assertions.assertTrue(driver.getClass().equals(Driver.class));
    }

}
