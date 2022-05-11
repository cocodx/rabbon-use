import org.junit.Test;

public class TestNull {

    @Test
    public void test(){
        Name name = new Name();
        Name name1 = new Name();
        if (name.getName().equals(name1)){
            System.out.println("null not exception");
        }else{
            System.out.println("null is exception");
        }
    }
}
class Name{
    private String name;
    private String var;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }
}
