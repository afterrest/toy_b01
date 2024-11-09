package org.zerock.b01.service;

import org.zerock.b01.dto.BoardDTO;

public interface BoardService {

    Long register(BoardDTO boardDTO );
    BoardDTO readOne(Long id);
    void modify(BoardDTO boardDTO);
    void remove(Long id);
}