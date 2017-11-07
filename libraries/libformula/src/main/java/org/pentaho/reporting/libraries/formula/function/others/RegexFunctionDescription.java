package org.pentaho.reporting.libraries.formula.function.others;

import org.pentaho.reporting.libraries.formula.function.AbstractFunctionDescription;
import org.pentaho.reporting.libraries.formula.function.FunctionCategory;
import org.pentaho.reporting.libraries.formula.typing.Type;
import org.pentaho.reporting.libraries.formula.typing.coretypes.LogicalType;
import org.pentaho.reporting.libraries.formula.typing.coretypes.TextType;

/**
 * Created by 陶鹏飞 on 2017/3/3.
 */
public class RegexFunctionDescription extends AbstractFunctionDescription{

    public RegexFunctionDescription(){
        //确保调用父构造函数，带上函数名和函数的资源包名
        super("REGEX","org.pentaho.reporting.libraries.formula.function.others.Regex-Function");
    }

    //把函数放到Others分类中
    @Override
    public FunctionCategory getCategory() {
        return OthersFunctionCategory.CATEGORY;
    }

    //函数返回2个参数
    @Override
    public int getParameterCount() {
        return 2;
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
        return TextType.TYPE;
    }

    @Override
    public Type getValueType() {
        return LogicalType.TYPE;
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
