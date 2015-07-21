package com.ecerami.test.wsdl;

import junit.framework.*;
import com.ecerami.wsdl.*;
import com.ecerami.wsdl.glue.*;

public class TestWeather_Service extends TestCase {

     public TestWeather_Service (String name) {
         super(name);
     }

    /**
     * Tests Weather Retrieval Via GLUE Interface
     */
    public void testWeatherRetrieval () throws Exception {
      Invoke_Weather invoker = new Invoke_Weather();
      WeatherSummary summary = invoker.getWeatherSummary("KJFK");
      //  Cannot test actual weather data, as this changes.
      //  Hence, test location field.
      assertEquals ("New York, Kennedy International Airport, NY, United States",
        summary.location);
    }

}