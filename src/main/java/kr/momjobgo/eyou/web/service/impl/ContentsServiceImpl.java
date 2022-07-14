package kr.momjobgo.eyou.web.service.impl;

import kr.momjobgo.eyou.web.jpa.entity.ContentsEntity;
import kr.momjobgo.eyou.web.jpa.repository.ContentsRepository;
import kr.momjobgo.eyou.web.service.ContentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentsServiceImpl implements ContentsService {
    private final ContentsRepository contentsRepository;

    public ContentsServiceImpl(ContentsRepository contentsRepository) { this.contentsRepository = contentsRepository; }

    @Override
    public List<ContentsEntity> getAll() { return contentsRepository.findAll(); }

    @Override
    public ContentsEntity getById(Long id){

        Optional<ContentsEntity> contentsEntity = contentsRepository.findById(id);

        if(contentsEntity.isPresent()){
            return contentsEntity.get();
        } else {
            return null;
        }
    }

    @Override
    public List<ContentsEntity> getByWriter(Long writer){
        System.out.println(writer);
        List<ContentsEntity> contentsEntity = contentsRepository.findByWriter(writer);
        return contentsEntity;
//        if(contentsEntity.isPresent()){
//            return contentsEntity.get();
//        } else {
//            return null;
//        }
    }
}
