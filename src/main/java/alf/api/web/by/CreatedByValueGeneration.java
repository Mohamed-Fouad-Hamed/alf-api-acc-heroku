package alf.api.web.by;

import alf.api.web.security.services.UserService;
import org.hibernate.tuple.AnnotationValueGeneration;
import org.hibernate.tuple.GenerationTiming;
import org.hibernate.tuple.ValueGenerator;

public class CreatedByValueGeneration implements
        AnnotationValueGeneration<CreatedBy> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final ByValueGenerator generator = new ByValueGenerator(new UserService());

    @Override
    public void initialize(CreatedBy mby, Class<?> clazz) {
    }

    @Override
    public GenerationTiming getGenerationTiming() {
        return GenerationTiming.INSERT;
    }

    @Override
    public ValueGenerator<?> getValueGenerator() {
        return generator;
    }

    @Override
    public boolean referenceColumnInSql() {
        return false;
    }

    @Override
    public String getDatabaseGeneratedReferencedColumnValue() {
        return null;
    }
}