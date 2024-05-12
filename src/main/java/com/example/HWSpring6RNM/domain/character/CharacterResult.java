package com.example.HWSpring6RNM.domain.character;

import com.example.HWSpring6RNM.domain.ResultI;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CharacterResult implements ResultI {
    Integer id;
    String name;
    String status;
    String species;
    String type;
    String gender;
    String image;
    String url;
    Date created;
}
