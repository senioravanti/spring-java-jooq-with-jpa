package ru.manannikov.jooqjpa.utils;

import jakarta.persistence.EntityManager;
import org.jooq.Param;
import org.jooq.Query;

import java.util.List;

public class JpaUtils {
    public static <E> List<E> nativeQuery(
        EntityManager em, Query query,
        Class<E> type
    ) {
        jakarta.persistence.Query r = em.createNativeQuery(query.getSQL(), type);
        int i = 1;
        for (var p : query.getParams().values()) {
            if (!p.isInline()) {
                r.setParameter(i++, convertToDatabaseType(p));
            }
        }
        return r.getResultList();
    }

    private static <T> Object convertToDatabaseType(Param<T> param) {
        return param.getBinding().converter().to(param.getValue());
    }
}
