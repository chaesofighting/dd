package chaesofighting.hamkkesikdan.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Getter
@Setter
public class Sikdan {

    @Id
    @GeneratedValue
    private Long id;

    private int calorie;

    private int syndrome;

    private String breakfast;

    private String lunch;

    private String dinner;

    private int rand;
}
