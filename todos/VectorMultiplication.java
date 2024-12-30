import java.lang.foreign.Arena;
import java.util.Optional;

public class VectorMultiplication {

    /**
     * Looks up the vector module from Lucene's {@link ModuleLayer} or the root layer (if unnamed).
     */
    private static Optional<Module> lookupVectorModule() {
        return Optional.ofNullable(VectorMultiplication.class.getModule().getLayer())
                .orElse(ModuleLayer.boot())
                .findModule("jdk.incubator.vector");
    }

    public static void main(String[] args) {
        final var vectorMod = lookupVectorModule();
        if (vectorMod.isEmpty()) {
            System.out.println("jdk.incubator.vector module not available.");
            System.exit(0);
        }

        // add the module to the module graph manually.
        vectorMod.ifPresent(VectorMultiplication.class.getModule()::addReads);

        try (var arena = Arena.ofConfined()) {
            var seg = arena.allocate(10);
            System.out.println("Seg: " + seg);
        }

        ImplClass.main(args);
    }
}
