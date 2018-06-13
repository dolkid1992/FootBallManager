package football.repository;

import football.model.TeamFootball;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeamFootBallRepository extends PagingAndSortingRepository<TeamFootball, Long> {
}
