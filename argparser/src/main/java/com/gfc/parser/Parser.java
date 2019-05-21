package com.gfc.parser;

/**
 * @ClassName: Parser
 * @Description:
 * @CreatedBy: xiaoguo
 * @CreatedAt: 2019/5/20 19:42
 **/
public interface Parser {
    public void parse(String cmd) throws ArgNotAllowedException, NotStartWithException;

    public ArgInfo getArg(String arg);
}
