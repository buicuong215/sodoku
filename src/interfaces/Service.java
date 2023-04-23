package interfaces;

import models.Player;

import java.util.List;

public interface Service<T> {
    List<T> findAll();
    boolean save(T object);
}
