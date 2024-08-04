package action;

import java.time.LocalDateTime;

public class Action {
    private int actionId;
    private LocalDateTime dateTime;
    private int lineNo;
    private String text;
    private boolean isAddition;
    public Action(int actionId, LocalDateTime dateTime, int lineNo, String text, boolean isAddition){
        this.actionId = actionId;
        this.dateTime = dateTime;
        this.lineNo = lineNo;
        this.text = text;
        this.isAddition = isAddition;
    }
    public void setActionId(int ac){
        this.actionId = ac;
    }
    public int getActionId(){
        return this.actionId;
    }
    public void setDateTime(LocalDateTime dt){
        this.dateTime = dt;
    }
    public LocalDateTime getDateTime(){
        return this.dateTime;
    }
    public void setLineNo(int n){
        this.lineNo = n;
    }
    public int getLineNo(){
        return this.lineNo;
    }
    public void setText(String txt){
        this.text = txt;
    }
    public String getText(){
        return this.text;
    }
    public void setIsAddition(boolean isadd){
        this.isAddition = isadd;
    }
    public boolean getIsAddition(){
        return this.isAddition;
    }
}
