package mate.academy.spring.validators.uniqueconstraint;

public @interface UniqueConstraint {
    /** (Optional) Constraint name.  A provider-chosen name will be chosen
     * if a name is not specified.
     *
     * @since Java Persistence 2.0
     */
    String name() default "";

    /** (Required) An array of the column names that make up the constraint. */
    String[] columnNames();
}
