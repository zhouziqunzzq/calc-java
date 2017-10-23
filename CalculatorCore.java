package Calculator;

public class CalculatorCore {
    private double dBuffer;
    private StringBuilder sBuffer;
    private StringBuilder lastOP;
    public CalculatorCore() {
        dBuffer = 0.0;
        sBuffer = new StringBuilder("");
        lastOP = new StringBuilder("");
    }
    public String GetSBuffer() {
        return sBuffer.toString();
    }
    private void ClearSBuffer() {
        sBuffer.delete(0, sBuffer.length());
    }
    private void ClearLastOP() {
        lastOP.delete(0, sBuffer.length());
    }
    private void ClearAll() {
        ClearSBuffer();
        dBuffer = 0.0;
        ClearLastOP();
    }
    private void HandleSingleOperator(String op) {
        if (op.equals("√")) {
            String t = Double.toString(Math.sqrt(Double.valueOf(sBuffer.toString())));
            ClearSBuffer();
            sBuffer.append(t);
        } else if (op.equals("x²")) {
            String t = Double.toString(Math.pow(Double.valueOf(sBuffer.toString()), 2));
            ClearSBuffer();
            sBuffer.append(t);
        } else if (op.equals("1/x")) {
            String t = Double.toString(1.0 / Double.valueOf(sBuffer.toString()));
            ClearSBuffer();
            sBuffer.append(t);
        }
    }
    private void HandleDoubleOperator(String op) {
        if (op.equals("")) {
            dBuffer = Double.valueOf(sBuffer.toString());
        } else if (op.equals("+")) {
            dBuffer += Double.valueOf(sBuffer.toString());
        } else if (op.equals("-")) {
            dBuffer -= Double.valueOf(sBuffer.toString());
        } else if (op.equals("×")) {
            dBuffer *= Double.valueOf(sBuffer.toString());
        } else if (op.equals("÷")) {
            dBuffer /= Double.valueOf(sBuffer.toString());
        }
    }
    private void HandleCommand(String c) {
        if (c.equals("  C  ") || c.equals(" CE ")) {
            ClearAll();
            sBuffer.append("0");
        } else if (c.equals("Del")) {
            if (sBuffer.length() == 1) {
                ClearSBuffer();
                sBuffer.append("0");
            } else {
                sBuffer.deleteCharAt(sBuffer.length() - 1);
            }
        } else if (c.equals("±")) {
            if (sBuffer.charAt(0) == '-') {
                sBuffer.deleteCharAt(0);
            } else {
                sBuffer.insert(0, "-");
            }
        } else if (c.equals("=")) {
            HandleDoubleOperator(lastOP.toString());
            ClearLastOP();
            ClearSBuffer();
            sBuffer.append(Double.toString(dBuffer));
        }
    }
    public void HandleButtonClick(CalculatorEvent e) {
        switch (e.Type) {
            case NUMBER:
                if (!e.Content.equals(".") && sBuffer.toString().equals("0"))
                    sBuffer.setCharAt(0, e.Content.charAt(0));
                else
                    sBuffer.append(e.Content);
                break;
            case SINGLEOPERATOR:
                HandleSingleOperator(e.Content);
                break;
            case DOUBLEOPERATOR:
                HandleDoubleOperator(lastOP.toString());
                ClearLastOP();
                lastOP.append(e.Content);
                ClearSBuffer();
                sBuffer.append("0");
                break;
            case COMMAND:
                HandleCommand(e.Content);
                break;
        }
    }
}
