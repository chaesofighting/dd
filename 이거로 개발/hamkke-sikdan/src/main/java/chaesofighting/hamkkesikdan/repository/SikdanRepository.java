package chaesofighting.hamkkesikdan.repository;

import chaesofighting.hamkkesikdan.domain.Sikdan;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SikdanRepository {

    private final EntityManager em;

    /**
     * 칼로리, 질환, 랜덤수에 해당하는 식단 조회
     */
    public SikdanResult findByCalorieSyndromeRand(int calorie, int syndrome, int rand) {
        SikdanResult sikdanResult = new SikdanResult();

        Sikdan sikdan = new Sikdan();
        sikdan = em.createQuery("select s from Sikdan s where s.calorie = :calorie and s.syndrome = :syndrome and s.rand = :rand", Sikdan.class)
                .setParameter("calorie", calorie)
                .setParameter("syndrome", syndrome)
                .setParameter("rand", rand)
                .getSingleResult();

        sikdanResult.setBreakfast(sikdan.getBreakfast());
        sikdanResult.setLunch(sikdan.getLunch());
        sikdanResult.setDinner(sikdan.getDinner());
        return sikdanResult;
    }

    /**
     * 식단 db에 저장
     */
    public void save(Sikdan sikdan) {
        em.persist(sikdan);
    }
}
