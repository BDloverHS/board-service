package org.koreait.board.controllers;

import lombok.Data;

import java.util.List;

@Data
public class BoardSearch {
    private List<String> bid;
    private String sort; // 필드명_정렬방향  예) viewCount_DESC
    private List<String> email; // 회원 이메일
    private List<String> category; // 분류 조회
}
