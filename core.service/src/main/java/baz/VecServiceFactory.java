package baz;

import foo.VecService;
import foo.VecServiceDefaultImpl;

import java.util.Optional;

public class VecServiceFactory implements foo.VecServiceFactory {
  @Override
  public VecService get() {
    return new VecServiceDefaultImpl();
  }

  @Override
  public boolean isSupported() {
    return lookupVectorModule().isPresent();
  }

  private Optional<Module> lookupVectorModule() {
    return Optional.ofNullable(this.getClass().getModule().getLayer())
        .orElse(ModuleLayer.boot())
        .findModule("jdk.incubator.vector");
  }
}
