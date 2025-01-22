package org.koreait.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.koreait.board.validations.BoardConfigValidator;
import org.koreait.global.exceptions.BadRequestException;
import org.koreait.global.libs.Utils;
import org.koreait.global.rests.JSONData;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class BoardAdminController {

    private final Utils utils;
    private final BoardConfigValidator configValidator;

    /**
     * 게시판 설정 등록, 수정 처리
     *
     * @return
     */
    @PostMapping("/config")
    public JSONData save(@Valid @RequestBody RequestConfig form, Errors errors) {
        configValidator.validate(form, errors);

        if (errors.hasErrors()) {
            throw new BadRequestException(utils.getErrorMessages(errors));
        }

        return null;
    }

    /**
     * 게시판 설정 목록
     *
     * @return
     */
    @GetMapping("/config")
    public JSONData list(@ModelAttribute BoardConfigSearch search) {
        return null;
    }

    /**
     * 게시판 한 개 또는 여러 개 일괄 수정
     *
     * @return
     */
    @PatchMapping("/config")
    public JSONData update(@RequestBody List<RequestConfig> form) {
        return null;
    }

    /**
     * 게시판 한 개 또는 여러 개 삭제 처리
     *
     * @param bids
     * @return
     */
    @DeleteMapping("/config")
    public JSONData delete(@RequestParam("bid") List<String> bids) {
        return null;
    }

    /**
     * 게시글 번호로 공통 처리
     *
     * @param seq
     * @param mode
     */

}
