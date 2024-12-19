package foo;

public class VecServiceFactoryDefault implements VecServiceFactory {
  @Override
  public VecService get() {
    return new VecServiceDefaultImpl();
  }

  @Override
  public boolean isSupported() {
    return true;
  }
}
