import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class DocSearchTest {
    @Test
    public void testBasePair() throws IOException, URISyntaxException {
        String expected = "There are 76 files found: .\\technical\\biomed\\1471-2091-3-4.txt, .\\technical\\biomed\\1471-2105-2-8.txt, .\\technical\\biomed\\1471-2105-2-9.txt, .\\technical\\biomed\\1471-2105-3-18.txt, .\\technical\\biomed\\1471-2105-3-2.txt, .\\technical\\biomed\\1471-2105-3-24.txt, .\\technical\\biomed\\1471-2105-4-27.txt, .\\technical\\biomed\\1471-2121-1-2.txt, .\\technical\\biomed\\1471-2121-3-10.txt, .\\technical\\biomed\\1471-213X-1-4.txt, .\\technical\\biomed\\1471-2156-2-17.txt, .\\technical\\biomed\\1471-2156-2-3.txt, .\\technical\\biomed\\1471-2156-2-7.txt, .\\technical\\biomed\\1471-2156-3-16.txt, .\\technical\\biomed\\1471-2156-3-4.txt, .\\technical\\biomed\\1471-2164-2-1.txt, .\\technical\\biomed\\1471-2164-2-4.txt, .\\technical\\biomed\\1471-2164-2-7.txt, .\\technical\\biomed\\1471-2164-3-13.txt, .\\technical\\biomed\\1471-2164-3-31.txt, .\\technical\\biomed\\1471-2164-3-35.txt, .\\technical\\biomed\\1471-2164-3-6.txt, .\\technical\\biomed\\1471-2164-3-7.txt, .\\technical\\biomed\\1471-2164-4-14.txt, .\\technical\\biomed\\1471-2164-4-16.txt, .\\technical\\biomed\\1471-2164-4-2.txt, .\\technical\\biomed\\1471-2164-4-21.txt, .\\technical\\biomed\\1471-2164-4-25.txt, .\\technical\\biomed\\1471-2180-1-12.txt, .\\technical\\biomed\\1471-2180-1-31.txt, .\\technical\\biomed\\1471-2180-1-34.txt, .\\technical\\biomed\\1471-2180-2-13.txt, .\\technical\\biomed\\1471-2180-2-38.txt, .\\technical\\biomed\\1471-2180-3-13.txt, .\\technical\\biomed\\1471-2180-3-15.txt, .\\technical\\biomed\\1471-2199-2-12.txt, .\\technical\\biomed\\1471-2199-2-5.txt, .\\technical\\biomed\\1471-2199-3-17.txt, .\\technical\\biomed\\1471-2202-2-12.txt, .\\technical\\biomed\\1471-2202-3-16.txt, .\\technical\\biomed\\1471-2202-3-7.txt, .\\technical\\biomed\\1471-2210-2-14.txt, .\\technical\\biomed\\1471-2229-2-3.txt, .\\technical\\biomed\\1471-2334-3-12.txt, .\\technical\\biomed\\1471-2350-2-2.txt, .\\technical\\biomed\\1471-2350-2-8.txt, .\\technical\\biomed\\1471-2377-3-4.txt, .\\technical\\biomed\\1471-2458-3-5.txt, .\\technical\\biomed\\1471-2474-2-1.txt, .\\technical\\biomed\\1472-6750-1-13.txt, .\\technical\\biomed\\1475-4924-1-5.txt, .\\technical\\biomed\\1477-7827-1-23.txt, .\\technical\\biomed\\ar297.txt, .\\technical\\biomed\\ar409.txt, .\\technical\\biomed\\ar774.txt, .\\technical\\biomed\\bcr570.txt, .\\technical\\biomed\\bcr571.txt, .\\technical\\biomed\\bcr602.txt, .\\technical\\biomed\\bcr631.txt, .\\technical\\biomed\\gb-2000-1-1-research002.txt, .\\technical\\biomed\\gb-2001-2-12-research0054.txt, .\\technical\\biomed\\gb-2001-2-3-research0008.txt, .\\technical\\biomed\\gb-2001-2-4-research0010.txt, .\\technical\\biomed\\gb-2001-2-4-research0011.txt, .\\technical\\biomed\\gb-2001-2-4-research0014.txt, .\\technical\\biomed\\gb-2001-2-6-research0021.txt, .\\technical\\biomed\\gb-2001-2-7-research0025.txt, .\\technical\\biomed\\gb-2001-2-8-research0027.txt, .\\technical\\biomed\\gb-2002-3-10-research0053.txt, .\\technical\\biomed\\gb-2002-3-12-research0079.txt, .\\technical\\biomed\\gb-2002-3-12-research0083.txt, .\\technical\\biomed\\gb-2002-3-6-research0029.txt, .\\technical\\biomed\\gb-2003-4-4-r24.txt, .\\technical\\biomed\\rr196.txt, .\\technical\\plos\\journal.pbio.0020190.txt, .\\technical\\plos\\journal.pbio.0020223.txt";

        Handler handler = new Handler("./technical/");
        assertEquals(expected, handler.handleRequest(new URI("http://localhost:8888/search?q=base%20pair")));
    }

    @Test
    public void testNoSearch() throws IOException, URISyntaxException {
        String expected = "There are 0 files found: ";

        Handler handler = new Handler("./technical/");
        assertEquals(expected, handler.handleRequest(new URI("http://localhost:8888/search?q=nadeshiko")));
    }

    @Test
    public void testList() throws IOException, URISyntaxException {
        String expected = "There are 1391 files to search";

        Handler handler = new Handler("./technical/");
        assertEquals(expected, handler.handleRequest(new URI("http://localhost:8888/")));
    }
}
