package org.port.board.services;

import lombok.RequiredArgsConstructor;
import org.port.board.entities.BoardData;
import org.port.board.repositories.BoardDataRepository;
import org.port.global.libs.Utils;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Lazy
@Service
@RequiredArgsConstructor
public class BoardDeleteService {
    private final BoardInfoService infoService;
    private final BoardDataRepository boardRepository;
    private final RestTemplate restTemplate;
    private final Utils utils;

    public BoardData delete(Long seq) {

        BoardData item = infoService.get(seq);

        // 파일 삭제 S
        HttpEntity<Void> request = new HttpEntity<>(utils.getRequestHeader());
        String apiUrl = utils.serviceUrl("file-service", "/deletes/" + item.getGid());
        restTemplate.exchange(URI.create(apiUrl), HttpMethod.DELETE, request, Void.class);
        // 파일 삭제 E

        boardRepository.delete(item);
        boardRepository.flush();

        // 비회원 인증 정보 삭제
        utils.deleteValue(utils.getUserHash() + "_board_" + seq);

        return item;
    }
}
