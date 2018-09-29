package com.library.dao;


import java.lang.reflect.ParameterizedType;

/**
 * 所有DAO的基类，通过继承加反射实现获取泛型T.class
 * 通过不带有泛型的子类继承带有泛型父类实现子类的泛型化
 * 子类通过super()调用父类构造中的getClass()方法获取子类Class
 *
 * @param <T>
 */
public abstract class BasicDAO<T>
{
    private Class<T> entityClass;

    public BasicDAO()
    {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getEntityClass()
    {
        return entityClass;
    }
    public abstract boolean save(T t);
}
