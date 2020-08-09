package ru.malychev.junit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
 
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DataServiceTest {
    DataService dataServiceMock = mock(DataService.class);

    @Before
    public void setUp() {
    }

    @Test
    public void saveData() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDataById() {
        when(dataServiceMock.getDataById("idValue")).thenReturn("OK");
        assertEquals("OK", dataServiceMock.getDataById("idValue"));

        when(dataServiceMock
                .getDataById(argThat(id -> id.equals("2") || id.length() > 5)))
                .thenReturn("This.data");

        assertEquals("This.data", dataServiceMock.getDataById("2"));
        assertEquals("This.data", dataServiceMock.getDataById("Гладиолус"));

        when(dataServiceMock.getDataById("invalidId"))
                .thenThrow(IllegalArgumentException.class);
        dataServiceMock.getDataById("invalidId");
    }

    @Test
    public void testGetData() {
        List<String> data = Arrays.asList("First", "Second", "Third");
        when(dataServiceMock.getData()).thenReturn(data);
        assertEquals(data, dataServiceMock.getData());
    }

    @Test
    public void estGetDataListByIds() {
        List<String> args =  Arrays.asList("a", "b", "c", "d");

        when(dataServiceMock.getDataListByIds(any()))
            .then(invocation -> invocation
                .<List<String>> getArgument(0)
                .stream()
                .map(str -> {
                    switch (str) {
                        case "a": return "DateItemA";
                        case "b": return "DateItemB";
                        default: return null;
                    }
                })
                .collect(Collectors.toList()));
        assertEquals(Arrays.asList("DateItemA", "DateItemB", null, null), dataServiceMock.getDataListByIds(args));
    }

    @Test
    public void testGetDataByRequest() {
        DataSearchRequest request = new DataSearchRequest("idValue", new Date(), 18);
        List<String> data = dataServiceMock.getDataByRequest(request);
        assertNotNull(data);
        assertTrue(data.isEmpty());

        ArgumentCaptor<DataSearchRequest> requestCapture = ArgumentCaptor.forClass(DataSearchRequest.class);

        verify(dataServiceMock).getDataByRequest(requestCapture.capture());
        assertEquals(1, requestCapture.getAllValues().size());

        DataSearchRequest argumentRequest = requestCapture.getValue();
        assertNotNull(argumentRequest.getId());
        assertEquals("idValue", argumentRequest.getId());
        assertTrue(argumentRequest.getUpdatedBefore().after(new Date(0L)));
        assertTrue(argumentRequest.getUpdatedBefore().before(new Date()));
        assertEquals(18, argumentRequest.length);
    }
}