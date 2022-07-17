package kr.momjobgo.eyou.web.jpa.repository;

import kr.momjobgo.eyou.web.jpa.entity.CookingOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookingOrderRepository extends JpaRepository<CookingOrderEntity, Long> {
}
