package io.nyannyan.puremvpdemo;


import io.nyannyan.puremvpdemo.DetailsContract.View;

public class DetailsPresenter implements DetailsContract.Presenter {

  private DetailsContract.View view;
  private DetailsContract.Model model;

//  public DetailsPresenter(DetailsContract.View view) {
//    this.view = view;
//    model = new UserDataManager();
//  }

  public DetailsPresenter(DetailsContract.Model model) {
    this.model = model;
  }

  @Override
  public void setView(View view) {
    this.view = view;
  }

  @Override
  public void loadMessage() {
    view.showMessage(model.getDetails());
  }

  @Override
  public void submitName(String firstName, String lastName) {
    model.setDetails(firstName, lastName);
  }
}
