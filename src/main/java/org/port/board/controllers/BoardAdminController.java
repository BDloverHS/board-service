package org.port.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.port.board.entities.Board;
import org.port.board.services.BoardDeleteService;
import org.port.board.services.BoardUpdateService;
import org.port.board.services.configs.BoardConfigDeleteService;
import org.port.board.services.configs.BoardConfigInfoService;
import org.port.board.validators.BoardConfigValidator;
import org.port.global.exceptions.BadRequestException;
import org.port.global.libs.Utils;
import org.port.global.paging.ListData;
import org.port.global.rests.JSONData;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class BoardAdminController {

    private final Utils utils;
    private final BoardConfigValidator configValidator;
    private final BoardUpdateService updateService;
    private final BoardConfigInfoService infoService;
    private final BoardConfigDeleteService deleteService;

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

        Board board = updateService.process(form);

        return new JSONData(board);
    }

    /**
     * 게시판 설정 목록
     *
     * @return
     */
    @GetMapping("/config")
    public JSONData list(@ModelAttribute BoardConfigSearch search) {

        ListData<Board> items = infoService.getList(search);

        return new JSONData(items);
    }

    /**
     * 게시판 한개 또는 여러개 일괄 수정
     *
     * @return
     */
    @PatchMapping("/config")
    public JSONData update(@RequestBody List<RequestConfig> form) {

        List<Board> items = updateService.process(form);

        return null;
    }

    /**
     * 게시판 한개 또는 여러개 삭제 처리
     *
     * @param bids
     * @return
     */
    @DeleteMapping("/config")
    public JSONData delete(@RequestParam("bid") List<String> bids) {

        List<Board> items = deleteService.process(bids);

        return new JSONData(items);
    }
}
