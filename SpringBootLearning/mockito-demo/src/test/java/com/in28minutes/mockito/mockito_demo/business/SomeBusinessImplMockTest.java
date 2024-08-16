package com.in28minutes.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    void testFindTheGreatestFromAllData_basicScenario() {
        // DataService dataServiceMock = mock(DataService.class);   // 加入 mock anotation 後不需要
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});

        // SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);   // 加入 mock anotation 後不需要
        assertEquals(25, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void testFindTheGreatestFromAllData_OneValue() {
        // DataService dataServiceMock = mock(DataService.class);   // 加入 mock anotation 後不需要
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});

        // SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);   // 加入 mock anotation 後不需要
        assertEquals(35, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void testFindTheGreatestFromAllData_EmptyArray() {
        // DataService dataServiceMock = mock(DataService.class);   // 加入 mock anotation 後不需要
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});

        // SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);   // 加入 mock anotation 後不需要
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
}



