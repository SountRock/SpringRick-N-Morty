package com.example.HWSpring6RNM.service;

import com.example.HWSpring6RNM.domain.ModelsListI;
import com.example.HWSpring6RNM.domain.ResultI;
import com.example.HWSpring6RNM.domain.character.CharacterResult;
import com.example.HWSpring6RNM.service.Impl.CharacterServiceApi;

public interface ServiceApiI {
    /**
     * Перейти в начало
     * @return results
     */
    ModelsListI getAllMain();

    /**
     * Перейти в на следующую страницу
     * @return results
     */
    ModelsListI getNextAll();

    /**
     * Перейти в на предыдущую страницу
     * @return results
     */
    ModelsListI getPrevAll();

    /**
     * Обновить ссылки на следующую и предыдущию страницы
     * @param domain
     * @param service
     */
    default void updatePagesVars(ModelsListI domain, ServiceApiI service) {
        service.setNextPage(domain.getInfo().getNext());
        service.setPrevPage(domain.getInfo().getPrev());
    }

    /**
     * Установить ссылку на следующую страницу
     * @param nextPage
     */
    void setNextPage(String nextPage);

    /**
     * Установить ссылку на предыдущую страницу
     * @param prevPage
     */
    void setPrevPage(String prevPage);

    /**
     * Получить имя сервиса
     * @return
     */
    String getServiceName();

    /**
     * Получить один результат по ссылке
     * @param href
     * @return result
     */
    ResultI getOne(String href);
}
