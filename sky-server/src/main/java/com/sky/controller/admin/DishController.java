package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "Dish interface")
@Slf4j
public class DishController {

    @Autowired
    public DishService dishService;

    /**
     * @param dishDTO
     * @return
     */
    @PostMapping
    @ApiOperation("Add new dish")
    public Result<Void> save(@RequestBody DishDTO dishDTO) {
        log.info("Add new dish: {}", dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("Dish Query Page")
    public Result<PageResult> queryDishPage(DishPageQueryDTO dishPageQueryDTO) {
        log.info("Dish Query Page: {}", dishPageQueryDTO);
        PageResult pageResult = dishService.pageDishQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    @ApiOperation("Delete Dish")
    public Result<Void> deleteDish(@RequestParam List<Long> ids) {
        log.info("Delete Dish(es) ids: {}", ids);
        dishService.deleteDish(ids);
        return  Result.success();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get Dish IDs")
    public Result<DishVO> getById(@PathVariable Long id) {
        log.info("Get Dish by Id: {}", id);
        DishVO dishVO = dishService.getByIdWithFlavor(id);
        return Result.success(dishVO);
    }

    @PutMapping
    @ApiOperation("Update Dish Details")
    public Result<Void> updateDish(@RequestBody DishDTO dishDTO) {
        log.info("Update dish: {}", dishDTO);
        dishService.updateDishWithFlavor(dishDTO);
        return Result.success();
    }
}