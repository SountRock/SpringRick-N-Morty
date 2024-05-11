package com.example.HWSpring6RNM.domain.character;

import com.example.HWSpring6RNM.domain.Info;
import com.example.HWSpring6RNM.domain.ModelsListI;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Characters implements ModelsListI {
    Info info;
    List<CharacterResult> results;
}
