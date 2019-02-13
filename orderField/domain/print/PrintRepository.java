package com.printhouse.orderField.domain.print;

public interface PrintRepository {
    public Print load(Long id);
    public void save(Print print);
}
