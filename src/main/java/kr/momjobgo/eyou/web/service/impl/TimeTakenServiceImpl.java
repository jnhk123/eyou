package kr.momjobgo.eyou.web.service.impl;

import kr.momjobgo.eyou.web.jpa.entity.TimeTakenEntity;
import kr.momjobgo.eyou.web.jpa.repository.TimeTakenRepository;
import kr.momjobgo.eyou.web.service.TimeTakenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeTakenServiceImpl implements TimeTakenService {
    private final TimeTakenRepository timeTakenRepository;

    public TimeTakenServiceImpl(TimeTakenRepository timeTakenRepository) { this.timeTakenRepository = timeTakenRepository; }

    @Override
    public List<TimeTakenEntity> getAll() { return timeTakenRepository.findAll(); }

    @Override
    public TimeTakenEntity getById(Long id){

        Optional<TimeTakenEntity> timeTakenEntity = timeTakenRepository.findById(id);

        if(timeTakenEntity.isPresent()){
            return timeTakenEntity.get();
        } else {
            return null;
        }
    }
}
