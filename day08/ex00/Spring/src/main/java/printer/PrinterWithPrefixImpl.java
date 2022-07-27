package printer;

import renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer<String> {

    private Renderer renderer;

    private String prefix;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
        this.prefix = "";
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void print(String message) {
        renderer.sendToConsole(this.prefix + " " + message);
    }
}
