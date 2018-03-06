package ru.bellintegrator.myProject.office.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.myProject.office.dao.OfficeDAO;
import ru.bellintegrator.myProject.office.model.Office;
import ru.bellintegrator.myProject.office.service.OfficeService;
import ru.bellintegrator.myProject.office.view.OfficeView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OfficeServiceImpl implements OfficeService {

    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);

    private final OfficeDAO dao;

    @Autowired
    public OfficeServiceImpl(OfficeDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void add(OfficeView view) {
        Office office = new Office(view.name, view.adress);
        dao.save(office);
    }


    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> offices() {
        List<Office> all = dao.all();

        Function<Office, OfficeView> mapPerson = o -> {
            OfficeView view = new OfficeView();
            view.id = String.valueOf(o.getId());
            view.name = o.getName();
            view.adress = o.getAdress();

            log.info(view.toString());

            return view;
        };

        return all.stream()
                .map(mapPerson)
                .collect(Collectors.toList());
    }


}
