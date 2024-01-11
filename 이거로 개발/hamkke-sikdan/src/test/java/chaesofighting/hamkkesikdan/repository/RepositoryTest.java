package chaesofighting.hamkkesikdan.repository;

import chaesofighting.hamkkesikdan.domain.Sikdan;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;

@SpringBootTest
@Transactional
public class RepositoryTest {

    @Autowired SikdanRepository sikdanRepository;
    @Autowired EntityManager em;

    @Test
    @Rollback(value = false)
    public void 식단조회() throws Exception {
        //given
        Sikdan sikdan =  new Sikdan();
        sikdan.setBreakfast("통밀빵 샌드위치(360)");
        sikdan.setLunch("백미밥 100g 깍두기 50g 두부조림 50g");
        sikdan.setDinner("잡곡밥 100g 부채살 스테이크 100g");
        sikdan.setRand(2);
        sikdan.setCalorie(1800);
        sikdan.setSyndrome(3); //일반식이라 치자.
        sikdanRepository.save(sikdan);

        //when
        SikdanResult sikdanResult;
        sikdanResult = sikdanRepository.findByCalorieSyndromeRand(1800, 3, 2);

        //then
        System.out.println("아침: "+sikdanResult.getBreakfast());
        System.out.println("점심: " + sikdanResult.getLunch());
        System.out.println("저녁: "+sikdanResult.getDinner());
    }
}
