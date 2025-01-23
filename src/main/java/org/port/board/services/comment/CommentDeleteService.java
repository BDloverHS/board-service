package org.port.board.services.comment;

import lombok.RequiredArgsConstructor;
import org.port.board.entities.BoardData;
import org.port.board.entities.CommentData;
import org.port.board.repositories.CommentDataRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@RequiredArgsConstructor
public class CommentDeleteService {

    private final CommentDataRepository commentDataRepository;
    private final CommentInfoService infoService;
    private final CommentUpdateService updateService;

    /**
     * 댓글 삭제
     *
     * @param seq
     * @return
     */
    public BoardData delete(Long seq) {
        CommentData item = infoService.get(seq);
        BoardData data = item.getData();

        commentDataRepository.delete(item);
        commentDataRepository.flush();

        // 댓글 갯수 업데이트
        updateService.updateCount(data.getSeq());

        return data;
    }
}
