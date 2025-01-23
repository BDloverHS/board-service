package org.port.board.controllers;

import lombok.Data;
import org.port.global.paging.CommonSearch;

import java.util.List;

@Data
public class BoardConfigSearch extends CommonSearch {
    private List<String> bid;
}
