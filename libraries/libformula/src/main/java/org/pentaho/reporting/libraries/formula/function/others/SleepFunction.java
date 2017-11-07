package org.pentaho.reporting.libraries.formula.function.others;

import org.pentaho.reporting.libraries.formula.EvaluationException;
import org.pentaho.reporting.libraries.formula.FormulaContext;
import org.pentaho.reporting.libraries.formula.LibFormulaErrorValue;
import org.pentaho.reporting.libraries.formula.function.Function;
import org.pentaho.reporting.libraries.formula.function.ParameterCallback;
import org.pentaho.reporting.libraries.formula.lvalues.TypeValuePair;
import org.pentaho.reporting.libraries.formula.typing.Type;
import org.pentaho.reporting.libraries.formula.typing.coretypes.LogicalType;

/**
 * Created by 陶鹏飞 on 2017/3/3.
 */
public class SleepFunction implements Function {

    private  static  final long serialVersionUID = 4984027687466610131L;
    private  static  final TypeValuePair RETURN_INTERRUPTED = new TypeValuePair( LogicalType.TYPE, Boolean.FALSE );
    private  static  final TypeValuePair RETURN_UNINTERRUPTED = new TypeValuePair(LogicalType.TYPE,Boolean.TRUE);

    public SleepFunction(){
        // Constructor
    }

    @Override
    /* (non-Javadoc)
   * @see org.pentaho.reporting.libraries.formula.function.Function#getCanonicalName()
   */
    public String getCanonicalName() {
        return "SLEEP";
    }

    @Override
    /* (non-Javadoc)
   * @see org.pentaho.reporting.libraries.formula.function.Function#evaluate(org.pentaho.reporting.libraries.formula.FormulaContext, org.pentaho.reporting.libraries.formula.function.ParameterCallback)
   */
    public TypeValuePair evaluate(FormulaContext context, ParameterCallback parameters) throws EvaluationException {
        final  int parameterCount = parameters.getParameterCount();
        if ( parameterCount < 1 ){
            throw new EvaluationException(LibFormulaErrorValue.ERROR_ARGUMENTS_VALUE);
        }
        final Type type1 = parameters.getType(0);
        final Object value1 = parameters.getValue(0);
        final Number result = context.getTypeRegistry().convertToNumber(type1,value1);
        if ( result == null || (result.intValue() < 0) ){
            throw new EvaluationException(LibFormulaErrorValue.ERROR_INVALID_ARGUMENT_VALUE);
        }
        Boolean  sleepInterrupted = false;
        // The number should be the number of milliseconds to sleep
        try {
            Thread.sleep(result.intValue());
        } catch (InterruptedException e) {
            //e.printStackTrace();
            sleepInterrupted = true;
        }
        // Whether the function was interrupted or completed.
        return sleepInterrupted ? RETURN_INTERRUPTED : RETURN_UNINTERRUPTED;
    }

}
