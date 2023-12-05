import org.testng.annotations.Test;

public class test {

    @Test
    public void main(){

        String x = "Account Balance: $105.27";
        System.out.println(x.substring(0, x.indexOf("$")));
        System.out.println(x.substring(x.indexOf("$") + 1));
    }

}
