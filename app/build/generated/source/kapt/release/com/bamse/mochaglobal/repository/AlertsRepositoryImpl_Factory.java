// Generated by Dagger (https://dagger.dev).
package com.bamse.mochaglobal.repository;

import com.bamse.mochaglobal.api.AlertsApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AlertsRepositoryImpl_Factory implements Factory<AlertsRepositoryImpl> {
  private final Provider<AlertsApi> apiProvider;

  public AlertsRepositoryImpl_Factory(Provider<AlertsApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public AlertsRepositoryImpl get() {
    return newInstance(apiProvider.get());
  }

  public static AlertsRepositoryImpl_Factory create(Provider<AlertsApi> apiProvider) {
    return new AlertsRepositoryImpl_Factory(apiProvider);
  }

  public static AlertsRepositoryImpl newInstance(AlertsApi api) {
    return new AlertsRepositoryImpl(api);
  }
}
