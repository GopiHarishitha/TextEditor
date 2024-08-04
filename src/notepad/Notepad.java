package notepad;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import action.Action;

public class Notepad {
    private int id;
    private int capacity = 100;
    String notepad[];
    private Stack<Action> undoAction;
    private Stack<Action> redoAction;
    private Queue<String> clipBoard;

    public Notepad(int capacity){
        this.capacity = capacity;
        notepad = new String[capacity];
        for(int i=0;i<capacity;i++){
            notepad[i] = "";
        }
        undoAction = new Stack<Action>();
        redoAction = new Stack<Action>();
        clipBoard = new LinkedList<>();
    }
    
    public void display(){
        for(int i=0;i<notepad.length;i++){
            System.out.println(notepad[i]);
        }
    }

    public void display(int start, int end){
        if (start>end||end>capacity||start<0){
            System.out.println("Unable to display text, please check the input");
            return;
        }
        for(int i=start;i<end;i++){
            System.out.println(notepad[i]);
        }
    }

    public void insertLine(int lineNumber, String text){
        if (lineNumber>capacity){
            System.out.println("Notepad line crossed");
            return;
        }
        notepad[lineNumber-1] = text;
        undoAction.push(new Action(id++, LocalDateTime.now(), lineNumber, text, true));
    }

    public void delete(int lineNumber){
        if (lineNumber>capacity){
            System.out.println("No such row to delete");
            return;
        }
        if (notepad[lineNumber]==""){
            System.out.println("Nothing to delete");
            return;
        }
        redoAction.push(new Action(id++, LocalDateTime.now(), lineNumber, notepad[lineNumber-1], false));
        notepad[lineNumber-1] = "";
    }

    public void delete(int start, int end){
        if (start>end || end>capacity || start<0){
            System.out.println("Unable to delete, please check the input");
        }
        for(int i=start;i<end;i++){
            delete(i);
        }
    }

    public void insert(int start, int end, String text[]){
        if (start>end || end>capacity || start<0){
            System.out.println("Unable to insert, please check the input");
        }
        int k=0;
        for(int i=start;i<end;i++){
            insertLine(i, text[k++]);
        }
    }

    public void copy(int start, int end){
        if (start>end || end>capacity || start<0){
            System.out.println("Unable to copy, please check the input");
        }
        String copyText = "";
        for(int i=start;i<end;i++){
            copyText+=(notepad[i]+"\n");
        }
        if (copyText.isEmpty()){
            clipBoard.add(copyText);
        }
    }

    public void paste(int lineNumber){
        if (this.clipBoard.isEmpty()){
            System.out.println("Nothing to paste");
            return;
        }
        String text = clipBoard.peek();
        insertLine(lineNumber, text);
    }

    public void undo(){
        if(undoAction.isEmpty()){
            System.out.println("No operation is performed to undo");
        }
        Action action = undoAction.peek();
        this.undoAction.push(action);
        delete(action.getLineNo());
    }

    public void redo(){
        if(redoAction.isEmpty()){
            System.out.println("Nothing to redo");
            return;
        }
        Action action = redoAction.peek();
        this.redoAction.push(action);
        insertLine(action.getLineNo(), action.getText());
    }
}
