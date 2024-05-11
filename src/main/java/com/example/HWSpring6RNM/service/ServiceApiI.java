package com.example.HWSpring6RNM.service;

import com.example.HWSpring6RNM.domain.ModelsListI;
import com.example.HWSpring6RNM.service.Impl.CharacterServiceApi;

public interface ServiceApiI {
    /**
     * Перейти в начало
     * @return result
     */
    ModelsListI getAllMain();

    /**
     * Перейти в на следующую страницу
     * @return result
     */
    ModelsListI getNextAll();

    /**
     * Перейти в на предыдущую страницу
     * @return result
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
}
