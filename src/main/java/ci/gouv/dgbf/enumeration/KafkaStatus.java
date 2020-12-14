package ci.gouv.dgbf.enumeration;

public enum KafkaStatus {
    COMMITTED("COMMITTED"),
    PENDING("PENDING"),
    DELETED("DELETED");

    private final String value;

    public String getValue() {
        return value;
    }

    KafkaStatus(String value) {
        this.value = value;
    }
}
