package io.nyannyan.puremvpdemo.root;

import dagger.Component;
import io.nyannyan.puremvpdemo.DetailsModule;
import io.nyannyan.puremvpdemo.MainActivity;
import javax.inject.Singleton;

@Singleton
@Component(modules = {DetailsModule.class})
public interface ApplicationComponent {

  void inject(MainActivity mainActivity);
}
