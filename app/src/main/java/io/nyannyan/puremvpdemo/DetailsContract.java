package io.nyannyan.puremvpdemo;

//MVP interface class

public interface DetailsContract {

  //Presenter > View
  interface View {

    void showMessage(String message);

  }

  //Presenter > Model
  //Model > Presenter
  interface Model {

    void setDetails(String firstName, String lastName);

    String getDetails();

  }


  interface Presenter {

    void loadMessage();

    void submitName(String firstName, String lastName);

  }

}
