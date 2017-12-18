package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    private boolean bool;

    public JsonBoolean(Boolean inputBool) {
        this.bool = inputBool;
    }

    public boolean isBool() {
        return bool;
    }

    @Override
    public String toJson() {
        return String.valueOf(isBool());
    }
}
