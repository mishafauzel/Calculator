package com.mishafauzel.calculator.utills;
// утилитный(утилитарный?) который позволяет передать результаты выполнения из рабочих классов в контроллер интерфейса
public class DataState<V> {
    public final boolean isLoading;
    public final V data;
    public final String errorMessage;

    private DataState(boolean isLoading, V data, String errorMessage) {
        this.isLoading = isLoading;
        this.data = data;
        this.errorMessage = errorMessage;
    }
    public static<V> DataState data( V data)
    {
        return new DataState(false,data,null);
    }
    public static DataState error(String errorMessage)
    {
        return new DataState(false,null,errorMessage);
    }
    public static DataState calculating()
    {
        return new DataState(true,null,null);
    }

}
