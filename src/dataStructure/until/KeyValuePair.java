package dataStructure.until;

public class KeyValuePair {
    String key;
    Object value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public KeyValuePair(String key, Object value) {
        this.key = key;
        this.value = value;
    }
    public KeyValuePair() {}

    @Override
    public String toString() {
        return "KeyValuePair{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
