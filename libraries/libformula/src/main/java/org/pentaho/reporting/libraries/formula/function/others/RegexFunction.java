package org.pentaho.reporting.libraries.formula.function.others;

import org.pentaho.reporting.libraries.formula.EvaluationException;
import org.pentaho.reporting.libraries.formula.FormulaContext;
import org.pentaho.reporting.libraries.formula.LibFormulaErrorValue;
import org.pentaho.reporting.libraries.formula.function.Function;
import org.pentaho.reporting.libraries.formula.function.ParameterCallback;
import org.pentaho.reporting.libraries.formula.lvalues.TypeValuePair;
import org.pentaho.reporting.libraries.formula.typing.TypeRegistry;
import org.pentaho.reporting.libraries.formula.typing.coretypes.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 陶鹏飞 on 2017/3/3.
 */
public class RegexFunction implements Function{
    @Override
    public String getCanonicalName() {
        return "REGEX";
    }

    @Override
    public TypeValuePair evaluate(FormulaContext context, ParameterCallback parameters) throws EvaluationException {
        if ( parameters.getParameterCount() != 2 ){
            throw new EvaluationException(LibFormulaErrorValue.ERROR_ARGUMENTS_VALUE);
        }
        final TypeRegistry  typeRegistry = context.getTypeRegistry();
        final String param1 = typeRegistry.convertToText( parameters.getType(0), parameters.getValue(0) );
        final String param2 = typeRegistry.convertToText( parameters.getType(1), parameters.getValue(1) );
        try {
            final Pattern pattern = Pattern.compile(param1);
            final Matcher matcher = pattern.matcher(param2);
            matcher.find();
            return new TypeValuePair(TextType.TYPE, matcher.group(1));
        }catch (Exception e){
            return new TypeValuePair(TextType.TYPE,e.getMessage());
        }

    }
}
