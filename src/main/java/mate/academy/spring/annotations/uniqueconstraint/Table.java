package mate.academy.spring.annotations.uniqueconstraint;

public @interface Table {
    /**
     * (Optional) Unique constraints that are to be placed on
     * the table. These are only used if table generation is in
     * effect. These constraints apply in addition to any constraints
     * specified by the <code>Column</code> and <code>JoinColumn</code>
     * annotations and constraints entailed by primary key mappings.
     * <p> Defaults to no additional constraints.
     */
    UniqueConstraint[] uniqueConstraints() default {};
}
