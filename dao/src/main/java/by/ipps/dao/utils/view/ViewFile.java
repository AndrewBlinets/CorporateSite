package by.ipps.dao.utils.view;

public class ViewFile {
  interface Base {}

  interface BaseRealize {}

  public static class BaseClass implements Base {}

  public static class BaseClassRealize implements Base {}

  public static class FileClass implements ViewDocumentForCustomer.File {}
}
