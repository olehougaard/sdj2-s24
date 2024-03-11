package dk.via.calculator.server;

import dk.via.calculator.model.Expression;
import dk.via.calculator.model.Result;

public class Model {
    public Result compute(Expression e) {
        return switch(e.getOperator()) {
            case "+" -> new Result(e.getOperand1() + e.getOperand2());
            case "-" -> new Result(e.getOperand1() - e.getOperand2());
            case "*" -> new Result(e.getOperand1() * e.getOperand2());
            case "/" -> new Result(e.getOperand1() / e.getOperand2());
            default -> new Result(Double.NaN);
        };
    }
}
