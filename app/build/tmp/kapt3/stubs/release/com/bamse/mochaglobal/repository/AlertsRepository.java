package com.bamse.mochaglobal.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/bamse/mochaglobal/repository/AlertsRepository;", "", "getAlertsData", "Lcom/bamse/mochaglobal/util/ApiResponse;", "Lcom/bamse/mochaglobal/alerts/AlertInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImages", "Lretrofit2/Call;", "", "app_release"})
public abstract interface AlertsRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAlertsData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.bamse.mochaglobal.util.ApiResponse<com.bamse.mochaglobal.alerts.AlertInfo>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getImages(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<java.lang.String>> continuation);
}