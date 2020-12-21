public abstract class Operation {

    public Operation successor;
    final String REGEX = "(\\d*)\\s*(\\W?)\\s*(\\d*)";

    public Operation(Operation successor) {
        this.successor=successor;
    }

    public abstract String handle(String text);
}
