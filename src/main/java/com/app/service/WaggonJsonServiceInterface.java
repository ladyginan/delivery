package com.app.service;

import com.app.configuration.rabbitMq.WaggonJson;

public interface WaggonJsonServiceInterface {

    int getAllWaggonCount();

    int getAllFreeWaggonCount();

    int getAllBusyWaggonCount();

    int getAllWorkingWaggonCount();

    int getAllBrokenWaggonCount();

    WaggonJson getWaggonJson();
}
