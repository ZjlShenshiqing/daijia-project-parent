package com.zjl.daijia.coupon.controller;

import com.zjl.daijia.common.result.Result;
import com.zjl.daijia.coupon.service.CouponInfoService;
import com.zjl.daijia.model.entity.coupon.CouponInfo;
import com.zjl.daijia.model.form.coupon.UseCouponForm;
import com.zjl.daijia.model.vo.base.PageVO;
import com.zjl.daijia.model.vo.coupon.AvailableCouponVO;
import com.zjl.daijia.model.vo.coupon.NoReceiveCouponVO;
import com.zjl.daijia.model.vo.coupon.NoUseCouponVO;
import com.zjl.daijia.model.vo.coupon.UsedCouponVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 优惠券活动前端交互层
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Tag(name = "优惠券活动")
@RestController
@RequestMapping("/coupon/info")
@SuppressWarnings({"unchecked", "rawtypes"})
public class CouponInfoController {

    @Resource
    private CouponInfoService couponInfoService;

    /**
     * 查询未领取优惠券分页列表
     * @param customerId 顾客id
     * @param page 当前页码
     * @param limit 每页记录数
     * @return 未领取优惠券分页结果
     */
    @Operation(summary = "查询未领取优惠券分页列表")
    @GetMapping("findNoReceivePage/{customerId}/{page}/{limit}")
    public Result<PageVO<NoReceiveCouponVO>> findNoReceivePage(
        @Parameter(name = "customerId", description = "乘客id", required = true)
        @PathVariable Long customerId,

        @Parameter(name = "page", description = "当前页码", required = true)
        @PathVariable Long page,

        @Parameter(name = "limit", description = "每页记录数", required = true)
        @PathVariable Long limit
    ) {
        // 组装分页参数
        Page<CouponInfo> pageParam = new Page<>(page, limit);
        // 获取未领取优惠券分页列表
        PageVO<NoReceiveCouponVO> pageVO = couponInfoService.findNoReceivePage(pageParam, customerId);
        pageVO.setPage(page);
        pageVO.setLimit(limit);
        return Result.ok(pageVO);
    }

    /**
     * 查询未使用优惠券分页列表
     * @param customerId 顾客id
     * @param page 当前页码
     * @param limit 每页记录数
     * @return 未使用优惠券分页结果
     */
    @Operation(summary = "查询未使用的优惠券分页列表")
    @GetMapping("findNoUsePage/{customerId}/{page}/{limit}")
    public Result<PageVO<NoUseCouponVO>> findNoUsePage(
            @Parameter(name = "customerId", description = "乘客id", required = true)
            @PathVariable Long customerId,

            @Parameter(name = "page", description = "当前页码", required = true)
            @PathVariable Long page,

            @Parameter(name = "limit", description = "每页记录数", required = true)
            @PathVariable Long limit
    ) {
        Page<CouponInfo> pageParam = new Page<>(page, limit);
        PageVO<NoUseCouponVO> pageVO = couponInfoService.findNoUsePage(pageParam, customerId);
        pageVO.setPage(page);
        pageVO.setLimit(limit);
        return Result.ok(pageVO);
    }

    /**
     * 领取优惠券
     * @param customerId 客户id
     * @param couponId 优惠券id
     * @return 领取优惠券结果
     */
    @Operation(summary = "领取优惠券")
    @GetMapping("/receive/{customerId}/{couponId}")
    public Result<Boolean> receive(
            @PathVariable Long customerId,
            @PathVariable Long couponId
    ) {
        return Result.ok(couponInfoService.receive(customerId, couponId));
    }

    /**
     * 获取未使用的最佳优惠券信息
     * @param customerId 顾客id
     * @param orderAmount 订单金额
     * @return 最佳的优惠券
     */
    @Operation(summary = "获取未使用的最佳优惠券信息")
    @GetMapping("findAvailableCoupon/{customerId}/{orderAmount}")
    public Result<List<AvailableCouponVO>> findAvailableCoupon(
            @PathVariable Long customerId,
            @PathVariable BigDecimal orderAmount
            ) {
        return Result.ok(couponInfoService.findAvailableCoupon(customerId, orderAmount));
    }

    /**
     * 使用优惠券
     * @param useCouponForm 使用优惠券的表单
     * @return 使用结果
     */
    @Operation(summary = "使用优惠券")
    @PostMapping("/useCoupon")
    public Result<BigDecimal> useCoupon(@RequestBody UseCouponForm useCouponForm) {
        return Result.ok(couponInfoService.useCoupon(useCouponForm));
    }

    /**
     * 分页查询已使用优惠券
     * @param customerId 顾客id
     * @param page 当前页数
     * @param limit 每页记录数
     * @return 已使用优惠券分页结果
     */
    public Result<PageVO<UsedCouponVO>> findUsedPage(
            @Parameter(name = "customerId", description = "乘客id", required = true)
            @PathVariable Long customerId,

            @Parameter(name = "page", description = "当前页码", required = true)
            @PathVariable Long page,

            @Parameter(name = "limit", description = "每页记录数", required = true)
            @PathVariable Long limit
    ) {
        Page<CouponInfo> pageParam = new Page<>(page, limit);
        PageVO<UsedCouponVO> pageVO = couponInfoService.findUsedPage(pageParam, customerId);
        pageVO.setPage(page);
        pageVO.setLimit(limit);
        return Result.ok(pageVO);
    }
}
