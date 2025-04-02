package com.younggalee.section03.controller;

import com.younggalee.section03.dto.CategoryDto;
import com.younggalee.section03.dto.MenuDto;
import com.younggalee.section03.service.MenuService;
import com.younggalee.section03.view.ResultView;
import org.apache.ibatis.javassist.bytecode.Mnemonic;

import java.util.List;
import java.util.Map;

public class MenuController {
    // 곧바로 호출할 수 있도록

    private MenuService menuService = new MenuService();

    public void selectMenuList(){
        List<MenuDto> list = menuService.selectMenuList();
        ResultView.displayMenuList(list);

    }

    public void selectSubCategoryList() {
        List<CategoryDto> list = menuService.selectSubCategoryList();
        ResultView.displayCategoryList(list);
    }

    public void selectMenuByMenuCode(String menuCode) {
        // 컨트롤러에서 가공처리
        MenuDto menu = menuService.selectMenuByMenuCode(Integer.parseInt(menuCode));
        ResultView.displayMenu(menu);
    }

    public void selectMenuListByCategoryCode(String categoryCode) {
        List<MenuDto> list = menuService.selectMenuListByCategoryCode(Integer.parseInt(categoryCode));
        ResultView.displayMenuList(list);
    }

    public void registMenu(Map<String, String> requestParm) {
        // Map을 menuDto로 바꿔서 보내줘야됨
        // 요청시 전달된 데이터 > MenuDto 옮기기

        // lombok 메소드 이용함
        MenuDto menu = MenuDto.builder()
                .menuName(requestParm.get("name"))
                .menuPrice(Integer.parseInt(requestParm.get("price")))
                .categoryCode(Integer.parseInt(requestParm.get("category")))
                .orderableStatus(requestParm.get("orderable"))
                .build();

        int result = menuService.registMenu(menu);
        ResultView.displayResult("메뉴등록", result);
    }

    public void modifyMenu(Map<String, String> requestParm) {
        MenuDto menu = MenuDto.builder()
                .menuCode(Integer.parseInt(requestParm.get("code")))
                .menuName(requestParm.get("name"))
                .categoryCode(Integer.parseInt(requestParm.get("category")))
                .orderableStatus(requestParm.get("orderable"))
                .build();


        int result = menuService.modifyMenu(menu);
        ResultView.displayResult("메뉴수정", result);

    }

    public void removeMenu(String menuCode) {
        int result = menuService.removeMenu(Integer.parseInt(menuCode));
        ResultView.displayResult("메뉴 삭제", result);
    }
}
