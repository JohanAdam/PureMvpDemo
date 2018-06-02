package io.nyannyan.puremvpdemo.root;

import android.app.Application;
import io.nyannyan.puremvpdemo.DetailsModule;

public class App extends Application {

  private ApplicationComponent applicationComponent;


  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    //Construct application component
    applicationComponent = DaggerApplicationComponent.builder()
        .detailsModule(new DetailsModule())
        .build();

  }
}
