package io.nyannyan.puremvpdemo;


public class DetailsPresenter implements DetailsContract.Presenter {

  private DetailsContract.View view;
  private DetailsContract.Model model;

  public DetailsPresenter(DetailsContract.View view) {
    this.view = view;
    model = new UserDataManager();
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
