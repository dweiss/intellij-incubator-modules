package foo;

import java.util.ServiceLoader;

public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("Hello.");
    ServiceLoader<VecServiceFactory> loader = ServiceLoader.load(VecServiceFactory.class);
    try (var stream = loader.stream()) {
      stream.forEach(
          prov -> {
            System.out.println("Factory: " + prov.type().getName());
            var factory = prov.get();
            if (factory.isSupported()) {
              System.out.println("  supported.");
              factory.get().doSomething();
            } else {
              System.out.println("  not supported.");
            }
          });
    }
  }
}
