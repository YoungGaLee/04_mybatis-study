package com.younggalee.section03.service;

import com.younggalee.section03.dao.MenuMapper;
import com.younggalee.section03.dto.CategoryDto;
import com.younggalee.section03.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.younggalee.section03.common.Template.getSqlSession;

public class MenuService {
    private MenuMapper menuMapper;

    public List<MenuDto> selectMenuList() {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.selectAllMenu();
        sqlSession.close();
        return list;
    }

    public List<CategoryDto> selectSubCategoryList() {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<CategoryDto> list = menuMapper.selectAllSubCategory();
        sqlSession.close();
        return list;
    }

    public MenuDto selectMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menu = menuMapper.selectMenuByMenuCode(menuCode);
        sqlSession.close();
        return menu;
    }

    public List<MenuDto> selectMenuListByCategoryCode(int categoryCode) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.selectMenuByCategoryCode(categoryCode);
        sqlSession.close();
        return list;
    }

    public int registMenu(MenuDto menu) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = 0;
        try {
            result = menuMapper.insertMenu(menu); // 예외발생될 수 있음
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally{
            sqlSession.close();
        }
        return result;
    }

    public int modifyMenu(MenuDto menu) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = 0;
        try {
            result = menuMapper.updateMenu(menu); // 예외발생될 수 있음
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally{
            sqlSession.close();
        }
        return result;
    }

    public int removeMenu(int code) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = 0;
        try {
            result = menuMapper.deleteMenu(code); // 예외발생될 수 있음
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally{
            sqlSession.close();
        }
        return result;
    }
}
