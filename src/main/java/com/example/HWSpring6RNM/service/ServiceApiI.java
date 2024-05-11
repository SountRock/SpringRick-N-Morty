package com.example.HWSpring6RNM.service;

import com.example.HWSpring6RNM.domain.ModelsListI;

public interface ServiceApiI {
    ModelsListI getAll();
    String getServiceName();
}
