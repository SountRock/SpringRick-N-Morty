package com.example.HWSpring6RNM.domain.location;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationResult {
    int id;
    String name;
    String type;
    String dimension;
    List<Object> residents;
    String url;
    Date created;
}
