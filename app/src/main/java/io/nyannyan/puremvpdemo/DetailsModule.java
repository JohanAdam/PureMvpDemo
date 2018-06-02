package io.nyannyan.puremvpdemo;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class DetailsModule {

  @Provides @Singleton
  public DetailsContract.Model provideDetailsContactModel() {
    return new UserDataManager();
  }

  @Provides @Singleton
  public DetailsContract.Presenter providesDetailContractPresenter(DetailsContract.Model model) {
    return new DetailsPresenter(model);
  }

}
