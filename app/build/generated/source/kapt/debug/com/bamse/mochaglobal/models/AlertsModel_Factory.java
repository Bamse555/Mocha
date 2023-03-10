// Generated by Dagger (https://dagger.dev).
package com.bamse.mochaglobal.models;

import com.bamse.mochaglobal.repository.AlertsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AlertsModel_Factory implements Factory<AlertsModel> {
  private final Provider<AlertsRepository> repositoryProvider;

  public AlertsModel_Factory(Provider<AlertsRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AlertsModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static AlertsModel_Factory create(Provider<AlertsRepository> repositoryProvider) {
    return new AlertsModel_Factory(repositoryProvider);
  }

  public static AlertsModel newInstance(AlertsRepository repository) {
    return new AlertsModel(repository);
  }
}
