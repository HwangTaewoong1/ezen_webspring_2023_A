package example.팀과제;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEntityRepository extends JpaRepository<CarEntity, Integer> {
}