package io.github.dmv04;
import static org.junit.Assert.assertEquals;
import static io.github.dmv04.Autocompletor.autocompletion;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class AutocompletorTest {
    @Test
    public void testAutocompletion() {

        ByteArrayInputStream in = new ByteArrayInputStream(
                "5\nkare 10\nkanojo 20\nkaretachi 1\nkorosu 7\nsakura 3\n3\nk\nka\nkar".getBytes());
        InputStream inputStream = System.in; // сохраняем ссылку на ввод с клавиатуры
        System.setIn(in); // подменяем ввод

        var expected = "kanojo\nkare\nkorosu\nkaretachi\n\nkanojo\nkare\nkaretachi\n\nkare\nkaretachi";

        assertEquals(expected, autocompletion());
        System.setIn(inputStream);

    }

    @Test
    public void testAutocompletionAlpabetSorting() {

        String str = "5\n" +
                "karetacha 1\n" +
                "karetachb 1\n" +
                "karetachc 1\n" +
                "karetachd 1\n" +
                "karetachi 1\n" +
                "1\n" +
                "k";

        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
        InputStream inputStream = System.in; // сохраняем ссылку на ввод с клавиатуры
        System.setIn(in); // подменяем ввод

        var expected = "karetacha\n" +
                "karetachb\n" +
                "karetachc\n" +
                "karetachd\n" +
                "karetachi";

        assertEquals(expected, autocompletion());
        System.setIn(inputStream);

    }
}
