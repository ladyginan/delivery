package com.app.configuration.rabbitMq;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DriverJson extends JsonParse implements Serializable {
    private int driversCount;
    private int freeDriversCount;
    private int busyDriversCount;
}
