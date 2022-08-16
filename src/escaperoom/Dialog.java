package escaperoom;

public class Dialog {
    private final String itemReaction;
    private final boolean needAnswer;
    private String answer;

    public Dialog(String itemReaction) {
        this.itemReaction = itemReaction;
        this.needAnswer = false;
    }

    public Dialog(String itemReaction, boolean needAnswer) {
        this.itemReaction = itemReaction;
        this.needAnswer = needAnswer;
    }

    public String getItemReaction() {
        return itemReaction;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isNeedAnswer() {
        return needAnswer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
