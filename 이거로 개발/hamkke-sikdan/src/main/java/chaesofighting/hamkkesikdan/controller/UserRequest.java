package chaesofighting.hamkkesikdan.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequest {

    private int totalCalories; //프론트에서 받을 총칼로리
    private int syndrome;
    private int rand;
}
