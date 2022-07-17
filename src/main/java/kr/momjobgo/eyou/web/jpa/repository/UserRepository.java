package kr.momjobgo.eyou.web.jpa.repository;

import kr.momjobgo.eyou.web.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findBySnsId(String snsId);
}

