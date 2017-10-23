package Calculator;

public class CalculatorEvent {
    public EventType Type;
    public String Content;
    public enum EventType {
        NUMBER,
        SINGLEOPERATOR,
        DOUBLEOPERATOR,
        COMMAND
    }

    public CalculatorEvent(EventType t, String c) {
        this.Type = t;
        this.Content = c;
    }
}
