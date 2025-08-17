class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        try
        {
            int result = this.calc(operand1,operand2,operation);
            return String.format("%s %s %s = %s",operand1,operation,operand2,result);
        } catch (ArithmeticException e){
            throw new IllegalOperationException("Division by zero is not allowed",e);
        }
    }

    private int calc(int operand1, int operand2, String operation) {
        return switch(operation) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> {
                if(operand2 == 0){
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                yield operand1 / operand2;
            }
            case "" -> throw new IllegalArgumentException("Operation cannot be empty");
            case null -> throw new IllegalArgumentException("Operation cannot be null");
            default -> throw new IllegalOperationException(String.format("Operation '%s' does not exist",operation));
        };
    }
}
