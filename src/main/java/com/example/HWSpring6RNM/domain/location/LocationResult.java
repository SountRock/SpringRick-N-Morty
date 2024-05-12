package com.example.HWSpring6RNM.domain.location;

import com.example.HWSpring6RNM.domain.ResultI;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationResult implements ResultI{
    int id;
    String name;
    String type;
    String dimension;
    List<String> residents;
    String url;
    Date created;
}
