package dk.via.broadcast.server;

import dk.via.broadcast.model.Expression;
import dk.via.broadcast.model.Result;

public class ServerModel {
    public Result compute(Expression e) {
        return switch(e.getOperator()) {
            case "+" -> new Result(e.getOperand1() + e.getOperand2(), e);
            case "-" -> new Result(e.getOperand1() - e.getOperand2(), e);
            default -> new Result(Double.NaN, e);
        };
    }
}
