package org.pentaho.reporting.libraries.formula.function.others;

import org.pentaho.reporting.libraries.formula.function.AbstractFunctionDescription;
import org.pentaho.reporting.libraries.formula.function.FunctionCategory;
import org.pentaho.reporting.libraries.formula.function.information.InformationFunctionCategory;
import org.pentaho.reporting.libraries.formula.typing.Type;
import org.pentaho.reporting.libraries.formula.typing.coretypes.LogicalType;
import org.pentaho.reporting.libraries.formula.typing.coretypes.NumberType;

/**
 * Created by 陶鹏飞 on 2017/3/3.
 */
public class SleepFunctionDescription extends AbstractFunctionDescription {

    private static  final long serialVersionUID = 2368106667495213328L;

    public SleepFunctionDescription() {
        super("SLEEP", "org.pentaho.reporting.libraries.formula.function.others.Sleep-Function");
    }

    @Override
    public Type getValueType() {
        return LogicalType.TYPE;
    }

    @Override
    public FunctionCategory getCategory() {
        return OthersFunctionCategory.CATEGORY;
    }

    @Override
    public int getParameterCount() {
        return 1;       // 1 Parameter - number of milliseconds
    }

    /**
     * Returns the parameter type at the given position using the function metadata. The first parameter is at the
     * position 0;
     *
     * @param position The parameter index.
     * @return The parameter type.
     */
    @Override
    public Type getParameterType(int position) {
        return NumberType.GENERIC_NUMBER;
    }

    /**
     * Defines, whether the parameter at the given position is mandatory. A mandatory parameter must be filled in, while
     * optional parameters need not to be filled in.
     *
     * @param position
     * @return
     */
    @Override
    public boolean isParameterMandatory(int position) {
        return true;
    }
}
