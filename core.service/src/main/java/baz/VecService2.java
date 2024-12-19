package baz;

import foo.VecService;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

public class VecService2 implements VecService {
    private static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;

    @Override
    public void doSomething() {

    }
}
