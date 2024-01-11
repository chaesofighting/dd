package chaesofighting.hamkkesikdan.repository;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SikdanResult { //프론트에 식단 넘겨줄 때 이 클래스에 담아서 넘김.

    private String breakfast; //아침식사
    private String lunch; //점심식사
    private String dinner; //저녁식사
}
