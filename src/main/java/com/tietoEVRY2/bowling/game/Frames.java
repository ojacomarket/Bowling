package com.tietoEVRY2.bowling.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Frames {

    public Integer roll1 = 0;
    public Integer roll2 = 0;
    public Integer roll3;
    public Integer scoreToCount = 0;
}
