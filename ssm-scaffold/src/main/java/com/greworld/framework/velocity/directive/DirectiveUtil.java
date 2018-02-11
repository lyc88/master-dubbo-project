package com.greworld.framework.velocity.directive;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;

/**
 * @author 风骚的GRE
 * @Description DirectiveUtil
 * @date 2018/1/29.
 */
public class DirectiveUtil {
    static String BLOCK = "__vm_override__";

    static String OVERRIDE_CURRENT_NODE = "__vm_current_override_node__";


    static String getOverrideVariableName( String name ) {
        return BLOCK + name;
    }


    static String getRequiredArgument(InternalContextAdapter context, Node node, int argumentIndex, String directive )
            throws ParseErrorException {
        SimpleNode sn_value = (SimpleNode) node.jjtGetChild(argumentIndex);
        if ( sn_value == null ) {
            throw new ParseErrorException(
                    "required argument is null with directive:#" + directive + "(),argumentIndex=" + argumentIndex);
        }

        String value = (String) sn_value.value(context);
        if ( value == null ) {
            throw new ParseErrorException(
                    "required argument is null with directive:#" + directive + "(),argumentIndex=" + argumentIndex);
        }
        return value;
    }


    public static void setParentForTop(OverrideDirective.OverrideNodeWrapper topParentNode, OverrideDirective.OverrideNodeWrapper node ) {
        OverrideDirective.OverrideNodeWrapper top = node;
        while ( top.parentNode != null ) {
            top = top.parentNode;
        }
        top.parentNode = topParentNode;
    }
}
