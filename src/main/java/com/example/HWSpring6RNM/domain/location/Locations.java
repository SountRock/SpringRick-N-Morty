package com.example.HWSpring6RNM.domain.location;

import com.example.HWSpring6RNM.domain.ModelsListI;
import com.example.HWSpring6RNM.domain.Info;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Locations implements ModelsListI {
    private Info info;
    private List<LocationResult> results;
}
