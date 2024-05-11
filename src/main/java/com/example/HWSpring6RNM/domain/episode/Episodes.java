package com.example.HWSpring6RNM.domain.episode;

import com.example.HWSpring6RNM.domain.ModelsListI;
import com.example.HWSpring6RNM.domain.Info;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Episodes implements ModelsListI {
    Info info;
    List<EpisodeResult> results;
}
