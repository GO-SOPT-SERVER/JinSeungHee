package sopt.org.FourthSeminar.infrastructrue;

import org.springframework.data.repository.Repository;
import sopt.org.FourthSeminar.domain.Board;

public interface BoardRepository extends Repository<Board, Long> {

    void save(Board board);
}
