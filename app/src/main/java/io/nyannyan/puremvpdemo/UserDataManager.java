package io.nyannyan.puremvpdemo;

public class UserDataManager implements DetailsContract.Model{

  private User user;

  public UserDataManager() {
  }

  @Override
  public void setDetails(String firstName, String lastName) {
    user = new User(firstName, lastName);
  }

  @Override
  public String getDetails() {
    return "Details : " + user.getFirstName() + " " + user.getLastName();
  }
}
