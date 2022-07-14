package kr.momjobgo.eyou.web.service;

import kr.momjobgo.eyou.web.jpa.entity.TimeTakenEntity;

import java.util.List;

public interface TimeTakenService {
    List<TimeTakenEntity> getAll();
    TimeTakenEntity getById(Long id);
}
