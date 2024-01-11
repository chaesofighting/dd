package chaesofighting.hamkkesikdan.service;

import chaesofighting.hamkkesikdan.repository.SikdanRepository;
import chaesofighting.hamkkesikdan.repository.SikdanResult;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SikdanService {

    private final SikdanRepository sikdanRepository;

    //조회를 하도록 하는 함수
    public SikdanResult showSikdan(int calorie, int syndrome, int rand) {
        return sikdanRepository.findByCalorieSyndromeRand(calorie, syndrome, rand);
    }
}
