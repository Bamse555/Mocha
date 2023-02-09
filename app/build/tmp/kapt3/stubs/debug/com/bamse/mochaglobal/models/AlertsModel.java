package com.bamse.mochaglobal.models;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/bamse/mochaglobal/models/AlertsModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/bamse/mochaglobal/repository/AlertsRepository;", "(Lcom/bamse/mochaglobal/repository/AlertsRepository;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "<set-?>", "Lcom/bamse/mochaglobal/ui/AlertState;", "state", "getState", "()Lcom/bamse/mochaglobal/ui/AlertState;", "setState", "(Lcom/bamse/mochaglobal/ui/AlertState;)V", "state$delegate", "Landroidx/compose/runtime/MutableState;", "loadAlerts", "", "app_debug"})
public final class AlertsModel extends androidx.lifecycle.ViewModel {
    private final com.bamse.mochaglobal.repository.AlertsRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState state$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "AlertsModel";
    
    @javax.inject.Inject()
    public AlertsModel(@org.jetbrains.annotations.NotNull()
    com.bamse.mochaglobal.repository.AlertsRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bamse.mochaglobal.ui.AlertState getState() {
        return null;
    }
    
    private final void setState(com.bamse.mochaglobal.ui.AlertState p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    public final void loadAlerts() {
    }
}