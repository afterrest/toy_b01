package org.zerock.b01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.domain.Board;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(0, 10).forEach(i -> {//rangeClosed: 끝값 포함
            Board board = Board.builder()
                    .title("title"+i)
                    .content("description"+i)
                    .author("user"+(i%10))
                    .build();

            Board saved = boardRepository.save(board);
            log.info(saved.toString());

        });
    }

    @Test
    public void  testSelect() {
        Long id = 5L;

        Optional<Board> result = boardRepository.findById(id);

        Board board = result.orElseThrow();

        log.info(board.toString());
    }

    @Test
    public void testUpdate() {
        Long id = 5L;

        Optional<Board> result = boardRepository.findById(id);

        Board board = result.orElseThrow();

        board.change("updated title", "updated content");

        log.info(board.toString());

        boardRepository.save(board);
    }

    @Test
    public void testDelete() {
        Long id = 2L;
        boardRepository.deleteById(id);

    }


    @Test
    public void testFindAll() {
    }
}
