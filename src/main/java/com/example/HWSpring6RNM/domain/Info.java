package com.example.HWSpring6RNM.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Info {
    Integer count;
    Integer pages;
    String next;
    String prev;
}
