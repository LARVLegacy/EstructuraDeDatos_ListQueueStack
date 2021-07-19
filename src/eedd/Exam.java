package eedd;

public class Exam {
    private String name;
    private double exam;
    private int group;

    public Exam(String name, int group) {
        this.name = name;
        this.group = group;
        exam = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExam() {
        return exam;
    }

    public void setExam(double exam) {
        this.exam = exam;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Exam{" + "name=" + name + ", exam=" + exam + ", group=" + group + '}';
    }
    
    
}
