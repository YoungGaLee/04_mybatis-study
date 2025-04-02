package com.younggalee.section03.view;

import com.younggalee.section03.dto.CategoryDto;
import com.younggalee.section03.dto.MenuDto;

import java.awt.*;
import java.util.List;

public class ResultView {
    //출력화면제작(조회된 메뉴 목록을 출력해주는 화면)
    public static void displayMenuList(List<MenuDto> list){
        if (list.isEmpty()){
            System.out.println("조회된 메뉴가 없습니다.");
        } else {
            for (MenuDto menu : list){
                System.out.printf("%d\t 메뉴명 : %s\t %d원\t%d\t%s\n", menu.getMenuCode(), menu.getMenuName(), menu.getMenuPrice(), menu.getCategoryCode(), menu.getOrderableStatus());
            }
        }
    }

    // 카테고리목록을 출력해주는 화면
    public static void displayCategoryList(List<CategoryDto> list){
        for (CategoryDto category : list){
            System.out.printf("%d. %s " ,category.getCategoryCode(),category.getCategoryName());
        }
        System.out.println();
    }

    // 한건의 메뉴정보를 출력해주는 화면
    public static void displayMenu(MenuDto menu){
        if (menu == null){
            System.out.println("조회된 메뉴가 없습니다.");
        } else {
            System.out.println("-------메뉴정보---------");
            System.out.println("code : " + menu.getMenuCode());
            System.out.println("name : " + menu.getMenuName());
            System.out.println("Price : " + menu.getMenuPrice() + "원");
            System.out.println("Category : " + menu.getCategoryCode());
            System.out.println("Orderable : " + ("Y".equals(menu.getOrderableStatus()) ? "주문가능" : "주문불가"));
            System.out.println("----------------------");
        }
    }
    // 등록, 수정, 삭제 오청시 결과를 출력해주는 화면
    //처리된 '행수' 및 어떤 서비스에 대한 결과값인지 '타입' 넘겨줌
    public static void displayResult(String type, int result){ // type: "메뉴 등록" | "메뉴 수정" | "메뉴 삭제"
        System.out.println(type + (result > 0 ? "성공" : "실패"));
    }

}
