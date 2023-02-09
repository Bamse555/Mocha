package com.bamse.mochaglobal.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/bamse/mochaglobal/repository/AlertsRepositoryImpl;", "Lcom/bamse/mochaglobal/repository/AlertsRepository;", "api", "Lcom/bamse/mochaglobal/api/AlertsApi;", "(Lcom/bamse/mochaglobal/api/AlertsApi;)V", "getAlertsData", "Lcom/bamse/mochaglobal/util/ApiResponse;", "Lcom/bamse/mochaglobal/alerts/AlertInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImages", "Lretrofit2/Call;", "", "app_release"})
public final class AlertsRepositoryImpl implements com.bamse.mochaglobal.repository.AlertsRepository {
    private final com.bamse.mochaglobal.api.AlertsApi api = null;
    
    @javax.inject.Inject()
    public AlertsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.bamse.mochaglobal.api.AlertsApi api) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getAlertsData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.bamse.mochaglobal.util.ApiResponse<com.bamse.mochaglobal.alerts.AlertInfo>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getImages(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<java.lang.String>> continuation) {
        return null;
    }
}