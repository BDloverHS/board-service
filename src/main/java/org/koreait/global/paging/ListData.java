package org.koreait.global.paging;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ListData<T> {
    private List<T> items; // 목록 데이터
    private Pagination pagination;
}
