// generated by GLUE

package com.ecerami.wsdl.glue;

public interface IAirportWeather
  {
  String getLocation( String arg0 );
  String getWind( String arg0 );
  String getSkyConditions( String arg0 );
  String getVisibility( String arg0 );
  String getTemperature( String arg0 );
  String getPressure( String arg0 );
  String getHumidity( String arg0 );
  WeatherSummary getSummary( String arg0 );
  String getOb( String arg0 );
  }