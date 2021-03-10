package com.anabneri.messagingsystem.notfication.model;

import com.anabneri.messagingsystem.notfication.config.UtilBean;
import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.MANDATORY;


import java.lang.reflect.Type;

public class ListenerAuditRegistration {

    @PrePersist
    public void onPrePersist(Registration registration) {
        audit(TypeEnum.INSERT, registration);
    }

    @PreUpdate
    public void onPreUpdate(Registration registration) {
        audit(TypeEnum.UPDATE, registration);
    }

    @Transactional(MANDATORY)
    private void audit(Type type, Registration subscription) {
        HistoryEvent eventHistory = HistoryEvent.builder()
                .type(type)
                .subscriptionId(subscription)
                .build();

        EntityManager entityManager = UtilBean.getBean(EntityManager.class);
        entityManager.persist(eventHistory);
    }


}
