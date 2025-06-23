package com.zjl.daijia.model.vo.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果包装
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
@Schema(description = "分页结果包装")
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PageVO<T> implements Serializable {

    @Schema(description = "当前页码", required = true)
    private Long page;

    @Schema(description = "每页记录数", required = true)
    private Long limit;

    @Schema(description = "总页数", required = true)
    private Long pages;

    @Schema(description = "总条目数", required = true)
    private Long total;

    @Schema(description = "数据列表", required = true)
    private List<T> records;

    public PageVO(List<T> list, Long pages, Long total) {
        this.setRecords(list);
        this.setTotal(total);
        this.setPages(pages);
    }
}
