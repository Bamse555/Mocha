package com.bamse.mochaglobal.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/bamse/mochaglobal/api/AlertsApi;", "", "getAlertsData", "Lcom/bamse/mochaglobal/api/Alert;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImages", "Lretrofit2/Call;", "", "app_release"})
public abstract interface AlertsApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "alerts/active?status=actual&message_type=alert")
    public abstract java.lang.Object getAlertsData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.bamse.mochaglobal.api.Alert> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "https://picsum.photos/1000")
    public abstract retrofit2.Call<java.lang.String> getImages();
}