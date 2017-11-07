package org.pentaho.reporting.libraries.formula.function.others;

        import org.pentaho.reporting.libraries.formula.function.AbstractFunctionCategory;
        import org.pentaho.reporting.libraries.formula.function.FunctionCategory;

/**
 * Created by 陶鹏飞 on 2017/3/6.
 */
public final class OthersFunctionCategory extends AbstractFunctionCategory {
    public static final FunctionCategory CATEGORY = new OthersFunctionCategory();

    private OthersFunctionCategory(){
        super("org.pentaho.reporting.libraries.formula.function.others.category");
    }
}
