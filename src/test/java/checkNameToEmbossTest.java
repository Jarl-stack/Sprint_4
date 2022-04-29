import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class checkNameToEmbossTest {

    private final String name;
    private final boolean expected;

    public checkNameToEmbossTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNameTest() {
        return new Object[][]{
                {"", false},
                {" ", false},
                {"qw", false},
                {"SashaSash SashaSasha", false},
                {" Sasha", false},
                {"Sasha ", false},
                {"Sasha Ivanov Masha", false},
                {"Basilio", false},
                {"Bill Gates", true},
                {"T R", true},
                {"Sasha SashaSashaBob", true}
        };
    }

    @Test
    public void shouldCheckNameToRequirements() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();

        assertEquals("Все пропало", expected, actual);
    }
}




