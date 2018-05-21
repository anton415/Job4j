package ru.aserdyuchenko.servlet;

import org.junit.Before;
import ru.aserdyuchenko.servlet.ItemServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.mock;

public class ItemServletTest {
    private ItemServlet itemServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter stringWriter;
    private PrintWriter writer;
    private HttpSession session;

    @Before
    public void setUp() {
        session = mock(HttpSession.class);
        itemServlet = new ItemServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);
    }

//    @Test
//    public void testServlet() throws Exception {
//        Mockito.when(response.getWriter()).thenReturn(writer);
//        itemServlet.doGet(request, response);
//        assertEquals("Expected to get index.html but will return " + stringWriter + "\n", "", stringWriter);
//    }

//    @Test
//    public void whenCheckTaskDoneItWillEditDoneFromFalseToTrueInDB() {
//        DataSource storage = new DataSource();
//
//
//
//        assertTrue(storage.getItem().isDone());
//    }

}