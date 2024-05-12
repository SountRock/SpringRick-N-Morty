package com.example.HWSpring6RNM.controller.HTML;

import org.springframework.ui.Model;

public interface ControllersHTMLI {
    /**
     * Перейти в начало
     * @return mainPage
     */
    String getMainPage(Model model);

    /**
     * Перейти в на следующую страницу
     * @return nextPage
     */
    String getNextPage(Model model);

    /**
     * Перейти в на предыдущую страницу
     * @return prevPage
     */
    String getNextPrev(Model model);

    /**
     * Получить один результат по ссылке
     * @param href
     * @param model
     * @return resultPage
     */
    String getOne(String href, Model model);
}
