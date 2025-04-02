package com.younggalee.section03.dao;

import com.younggalee.section03.dto.CategoryDto;
import com.younggalee.section03.dto.MenuDto;

import java.util.List;

public interface MenuMapper {
    // 전체, 카테고리선택 시 출력
    List<MenuDto> selectAllMenu();
    MenuDto selectMenuByMenuCode(int code);
    List<MenuDto> selectMenuByCategoryCode(int categoryCode);
    List<CategoryDto> selectAllSubCategory();
    int insertMenu(MenuDto menu);
    int updateMenu(MenuDto menu);
    int deleteMenu(int code);


    // view controller 구현없이도 Junit 가지고 test 할 수 있음

}
