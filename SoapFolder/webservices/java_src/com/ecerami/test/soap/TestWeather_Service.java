package com.ecerami.test.soap;

import junit.framework.*;
import com.ecerami.soap.*;

public class TestWeather_Service extends TestCase {

     public TestWeather_Service (String name) {
         super(name);
     }

    /**
     * Tests Weather Service
     */
    public void testWeather () throws Exception {
      WeatherClient client = new WeatherClient();
      int temperature = client.getWeather("10016");
      assertEquals (65, temperature);
    }

}