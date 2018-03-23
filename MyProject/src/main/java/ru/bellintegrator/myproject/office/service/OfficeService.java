package ru.bellintegrator.myproject.office.service;

import ru.bellintegrator.myproject.office.view.OfficeResponseView;
import ru.bellintegrator.myproject.office.view.OfficeView;

import java.util.List;

public interface OfficeService {

    /**
     * Organization service method
     * @return {@Office}
     */
    List<OfficeView> all();

    OfficeResponseView getOfficeById(String id);

    OfficeResponseView update(OfficeView view);

    OfficeResponseView save(OfficeView view);

    OfficeResponseView delete(String id);

}
